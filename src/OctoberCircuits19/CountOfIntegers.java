package OctoberCircuits19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CountOfIntegers {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        boolean[] prime = new boolean[(int) 1e8 + 1];
        Arrays.fill(prime, true);
        prime[1] = false;
        for (int i = 2; i * i <= 1e8; i++) {
            if (prime[i]) {
                for (int j = i * i; j > 0 && j <= 1e8; j += i) {
                    prime[j] = false;
                }
            }
        }
        while (t-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            int count = 0;
            String[] tok = reader.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(tok[i]);
                if (prime[x]) count++;
            }
            System.out.println(count);
        }
    }
}
