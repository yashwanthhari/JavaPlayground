package NovemberChallenge2k19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HRDSEQ {
    public static final int[] sol = {0, 0, 1, 0, 2, 0, 2, 2, 1, 6, 0, 5, 0, 2, 6, 5, 4, 0, 5, 3, 0, 3, 2, 9, 0, 4, 9, 3, 6, 14, 0, 6, 3, 5, 15, 0, 5, 3, 5, 2, 17, 0, 6, 11, 0, 3, 8, 0, 3, 3, 1, 42, 0, 5, 15, 20, 0, 4, 32, 0, 3, 11, 18, 0, 4, 7, 0, 3, 7, 3, 2, 31, 0, 6, 31, 3, 6, 3, 2, 8, 33, 0, 9, 56, 0, 3, 8, 7, 19, 0, 5, 37, 0, 3, 8, 8, 1, 46, 0, 6, 23, 0, 3, 9, 21, 0, 4, 42, 56, 25, 0, 5, 21, 8, 18, 52, 0, 6, 18, 4, 13, 0, 5, 11, 62, 0, 4, 7, 4};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        Map<Integer, List<Integer>> listMap = new HashMap<>();
        Map<Integer, Integer> posMap = new HashMap<>();
        for (int i = 0; i < sol.length; i++) {
            posMap.put(i, sol[i]);
            if (!listMap.containsKey(sol[i])) {
                listMap.put(sol[i], new ArrayList<>());
            }
            listMap.get(sol[i]).add(i);
        }
        while (t-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            int count = 0;
            for (int pos : listMap.get(posMap.get(n - 1))) {
                if (pos >= n) break;
                count++;
            }
            System.out.println(count);
        }
    }
}
