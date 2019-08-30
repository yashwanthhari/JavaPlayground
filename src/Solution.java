public class Solution {
    public static int solve(int[] a, int x) {
        return search(a, 0, a.length, x);
    }

    public static int search(int[] a, int l, int r, int x) {
        int i = (r + l) / 2;
        if (a[i] == x && (i == 0 || a[i - 1] != x)) {
            return i;
        }
        if (l == r)
            return -1;
        if (a[i] >= x) {
            return search(a, l, i, x);
        }
        return search(a, i, r, x);
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 0};
        System.out.println(solve(a, 0));
    }
}
