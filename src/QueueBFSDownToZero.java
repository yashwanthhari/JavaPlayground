import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class QueueBFSDownToZero {


    private static final Scanner scanner = new Scanner(System.in);

    static int downToZero(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        Map<Integer, Integer> distanceMap = new HashMap<>();
        distanceMap.put(n, 0);
        while(!queue.isEmpty()){
            int curr = queue.remove();
            if(!distanceMap.containsKey(curr - 1)){
                distanceMap.put(curr - 1, distanceMap.get(curr) + 1);
                if(curr - 1 == 0){
                    break;
                }
                queue.add(curr - 1);
            }
            for(int i=2; i <= Math.sqrt(curr) + 1; i++){
                if(curr%i == 0){
                    int fact = Math.max(i, curr/i);
                    if(!distanceMap.containsKey(fact)){
                        distanceMap.put(fact, distanceMap.get(curr) + 1);
                        queue.add(fact);
                    }
                }
            }
        }
        return distanceMap.get(0);
    }

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(scanner.nextLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            int n = Integer.parseInt(scanner.nextLine().trim());

            int result = downToZero(n);
            System.out.println(result);

//            bufferedWriter.write(String.valueOf(result));
//            bufferedWriter.newLine();
        }

//        bufferedWriter.close();
    }
}
