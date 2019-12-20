package OctoberCircuits19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestArithematicSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tok = reader.readLine().split(" ");
        int n = Integer.parseInt(tok[0]);
        int k = Integer.parseInt(tok[1]);
        if (k <= 1 || k > n) System.out.println("No");
        else if (k == n) {
            System.out.println("YES");
            for (int i = 1; i <= n; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            System.out.println("YES");
            System.out.println("1 2 3");
        }
    }
}
