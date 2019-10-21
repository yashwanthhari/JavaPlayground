package SeptemberEasy2k19;

import java.util.Scanner;

class MinimumRotations {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int f = sc.nextInt();
            int k = sc.nextInt();
            char c = sc.nextLine().trim().charAt(0);
            String str = sc.nextLine().trim();
            str += str;
            if (k > n) {
                System.out.println(-1);
                continue;
            }
            int count = 0;
            for (int i = 0; i < k; i++) {
                if (str.charAt(i) == c) {
                    count++;
                }
            }
            int rot = 0;
            if (count >= f) {
                System.out.println(rot);
                continue;
            }
            int start = n + k - 1;
            for (int i = n - 1; i > 0; i--) {
                System.out.println("At " + i + " char " + str.charAt(i));
                rot++;
                if (str.charAt(start) == c) {
                    System.out.println("Dec");
                    count--;
                }
                start--;
                if (str.charAt(i) == c) {
                    count++;
                    System.out.println("Inc");
                }
                if (count >= f)
                    break;
            }
            if (count < f)
                System.out.println(-1);
            else System.out.println(rot);
        }
    }
}
