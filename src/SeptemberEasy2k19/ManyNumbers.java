package SeptemberEasy2k19;

import java.util.Arrays;
import java.util.Scanner;

class ManyNumbers {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();
        long l = sc.nextLong();
        long r = sc.nextLong();
        int k = sc.nextInt();
        long res = n % m;
        long[] arr = new long[k + 2];
        int count = 0;
        if (l <= n) {
            for (long i = l; i <= n && i <= r; i++) {
                if (i != m && n % i == res) {
                    arr[count++] = i;
                    if (count > k) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        if (l > n && res == n) {
            for (long i = l; i <= r; i++) {
                arr[count++] = i;
                if (count > k) {
                    System.out.println(-1);
                    return;
                }
            }
        } else if (r > n && res == n) {
            for (long i = n + 1; i <= r; i++) {
                arr[count++] = i;
                if (count > k) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        if (count > k) {
            System.out.println(-1);
            return;
        }
        System.out.println(count);
        Arrays.sort(arr);
        for (long i : arr) {
            if (i != 0)
                System.out.print(i + " ");
        }
    }
}
