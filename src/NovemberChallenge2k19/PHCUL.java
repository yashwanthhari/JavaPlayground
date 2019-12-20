package NovemberChallenge2k19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PHCUL {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            String[] tok = reader.readLine().split(" ");
            int x = Integer.parseInt(tok[0]);
            int y = Integer.parseInt(tok[1]);
            tok = reader.readLine().split(" ");
            int n = Integer.parseInt(tok[0]);
            int m = Integer.parseInt(tok[1]);
            int K = Integer.parseInt(tok[2]);
            int[] a = new int[n];
            int[] b = new int[n];
            int[] c = new int[m];
            int[] d = new int[m];
            int[] e = new int[K];
            int[] f = new int[K];
            tok = reader.readLine().split(" ");
            int l = 0;
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(tok[l++]);
                b[i] = Integer.parseInt(tok[l++]);
            }
            l = 0;
            tok = reader.readLine().split(" ");
            for (int i = 0; i < m; i++) {
                c[i] = Integer.parseInt(tok[l++]);
                d[i] = Integer.parseInt(tok[l++]);
            }
            l = 0;
            tok = reader.readLine().split(" ");
            for (int i = 0; i < K; i++) {
                e[i] = Integer.parseInt(tok[l++]);
                f[i] = Integer.parseInt(tok[l++]);
            }
            double res = Double.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    double dis = distance(a[i], b[i], c[j], d[j]);
                    double dis1 = dis + distance(x, y, a[i], b[i]);
                    double dis2 = dis + distance(x, y, c[j], d[j]);
                    for (int k = 0; k < K; k++) {
                        res = Math.min(res, dis1 + distance(e[k], f[k], c[j], d[j]));
                        res = Math.min(res, dis2 + distance(e[k], f[k], a[i], b[i]));
                    }
                }
            }
            System.out.printf("%.10f", res);
            System.out.println();
        }
    }

    private static double distance(long x1, long y1, long x2, long y2) {
        return Math.sqrt(((x1 - x2) * (x1 - x2)) + ((y1 - y2) * (y1 - y2)));
    }
}
