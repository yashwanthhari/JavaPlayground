//import java.io.BufferedWriter;
//import java.io.FileWriter;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class PoisonousPlantsStack {

    private static final Scanner scanner = new Scanner(System.in);

    static int poisonousPlants(int[] p) {
        Stack<Plant> stack = new Stack<>();
        int i = -1;
        int days = 0;
        while (++i < p.length) {
            if (stack.isEmpty()) {
                stack.push(new Plant(p[i], 0));
                continue;
            }
            Plant top = stack.peek();
            if (p[i] > top.getValue()) {
                days = Math.max(days, 1);
                stack.push(new Plant(p[i], 1));
            } else {
                int temp = top.getDays();
                while (!stack.isEmpty() && p[i] <= stack.peek().getValue()) {
                    top = stack.pop();
                    temp = Math.max(temp, top.getDays());
                }
                if (stack.isEmpty()) {
                    stack.push(new Plant(p[i], 0));
                } else {
                    stack.push(new Plant(p[i], temp + 1));
                    days = Math.max(days, temp + 1);
                }
            }

        }
        return days;
    }

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] p = new int[n];

        String[] pItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pItem = Integer.parseInt(pItems[i]);
            p[i] = pItem;
        }

        int result = poisonousPlants(p);
        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }

    static class Plant {
        int value;
        int days;

        public Plant(int value, int days) {
            this.value = value;
            this.days = days;
        }

        public int getValue() {
            return value;
        }

        public int getDays() {
            return days;
        }

        @Override
        public String toString() {
            return "Plant{" +
                    "value=" + value +
                    ", days=" + days +
                    '}';
        }
    }
}
