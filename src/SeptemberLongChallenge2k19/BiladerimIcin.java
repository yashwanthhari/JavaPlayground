package SeptemberLongChallenge2k19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BiladerimIcin {
    private final static int mod = (int) Math.pow(10, 9) + 7;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            String[] tok = reader.readLine().split(" ");
            long A = Long.parseLong(tok[0]);
            long B = Long.parseLong(tok[1]);
            long C = Long.parseLong(tok[2]);
            long res = 0;
            for (int b = 1; b <= B; b++) {
                for (long a = 2; a <= b + 1; a++) {
                    long min = (long) Math.ceil((double) (b * b + 1) / (a - 1)) + 1;
//                    System.out.println(String.format("B: %d, A/C: %d, min: %d", b, a, min));
                    if (min <= C && a <= A) {
//                        System.out.println(String.format("B: %d, A: %d, Count: %d", b, a, (C - min + 1)));
                        res = (res + (C - min + 1) % mod) % mod;
                    }
                    if (min <= A && a <= C) {
//                        System.out.println(String.format("B: %d, C: %d, Count: %d", b, a, (A - min + 1)));
                        res = (res + (A - min + 1) % mod) % mod;
                    }
                }
                if (A > b + 1 && C > b + 1) {
//                    System.out.println(String.format("B: %d, A: %d, RangeCount: %d", b, A, (A - (b + 1)) * (C - (b + 1))));
                    res = (res + ((A - (b + 1)) * (C - (b + 1))) % mod) % mod;
                }
            }
            System.out.println(res);
        }
    }
}

