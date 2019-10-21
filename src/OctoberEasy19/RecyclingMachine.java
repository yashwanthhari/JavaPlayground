package OctoberEasy19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class RecyclingMachine {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            String[] tok = reader.readLine().split(" ");
            BigInteger n = new BigInteger(tok[0]);
            BigInteger k = new BigInteger(tok[1]);
            BigInteger res = new BigInteger("0");
            while (n.compareTo(k) > 0) {
                BigInteger quo = n.divide(k);
                res = res.add(quo);
                n = quo.add(n.mod(k));
            }
            System.out.println(res);
        }
    }
}
