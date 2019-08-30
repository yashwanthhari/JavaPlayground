import java.io.BufferedReader;
import java.io.InputStreamReader;

class TestClass {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(reader.readLine());
        while (tc-- > 0) {
            String[] ip = reader.readLine().split(" ");
            int n = Integer.parseInt(ip[0]);
            int m = Integer.parseInt(ip[1]);
            int[] a = new int[n + 1];
            int[] b = new int[m + 1];
            int[] res = new int[n + 1];
            ip = reader.readLine().split(" ");
            String[] ip2 = reader.readLine().split(" ");
            for (int i = 1; i <= m; i++) {
                b[i] = Integer.parseInt(ip2[i - 1]);
                for (int j = i; j <= n; j += i) {
                    if (res[j] > 0)
                        continue;
                    a[j] = (a[j] > 0) ? a[j] : Integer.parseInt(ip[j - 1]);
                    res[j] = -1;
                    if (a[j] <= b[i]) {
                        res[j] = i;
                    }
                }
            }
            for (int i = 1; i <= n; i++) {
                System.out.println(res[i]);
            }
        }
    }
}
