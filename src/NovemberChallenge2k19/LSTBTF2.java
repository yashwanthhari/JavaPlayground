package NovemberChallenge2k19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LSTBTF2 {
    public static final int[] squares = {1, 4, 9, 16, 25, 36, 49, 64, 81};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        Map<Integer, Map<Integer, List<Integer>>> map = new HashMap<>();
        for (int sq : squares) {
            Map<Integer, List<Integer>> listMap = new HashMap<>();
            List<Integer> list = new ArrayList<>();
            list.add(sq);
            listMap.put(1, list);
            map.put(sq, listMap);
        }
        for (int i = 1; i <= 100; i++) {
            for (int sq : squares) {
                if (i - sq < 0) break;
                if (i != sq && map.containsKey(i - sq)) {
                    if (!map.containsKey(i)) {
                        map.put(i, new HashMap<>());
                    }
                    Map<Integer, List<Integer>> tempRef = map.get(i - sq);
                    for (int j = 1; j <= 4; j++) {
                        if (tempRef.containsKey(j)) {
                            List<Integer> list = new ArrayList<>(tempRef.get(j));
                            list.add(sq);
                            Collections.sort(list);
                            map.get(i).put(j + 1, list);
                        }
                    }
                }
            }
        }
        while (t-- > 0) {
            StringBuilder sb = new StringBuilder();
            int n = Integer.parseInt(reader.readLine());
            if (isPerfectSquare(n)) {
                for (int i = 0; i < n; i++) {
                    sb.append("1");
                }
            }
            System.out.println(sb.toString());
        }
    }

    private static boolean isPerfectSquare(int n) {
        int sq = (int) Math.sqrt(n);
        return sq * sq == n;
    }
}
