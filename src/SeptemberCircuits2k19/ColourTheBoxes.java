package SeptemberCircuits2k19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ColourTheBoxes {
    public static final long mod = (long) Math.pow(10, 9) + 7;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tok = reader.readLine().split(" ");
        long n = Long.parseLong(tok[0]);
        long m = Long.parseLong(tok[1]);
        long res = fact(m);
        System.out.println(res);
    }

    public static long fact(long n) {
        long prod = 1;
        for (long i = 2; i <= n; i++) {
            prod = (prod * i) % mod;
        }
        return prod;
    }
}
