package SeptemberEasy2k19;/* IMPORTANT: Multiple classes and nested static classes are supported */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TestClass {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n + 1];
        long prev = Integer.MIN_VALUE;
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            arr[i] = sc.nextLong();
            if (arr[i] >= prev) {
                count++;
                prev = arr[i];
            } else {
                list.add(count);
                count = 1;
                prev = arr[i];
            }
        }
        list.add(count);
        count = 0;
        int max = Integer.MIN_VALUE;
        prev = Integer.MIN_VALUE;
        for (int i = 1; i < list.size(); i++) {
            if (arr[i] >= prev) {
                count++;
            } else {
                max = Math.max(max, count);
                prev = arr[i];
                count = 1;
            }
        }
        max = Math.max(max, count);
        System.out.println(max);
    }
}
