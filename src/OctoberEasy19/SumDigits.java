package OctoberEasy19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumDigits {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tok = reader.readLine().split(" ");
        long a = Long.parseLong(tok[0]);
        long b = Long.parseLong(tok[0]);
        long k = Long.parseLong(tok[0]);
        if (a % k != 0) {
            a += (k - a % k);
        }
        long temp = a;
        for (long i = a; i <= b; i += k) {

        }
    }
}
