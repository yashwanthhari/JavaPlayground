package SeptemberCircuits2k19;

import java.util.Arrays;

public class Partitions {
    public static final long mod = (long) Math.pow(10, 9) + 7L;

    public static void main(String[] args) {
        for (int i = 1; i <= 5000; i++) {
            System.out.println(countWays(i));
        }
//        System.out.println(countWays(10));
    }

    static long countWays(int n) {

        // table[i] will be storing the
        // number of solutions for value
        // i. We need n+1 rows as the
        // table is consturcted in bottom
        // up manner using the base case
        // (n = 0)
        long[] table = new long[n + 1];

        // Initialize all table values as 0
        Arrays.fill(table, 0);

        // Base case (If given value is 0)
        table[0] = 1;

        // Pick all integer one by one and
        // update the table[] values after
        // the index greater than or equal
        // to n
        for (int i = 1; i <= n; i++)
            for (int j = i; j <= n; j++) {
                table[j] = (table[j] + table[j - i]) % mod;
//                System.out.println(i+" "+j + " " + table[j]);
            }

        return table[n];
    }
}
