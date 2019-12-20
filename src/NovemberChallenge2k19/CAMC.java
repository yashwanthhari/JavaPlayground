package NovemberChallenge2k19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CAMC {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());
        while (t-- > 0) {
            String[] tok = reader.readLine().split(" ");
            int n = Integer.parseInt(tok[0]);
            int m = Integer.parseInt(tok[1]);
            Pair[] pairs = new Pair[n];
            tok = reader.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                pairs[i] = new Pair(i, Long.parseLong(tok[i]));
            }
            Arrays.sort(pairs, (o1, o2) -> {
                if (o1.val > o2.val) return -11;
                else if (o1.val.equals(o2.val)) return 0;
                else return 1;
            });
            int[] count = new int[m];
            int num = 0;
            int left = 0;
            int right = 1;
            int color = pairs[right].pos % m;
            if (count[color]++ == 0) num++;
            color = pairs[left].pos % m;
            if (count[color]++ == 0) num++;
            long ans = Long.MAX_VALUE;
            while (right < n) {
                while (num != m && right < n) {
                    color = pairs[right++].pos % m;
                    if (count[color]++ == 0) num++;
                }
                while (num == m && left < right) {
                    ans = Math.min(ans, Math.abs(pairs[left].val - pairs[right].val));
                    color = pairs[left++].pos % m;
                    if (count[color]-- == 1) num--;
                }
            }
            System.out.println(ans);
        }
    }

    static class Pair {
        Integer pos;
        Long val;

        public Pair(Integer pos, Long val) {
            this.pos = pos;
            this.val = val;
        }
    }
}
