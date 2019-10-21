package SeptemberLongChallenge2k19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class InterestingSubsequences {

    private static long comb(double n, double r) {
        r = Math.min(r, n - r);
        double res = 1;
        for (int i = 0; i < r; i++) {
            res *= (n - i) / (r - i);
        }
        return Math.round(res);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            String[] tok = reader.readLine().split(" ");
            int n = Integer.parseInt(tok[0]);
            int k = Integer.parseInt(tok[1]);
            tok = reader.readLine().split(" ");
            Map<Integer, Integer> map = new HashMap<>();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(tok[i]);
                if (map.containsKey(arr[i])) {
                    map.put(arr[i], map.get(arr[i]) + 1);
                } else map.put(arr[i], 1);
            }
            Arrays.sort(arr);
            int i = k - 1;
            int count = 0;
            while (i >= 0 && arr[i] == arr[k - 1]) {
                count++;
                i--;
            }
//            System.out.println(map.get(arr[k - 1]) + " " + count);
            System.out.println(comb(map.get(arr[k - 1]), count));
        }
    }
}
