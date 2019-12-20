package OctoberCircuits19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            String[] tok = reader.readLine().split(" ");
            long a = Long.parseLong(tok[0]);
            long b = Long.parseLong(tok[1]);
            long n = Long.parseLong(tok[2]);
            n = (n - 1) % 3;
            if (n == 0) {
                System.out.println(a);
            } else if (n == 1) {
                System.out.println(b);
            } else {
                long max = Math.max(a, Math.max(b, a ^ b));
                long val = 1 << 3;
                while (val <= max) {
                    val <<= 1;
                }
//                System.out.println(String.format("msb: %d, xnor: %d", val, ~(a ^ b)));
                System.out.println(Math.max(a ^ b, val + (~(a ^ b))));
            }
        }
    }
}
