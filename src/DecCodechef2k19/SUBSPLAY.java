package DecCodechef2k19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class SUBSPLAY {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            Map<Character, Integer> map = new HashMap<>();
            int res = 0;
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (map.containsKey(c)) {
                    int pos = map.get(c);
                    res = Math.max(res, n - i + pos);
                }
                map.put(c, i);
            }
            System.out.println(res);
        }
    }

}
