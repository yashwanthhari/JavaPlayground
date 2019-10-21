package SeptemberLongChallenge2k19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class FuzzyLinearEquations {
    private final static long mod = (long) Math.pow(10, 9) + 7;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] tok = reader.readLine().split(" ");

        // Find all GCDs
        Map<Integer, Integer> prevMap = new HashMap<>();
        Map<Integer, Integer> gcdMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(tok[i]);
            Map<Integer, Integer> currMap = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : prevMap.entrySet()) {
                int newGcd = gcd(a, entry.getKey());
                updateMap(gcdMap, newGcd, entry.getValue());
                updateMap(currMap, newGcd, entry.getValue());
            }
            updateMap(currMap, a, 1);
            updateMap(gcdMap, a, 1);
            prevMap = currMap;
        }

        // Build Sieve to answer queries
        int[] sieve = new int[(int) 1e6 + 1];
        for (Map.Entry<Integer, Integer> entry : gcdMap.entrySet()) {
            if (entry.getKey() <= 0) continue;
            for (int i = entry.getKey(); i <= 1e6; i += entry.getKey()) {
                sieve[i] += entry.getValue();
            }
        }

        // Answer queries in log(1)
        int q = Integer.parseInt(reader.readLine());
        for (int qc = 0; qc < q; qc++) {
            System.out.println(sieve[Integer.parseInt(reader.readLine())]);
        }
    }

    private static int gcd(int a, int b) {
        if (a < b) return gcd(b, a);
        if (b == 0) return a;
        if (a % b == 0) return b;
        return gcd(a, a % b);
    }

    private static void updateMap(Map<Integer, Integer> map, int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + value);
        } else map.put(key, value);
    }
}

