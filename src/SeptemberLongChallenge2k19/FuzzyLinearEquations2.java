package SeptemberLongChallenge2k19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FuzzyLinearEquations2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] tok = reader.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tok[i]);
        }
        int q = Integer.parseInt(reader.readLine());
        int[] gcd = new int[n];
        gcd[0] = arr[0];
        for (int i = 1; i < n; i++) {
            gcd[i] = gcd(gcd[i - 1], arr[i]);
        }
        for (int qc = 0; qc < q; qc++) {
            int quer = Integer.parseInt(reader.readLine());
            long res = 0;
            for (int i = 0; i < n; i++) {
                if (quer % gcd[i] == 0) {
                    System.out.println("Add " + ((i + 1) * (n - i)) + " for " + i);
                    res += ((i + 1) * (n - i));
                    break;
                }
            }
            System.out.println(res);
        }
    }

    private static int gcd(int a, int b) {
        if (a < b) return gcd(b, a);
        if (a % b == 0) return b;
        return gcd(a, a % b);
    }
}
