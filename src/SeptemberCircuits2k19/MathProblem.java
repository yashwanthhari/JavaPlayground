package SeptemberCircuits2k19;

public class MathProblem {
    public static final long mod = (long) Math.pow(10, 9) + 7L;

    public static void main(String[] args) throws Exception {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        int T = Integer.parseInt(reader.readLine());
//        for (int t = 0; t < T; t++) {
//            String[] tok = reader.readLine().split(" ");
//            int p = Integer.parseInt(tok[0]);
//            int q = Integer.parseInt(tok[1]);
//            int n = Integer.parseInt(tok[2]);
//            System.out.println(calc(p, q, n));
//        }
        int even = 0;
        int odd = 0;
        int sq = 0;
        for (int i = 1; i <= 910; i++) {
            int ftemp = (int) ftemp(i);
            if (ftemp < 0) odd++;
            else if (ftemp == 0) sq++;
            else even++;
//            System.out.println(String.format("i = %d, ftemp = %d", i, ftemp));

        }
        System.out.println("even = " + even + " odd = " + odd + " sq = " + sq);
    }

    private static boolean isPrime(int n) {
        if (n <= 1) return false;

        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0)
                return false;

        return true;
    }

    private static double ftemp(double d) {
        if (d == 1)
            return 1;
        int temp = 0;
        for (int p = 2; p <= d; p++) {
            if (d % p == 0 && isPrime(p)) {
                if (d % (p * p) == 0) return 0;
                temp++;
            }
        }
        if (temp % 2 == 0)
            return 1;
        return -1;
    }

    private static long calc(int p, int q, int n) {
        long ans = 0;
        for (int i = 1; i <= n; i++) {
//            System.out.println("i: " + i);
            for (int m = p; m <= q; m++) {
                if (isPrime(m)) {
//                    System.out.println("for p " + m);
                    for (int j = 1; j <= (n / i); j++) {
//                        System.out.println("For j" + j);
                        for (double d = 1; d <= m * j; d++) {
                            if ((m * j) % d == 0) {
                                double val = ftemp(d) / d;
//                                System.out.println(String.format("for d=%f, ftemp=%f, val=%f", d, ftemp(d), val));
                                double h = ((val * m) % mod);
                                if (h < 0) h += mod;
                                double v = (h * j) % mod;
                                if (v < 0) v += mod;
//                                System.out.println("Add v=" + (val * m * j) + " sign=" + (j % 2 != 0));
                                if (j % 2 != 0) ans = (long) ((ans - v) % mod);
                                else ans = (long) ((ans + v) % mod);
                                if (ans < 0) ans += mod;
//                                System.out.println("ans " + ans);
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
}
