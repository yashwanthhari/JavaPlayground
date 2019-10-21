import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class CompletableFutureExample {

    private Executor executor; // Autowire your executor here
    private List<Integer> integerList;

    public static void main(String[] args) throws IOException {
        CompletableFuture.completedFuture(null).join();
        CompletableFutureExample example = new CompletableFutureExample();
        example.init();
        List<Integer> resultList = example.process().join();
        resultList.forEach(System.out::println);
    }

    private void init() {
        this.integerList = new ArrayList<>();
        this.executor = Executors.newFixedThreadPool(50);
        int n = (int) Math.floor(Math.random() * 100);

        for (int i = 1; i <= n; i++) {
            integerList.add((int) Math.floor(Math.random() * n));
        }
    }

    private CompletableFuture<List<Integer>> process() {
        List<CompletableFuture<Integer>> completableFutures = this.integerList.stream().map(integer -> {
            // sync op
            return CompletableFuture.supplyAsync(() -> getVal(integer), executor).handle((response, throwable) -> {
                if (throwable == null) {
                    return response;
                }
                // handle exception by retry or mark as Failure
                if (throwable instanceof SQLException) {    // Some base case
                    return null;
                }
                // fallback result
                return null;
            });
        }).collect(Collectors.toList());
        CompletableFuture<?> allFutures = CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0]));
        return allFutures.thenApply((future) ->
                completableFutures.stream()
                        .map(CompletableFuture::join)
                        .collect(Collectors.toList())
        );
    }

    private CompletableFuture<Integer> integerCompletableFuture(int x) {
        return CompletableFuture.supplyAsync(() -> getVal(x), executor);
    }

    private int getVal(int x) {
        throw new RuntimeException();
//        return (int) Math.floor(Math.random() * x);
    }
}
