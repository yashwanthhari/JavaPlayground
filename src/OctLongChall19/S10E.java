package OctLongChall19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S10E {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            String[] tok = reader.readLine().split(" ");
            int[] a = new int[n];
            int[] prev = new int[n + 1];
            int count = 0;
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(tok[i]);
                if (i == 0) {
                    prev[i] = 0;
                    count++;
                    continue;
                }
                if (a[i] < a[i - 1]) {
                    prev[i] = i - 1;
                    prev[i] = findPrev(i, i - 1, prev, a);
                } else {
                    prev[i] = i;
                }
                if ((i <= 5 && prev[i] == 0) || (i - prev[i] >= 5))
                    count++;
            }
            System.out.println(count);
        }
    }

    private static int findPrev(int i, int ip, int[] prev, int[] a) {
        int before = prev[ip];
        if (before != ip) {
            prev[i] = before;
            findPrev(i, before, prev, a);
        } else if (ip > 0 && a[i] < a[ip - 1]) {
            prev[i] = ip - 1;
            findPrev(i, ip - 1, prev, a);
        }
        return prev[i];
    }
}
