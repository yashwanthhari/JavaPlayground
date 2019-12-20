package OctoberCircuits19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LengthArithematicProgression {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tok = reader.readLine().split(" ");
        int n = Integer.parseInt(tok[0]);
        int Q = Integer.parseInt(tok[1]);
        tok = reader.readLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(tok[i]);
        }
        int l = 0;
        int r = 1;
        int prev = (r < n) ? a[r] - a[l] : 0;
        r++;
        Map<Integer, List<Range>> map = new HashMap<>();
        while (r < n) {
            int diff = a[r] - a[r - 1];
            if (diff != prev) {
                if (map.containsKey(prev)) {
                    map.get(prev).add(new Range(l, r - 1));
                } else {
                    List<Range> ranges = new ArrayList<>();
                    ranges.add(new Range(l, r - 1));
                    map.put(prev, ranges);
                }
                l = r - 1;
                prev = diff;
            }
            r++;
        }
        if (r <= n && r - l >= 2) {
            if (map.containsKey(prev)) {
                map.get(prev).add(new Range(l, r - 1));
            } else {
                List<Range> ranges = new ArrayList<>();
                ranges.add(new Range(l, r - 1));
                map.put(prev, ranges);
            }
        }
        for (int q = 0; q < Q; q++) {
            tok = reader.readLine().split(" ");
            int L = Integer.parseInt(tok[0]) - 1;
            int R = Integer.parseInt(tok[1]) - 1;
            int D = Integer.parseInt(tok[2]);
            if (!map.containsKey(D)) {
                System.out.println(1);
                continue;
            }
            int max = 1;
            for (Range range : map.get(D)) {
                if (range.l >= R || range.r <= L)
                    continue;
                if (range.l >= L && range.r <= R) {
                    max = Math.max(max, range.r - range.l + 1);
                } else {
                    max = Math.max(max, Math.min(range.r, R) - Math.max(range.l, L) + 1);
                }
            }
            System.out.println(max);
        }
    }

    static class Range {
        int l;
        int r;

        public Range(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }
}
