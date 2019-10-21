package SeptemberLongChallenge2k19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class GoodSubsequences {
    private static final int mod = (int) Math.pow(10, 9) + 7;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tok = reader.readLine().split(" ");
        int n = Integer.parseInt(tok[0]);
        int K = Integer.parseInt(tok[1]);
        tok = reader.readLine().split(" ");
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long temp = Integer.parseInt(tok[i]);
            if (map.containsKey(temp)) {
                map.put(temp, map.get(temp) + 1);
            } else map.put(temp, 1);
        }
        long[][] dp = new long[K + 1][map.size() + 1];
        long res = 1;
        Long[] val = map.keySet().toArray(new Long[0]);
        int l = val.length;
//        System.out.println(String.format("%d distinct numbers", l));
        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= l; j++) {
                if (i == 1)
                    dp[i][j] = map.get(val[j - 1]);
                else {
                    for (int k = j + 1; k <= l + 1; k++) {
//                        System.out.println(String.format("%d, %d at %d,%d,%d", dp[i - 1][k], dp[i][j], i, j, k));
                        dp[i][j] = (dp[i - 1][k] + dp[i][j]) % mod;
                    }
//                    System.out.println(String.format("mul val: %d", map.get(val[j - 1])));
                    dp[i][j] = (dp[i][j] * map.get(val[j - 1])) % mod;
                }
                res = (res + dp[i][j]) % mod;
            }
            l--;
        }
//        l = val.length;
//        for (int i = 1; i <= K; i++) {
//            for (int j = 1; j <= l && j <= K; j++) {
////                System.out.println(String.format("i: %d, j: %d, dp: %d", i, j, dp[i][j]));
//            }
//            l--;
//        }
        System.out.println(res);
    }
}
