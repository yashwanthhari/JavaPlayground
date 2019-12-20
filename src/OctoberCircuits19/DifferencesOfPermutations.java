package OctoberCircuits19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DifferencesOfPermutations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            System.out.println(fact(n) * (n - 1) * n / 2);
        }
    }

    public static long fact(long n) {
        long prod = 1;
        for (long i = 2; i <= n; i++) {
            prod = (prod * i);
        }
        return prod;
    }
}
