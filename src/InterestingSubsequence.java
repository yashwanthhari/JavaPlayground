
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author vmlinuz_2
 * Solution is at the Top
 */
class InterestingSubsequence {

    private void solve() {
        int n = inpi();
        int[][] dp = new int[n + 1][30]; /* 1 << 30*/
        initializeGCD(inpia(n), dp, n);
        Map<Integer, Long> map = generateQueries(dp, n);
        IntStream.range(0, inpi()).forEach((i) -> {
            out.println(getQueryResolved(inpi(), map));
        });
    }


    private static long getQueryResolved(int query, Map<Integer, Long> map) {
        long result = 0L;
        for (int factor = 1; factor <= Math.sqrt(query); factor++) {
            if (query % factor == 0) {
                if (query / factor != factor) {
                    result += map.getOrDefault(factor, 0L) + map.getOrDefault(query / factor, 0L);
                } else {
                    result += map.getOrDefault(factor, 0L);
                }
            }
        }
        return result;
    }


    private Map<Integer, Long> generateQueries(int[][] dp, int n) {
        Map<Integer, Long> map = new HashMap<>();
        int left, right, mid, generated;
        for (int x = 1; x <= n; x++) {
            for (int y = x; y <= n; y = left + 1) {
                generated = resolveQuery(dp, x, y);
                for (left = y, right = n + 1; left + 1 < right; ) {
                    mid = (left + right) >> 1;
                    if (resolveQuery(dp, x, mid) != generated) {
                        right = mid;
                    } else {
                        left = mid;
                    }
                }
                map.put(generated, map.getOrDefault(generated, 0L) + (left - y + 1));
            }
        }
        return map;
    }

    private static void initializeGCD(int[] input, int[][] dp, int n) {
        initDpArray(input, dp, n);
        for (int i = 1; (1 << i) <= n; i++) {
            for (int j = 1; j + (1 << i) <= n + 1; j++) {
                dp[j][i] = getGCD(dp[j][i - 1], dp[j + (1 << (i - 1))][i - 1]);
            }
        }

    }

    private static void initDpArray(int[] input, int[][] dp, int n) {
        for (int i = 1; i <= n; i++) {
            dp[i][0] = input[i - 1];
        }
    }


    private int resolveQuery(int[][] dp, int l, int r) {
        int d = (int) (Math.log10(r - l + 1) / Math.log10(2));
        return getGCD(dp[l][d], dp[r - (1 << d) + 1][d]);
    }


    private static int getGCD(int a, int b) {
        if (b == 0)
            return a;
        return getGCD(b, a % b);
    }

    public boolean isPrime(long n) {
        return BigInteger.valueOf(n).isProbablePrime(5);
    }

    public void SieveOfEratosthenes(int n) {
        boolean prime[] = new boolean[n + 1];
        Arrays.fill(prime, true);
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * 2; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }
        // Print all prime numbers
        for (int p = 2; p <= n; p++) {
            if (prime[p]) {
                //  System.out.print(p+" ");
                // primes[p] = true;
            }
        }
        // return list;
    }

    InputStream obj;
    PrintWriter out;
    String check = "";

    public static void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new InterestingSubsequence().main1();
                } catch (IOException ex) {
                    Logger.getLogger(InterestingSubsequence.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }, "1", 1 << 26).start();

    }

    void main1() throws IOException {
        out = new PrintWriter(System.out);
        obj = check.isEmpty() ? System.in : new ByteArrayInputStream(check.getBytes());
        solve();
        out.flush();
        out.close();
    }

    private byte[] inbuffer = new byte[1024];
    private int lenbuffer = 0, ptrbuffer = 0;

    int readByte() {
        if (lenbuffer == -1) {
            throw new InputMismatchException();
        }
        if (ptrbuffer >= lenbuffer) {
            ptrbuffer = 0;
            try {
                lenbuffer = obj.read(inbuffer);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
        }
        if (lenbuffer <= 0) {
            return -1;
        }
        return inbuffer[ptrbuffer++];
    }

    boolean isSpaceChar(int c) {
        return (!(c >= 33 && c <= 126));
    }

    int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b)) ;
        return b;
    }

    String inps() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!(isSpaceChar(b))) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    int inpi() {
        int num = 0, b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }
        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    long inpl() {
        long num = 0;
        int b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }
        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    float inpf() {
        return Float.parseFloat(inps());
    }

    double inpd() {
        return Double.parseDouble(inps());
    }

    char inpc() {
        return (char) skip();
    }

    int[] inpia(int n) {
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = inpi();
        }
        return a;
    }

    long[] inpla(int n) {
        long a[] = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = inpl();
        }
        return a;
    }

    String[] inpsa(int n) {
        String a[] = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = inps();
        }
        return a;
    }

    double[][] inpdm(int n, int m) {
        double a[][] = new double[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = inpd();
            }
        }
        return a;
    }

    int[][] inpim(int n, int m) {
        int a[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = inpi();
            }
        }
        return a;
    }
}