package SeptemberCircuits2k19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class FriendsInTown {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tok = reader.readLine().split(" ");
        int n = Integer.parseInt(tok[0]);
        int m = Integer.parseInt(tok[1]);
        int k = Integer.parseInt(tok[2]);
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            tok = reader.readLine().split(" ");
            int a = Integer.parseInt(tok[0]);
            int b = Integer.parseInt(tok[1]);
            adj[a - 1].add(b - 1);
            adj[b - 1].add(a - 1);
        }
        int q = Integer.parseInt(reader.readLine());
        long[] happy = new long[n];
        int[] day = new int[n];
        for (int i = 0; i < q; i++) {
            tok = reader.readLine().split(" ");
            int p = Integer.parseInt(tok[0]);
            int x = Integer.parseInt(tok[1]);
            for (int per : adj[p - 1]) {
                if (day[per] == 0) {
                    happy[per] = happy[per] + x;
                    if (happy[per] >= k) day[per] = i + 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (day[i] == 0) System.out.print(-1 + " ");
            else System.out.print(day[i] + " ");
        }
    }
}
