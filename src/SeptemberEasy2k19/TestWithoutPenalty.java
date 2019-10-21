package SeptemberEasy2k19;

import java.util.Scanner;

class TestWithoutPenalty {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long l = sc.nextLong();
            long c = sc.nextLong();
            System.out.println(l + (c - 1));
        }
    }
}
