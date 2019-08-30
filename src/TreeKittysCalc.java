import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TreeKittysCalc {
    private static final long mod = (long) Math.pow(10, 9) + 7;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().trim().split(" ");
        int n = Integer.parseInt(str[0]);
        int q = Integer.parseInt(str[1]);
        Tree tree = new Tree(n);
        for (int i = 1; i < n; i++) {
            str = reader.readLine().trim().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            tree.addEdge(a, b);
        }
        tree.updateDistMap();
        for (int i = 0; i < q; i++) {
            long result = 0;
            int l = Integer.parseInt(reader.readLine().trim());
            int[] que = new int[l];
            str = reader.readLine().trim().split(" ");
            for (int j = 0; j < l; j++) {
                que[j] = Integer.parseInt(str[j]);
            }
            for (int j = 0; j < l; j++) {
                for (int k = j + 1; k < l; k++) {
                    long prod = (long) (que[j] * que[k]) % mod;
                    prod = (prod * tree.getDistance(que[j], que[k])) % mod;
                    result = (result + prod) % mod;
                }
            }
            System.out.println(result);
        }
    }

    static class Tree {
        Map<Integer, Set<Integer>> adjMap;
        Map<Integer, Map<Integer, Long>> distMap;
        int size;

        public Tree(int n) {
            size = n;
            adjMap = new HashMap<>();
            distMap = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                adjMap.put(i, new HashSet<>());
                distMap.put(i, new HashMap<>());
            }
        }

        public void addEdge(int a, int b) {
            adjMap.get(a).add(b);
            adjMap.get(b).add(a);
            distMap.get(a).put(b, 1L);
            distMap.get(b).put(a, 1L);
        }

        public void updateDistMap() {
            for (int i = 1; i <= size; i++) {
                Set<Integer> set = new HashSet<>();
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                set.add(i);
                distMap.get(i).put(i, 0L);
                while (!queue.isEmpty()) {
                    int curr = queue.remove();
                    for (int adj : adjMap.get(curr)) {
                        if (!set.contains(adj)) {
                            set.add(adj);
                            distMap.get(i).put(adj, distMap.get(i).get(curr) + 1);
                            distMap.get(adj).put(i, distMap.get(i).get(curr) + 1);
                            queue.add(adj);
                        }
                    }
                }
            }
        }

        public long getDistance(int a, int b) {
            return distMap.get(a).get(b);
        }
    }
}

