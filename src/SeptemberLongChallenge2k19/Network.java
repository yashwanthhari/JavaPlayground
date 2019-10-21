package SeptemberLongChallenge2k19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Network {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            String[] tok = reader.readLine().split(" ");
            long n = Long.parseLong(tok[0]);
            long m = Long.parseLong(tok[1]);
            if (n == 1) {
                if (m == 1 || m == 0) System.out.println(m);
                else System.out.println(-1);
                continue;
            }
            if (n == 2) {
                if (m >= 1 && m <= 3)
                    System.out.println((m == 1) ? 1 : 2);
                else System.out.println(-1);
                continue;
            }
            if (m < n - 1) {
                System.out.println(-1);
                continue;
            }
            double half = n / 2.0;
            long max = (n * (n - 1)) / 2;
            if (m - n > max) {
                System.out.println(-1);
                continue;
            }
            if (m <= n + 1) {
                System.out.println(2);
                continue;
            }
            if (m <= 2 * n) {
                System.out.println(3);
                continue;
            }
            double numerator = (m - (n * 2)) / half;
            System.out.println((long) (3 + Math.ceil(numerator)));
        }
    }
}
