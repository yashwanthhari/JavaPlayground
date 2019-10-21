package OctLongChall19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MARM {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            String[] tok = reader.readLine().split(" ");
            long n = Long.parseLong(tok[0]);
            long k = Long.parseLong(tok[1]);
            tok = reader.readLine().split(" ");
            long[] a = new long[(int) n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(tok[i]);
            }
            for (int i = 0; i < n; i++) {
                long x = (k > n ? (k / n + (k % n - 1 >= i ? 1 : 0)) : (k - 1 >= i) ? 1 : 0) % 3;
//                System.out.println(String.format("For %d, times = %d", i, x));
                if (x == 0) {
                    if (n % 2 != 0 && i == n / 2 && k >= n / 2) System.out.println("0 ");
                    else System.out.print(a[i] + " ");
                } else if (x == 1) {
                    if (i < (n + 1) / 2) System.out.print((a[i] ^ a[(int) n - i - 1]) + " ");
                    else System.out.print(a[(int) n - i - 1] + " ");
                } else if (x == 2) {
                    if (i < n / 2) System.out.print(a[(int) n - i - 1] + " ");
                    else System.out.print((a[i] ^ a[(int) n - i - 1]) + " ");
                }
            }
        }
    }
}
