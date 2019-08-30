//import java.io.BufferedWriter;
//import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class StackLargestRectangle {

    private static final Scanner scanner = new Scanner(System.in);

    static long largestRectangle(int[] h) {
        Stack<Integer> stack = new Stack<>();
        long maxArea = 0;
        int i = 0;
        while(i < h.length) {
            if (stack.empty() || h[stack.peek()] <= h[i]) {
                stack.push(i);
                i++;
            } else {
                int index = stack.pop();
                maxArea = Math.max(maxArea, h[index]*((stack.empty())? i: i - stack.peek() - 1));
            }
        }
        return maxArea;
    }
    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] h = new int[n];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        long result = largestRectangle(h);
        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
