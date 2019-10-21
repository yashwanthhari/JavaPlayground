package SeptemberCircuits2k19;

import java.io.IOException;
import java.util.Scanner;

public class SpecialSets {
    public static final long mod = (long) Math.pow(10, 9) + 7L;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] dp = new long[n + 1][n + 1];
        dp[1][1] = 1;
        if (n >= 2) {
            dp[2][1] = 2;
            dp[2][2] = 0;
        }
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i - 1][j] + ((j == 1) ? 1 : (dp[i - 2][j - 1]))) % mod;
            }
        }
        long pro = 1;
        long res = 0;
        for (int i = 1; i <= n; i++) {
            pro = (pro * i) % mod;
            res = (res + (dp[n][i] * pro) % mod) % mod;
        }
        System.out.println(res);
    }
}
