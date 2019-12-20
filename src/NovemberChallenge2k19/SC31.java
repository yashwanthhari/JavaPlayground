package NovemberChallenge2k19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SC31 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            int res = 0;
            while (n-- > 0) {
                res = res ^ Integer.parseInt(reader.readLine(), 2);
            }
            int count = 0;
            while (res > 0) {
                if (res % 2 != 0) count++;
                res /= 2;
            }
            System.out.println(count);
        }
    }
}
