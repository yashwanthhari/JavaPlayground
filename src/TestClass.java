class TestClass {
    public static final long range = (long) Math.pow(10, 10);
    static long[] dp = new long[(int) 10e6 + 1];

    public static void main(String[] args) throws Exception {
        String x = "111111111";
        String y = "11";
        int i = Integer.parseInt(x, 2);
        int j = Integer.parseInt(y, 2);
        System.out.println(add(i, j));
    }

    private static int add(int x, int y) {
        int r = 0;
        while (y > 0) {
            int u = x ^ y;
            int v = x & y;
            System.out.print(u + " ");
            System.out.println(v * 2);
            x = u;
            y = v * 2;
            r++;
        }
        return r;
    }
}
