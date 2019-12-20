package NovemberChallenge2k19;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LSTBTF {
    public static final int range = 100;

    public static void main(String[] args) throws IOException {
        int[] squares = {1, 4, 9, 16, 25, 36, 49, 64, 81};
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int sq : squares) {
            List<Integer> sqs = new ArrayList<>();
            sqs.add(sq);
            map.put(sq, sqs);
        }
        int[] res = new int[range + 1];
        for (int i = 1; i <= range; i++) {
            for (int sq : squares) {
                if (i - sq > 0) {
                    if (map.containsKey(i - sq)) {
                        List<Integer> sqs = new ArrayList<>(map.get(i - sq));
                        sqs.add(sq);
                        if (map.containsKey(i)) {
                            if (map.get(i).size() > sqs.size()) {
                                map.put(i, sqs);
                            }
                        } else map.put(i, sqs);
                        int root = (int) Math.sqrt(i);
                        if (root * root == i) {
                            resolveRoots(i, map, res);
                        }
                    }
                } else break;
            }
        }
        for (int i = 1; i <= 3; i++) {
            System.out.println(res[i]);
        }
    }

    private static void resolveRoots(int i, Map<Integer, List<Integer>> map, int[] res) {
        List<Integer> list = map.get(i);
        Collections.sort(list);
        int num = 0;
        int count = 0;
        for (int l : list) {
            num = num * 10 + l;
            count++;
        }
        if (res[count] != 0 && num < res[count]) {
            res[count] = num;
        }
    }
}
