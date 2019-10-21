package OctLongChall19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SAKTAN {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            String[] tok = reader.readLine().split(" ");
            int n = Integer.parseInt(tok[0]);
            int m = Integer.parseInt(tok[1]);
            int q = Integer.parseInt(tok[2]);
            int[] r = new int[n];
            int[] c = new int[m];
            while (q-- > 0) {
                tok = reader.readLine().split(" ");
                r[Integer.parseInt(tok[0]) - 1]++;
                c[Integer.parseInt(tok[1]) - 1]++;
            }
            long oddr = 0L;
            long oddc = 0L;
            for (int i = 0; i < n; i++) {
                if (r[i] % 2 != 0) oddr++;
            }
            for (int i = 0; i < m; i++) {
                if (c[i] % 2 != 0) oddc++;
            }
            System.out.println((oddr * (m - oddc)) + ((n - oddr) * oddc));
        }
    }
}
