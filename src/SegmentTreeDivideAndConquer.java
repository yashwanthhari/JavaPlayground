//import java.io.BufferedWriter;
//import java.io.FileWriter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SegmentTreeDivideAndConquer {

    private static final Scanner scanner = new Scanner(System.in);

    static long largestRectangle(int[] h) {
        Map<Integer, Integer> segTree = new HashMap<>();
        build(h, 0, h.length - 1, 1, segTree);
        return largestRectangle(h, 0, h.length-1, segTree);
    }

    static long largestRectangle(int[] h, int ql, int qr, Map<Integer, Integer> segTree){
        if(ql>qr){
            return -1;
        }
        if(ql == qr){
            return h[ql];
        }
        int minIndex = rmq_min(ql, qr, 0, h.length - 1, segTree, 1, h);
        long maxArea = (long) h[minIndex] * (qr - ql + 1);
        long left = largestRectangle(h, ql, minIndex-1, segTree);
        maxArea = Math.max(left, maxArea);
        long right = largestRectangle(h, minIndex+1, qr, segTree);
        maxArea = Math.max(right, maxArea);
        return maxArea;
    }

    static void build(int[] a, int l, int r, int i, Map<Integer, Integer> segTree) {
        if (l > r) {
            throw new IllegalArgumentException();
        }
        if (l == r) {
            segTree.put(i, l);
            return;
        }
        int mid = (l + r) / 2;
        build(a, l, mid, 2 * i, segTree);
        build(a, mid + 1, r, 2 * i + 1, segTree);
        int left = segTree.get(2*i);
        int right = segTree.get(2*i + 1);
        if(a[left] <= a[right]){
            segTree.put(i, left);
        } else {
            segTree.put(i, right);
        }
    }

    static int rmq_min(int ql, int qr, int l, int r, Map<Integer, Integer> segTree, int i, int[] a) {
        if (ql > qr || l > r) {
            throw new IllegalArgumentException();
        }
        if(l > qr || r < ql){
            return -1;
        }
        if (l >= ql && r <= qr) {
            return segTree.get(i);
        }
        int mid = (l + r) / 2;
        int left = rmq_min(ql, qr, l, mid, segTree, 2 * i, a);
        int right = rmq_min(ql, qr, mid + 1, r, segTree, 2 * i + 1, a);
        if(left != -1 && right != -1 && a[left] <= a[right]){
            return left;
        } else if(right != -1) return right;
        else return left;
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
