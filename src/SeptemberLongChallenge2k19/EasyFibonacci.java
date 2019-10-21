package SeptemberLongChallenge2k19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EasyFibonacci {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            long n = Long.parseLong(reader.readLine());
            if (n == 1) {
                System.out.println(0);
                continue;
            }
            if (n < 4) {
                System.out.println(1);
                continue;
            }
            int index = 0;
            while (n > 1) {
                n >>= 1;
                index++;
            }
            int[] res = {2, 3, 0, 9};
            System.out.println(res[(index - 2) % 4]);
        }
    }
}
