package DecCodechef2k19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BINADD {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String x = br.readLine();
            String y = br.readLine();
            if ((allZeros(y))) {
                System.out.println(0);
            } else {
                System.out.println(add(x, y));
            }
        }
    }

    private static boolean allZeros(String y) {
        for (int i = 0; i < y.length(); i++) {
            if (y.charAt(i) == '1') return false;
        }
        return true;
    }

    private static int add(String x, String y) {
        int i = x.length() - 1;
        int j = y.length() - 1;
        boolean carry = false;
        int count = 0;
        int res = 1;
        while (i >= 0 && j >= 0) {
            if (x.charAt(i) == y.charAt(j)) {
                if ((carry && x.charAt(i) == '0') || (x.charAt(i) == '1' && !carry)) {
                    count++;
                    res = Math.max(res, count);
                }
                carry = x.charAt(i) == '1';
                if (!carry) count = 0;
            } else if (carry) {
                count++;
                res = Math.max(res, count);
            }
            i--;
            j--;
        }
        if (carry) {
            while (i >= 0 && carry) {
                count++;
                res = Math.max(res, count);
                if (x.charAt(i) == '0') {
                    carry = false;
                    count = 0;
                }
                i--;
            }
            while (j >= 0 && carry) {
                count++;
                res = Math.max(res, count);
                if (y.charAt(j) == '0') {
                    carry = false;
                    count = 0;
                }
                j--;
            }
        }
        if (carry) count++;
        res = Math.max(res, count);
        return res;
    }
}
