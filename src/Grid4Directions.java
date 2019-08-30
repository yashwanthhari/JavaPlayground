//import java.io.BufferedWriter;
//import java.io.FileWriter;

import java.io.IOException;
import java.util.*;

public class Grid4Directions {

    private static final Scanner scanner = new Scanner(System.in);
    private static final int[] dx = { 0, 0, 1, -1};
    private static final int[] dy = { 1, -1, 0, 0};
    private static final char open = '.';

    static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {
        Map<Integer, Integer> distance = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        int startHash = getHash(startX, startY);
        queue.add(startHash);
        distance.put(startHash, 0);
        if((startX == goalX) && (startY == goalY)){
            return result(goalX, goalY, distance);
        }
        while(!queue.isEmpty()){
            int currHash = queue.remove();
            int qx = getX(currHash);
            int qy = getY(currHash);
            int qd = distance.get(currHash);
            System.out.println("Current index " + qx + " " + qy);
            for (int i=0; i< dx.length; i++){
                int x = qx + dx[i];
                int y = qy + dy[i];
                int hash = getHash(x, y);
                while(isValid(x, y, grid.length) && (!distance.containsKey(hash) || distance.get(hash) >= qd+1) && grid[x].charAt(y) == open){
                    System.out.println("Add index " + x + " " + y + " distance " + (qd+1));
                    queue.add(hash);
                    distance.put(hash, qd + 1);
                    if((x == goalX) && (y == goalY)){
                        return result(goalX, goalY, distance);
                    }
                    x = x + dx[i];
                    y = y + dy[i];
                    hash = getHash(x, y);
                }
            }
        }
        return result(goalX, goalY, distance);
    }

    static int result(int x, int y, Map<Integer, Integer> distance){
        int destKey = getHash(x, y);
        return distance.getOrDefault(destKey, -1);
    }

    static int getHash(int x, int y) {
        return x * 1000 + y;
    }

    static int getX(int hash){
        return hash/1000;
    }

    static int getY(int hash){
        return hash%1000;
    }

    static boolean isValid(int x, int y, int n){
        return (x >= 0) && (y >= 0) && (x < n) && (y < n);
    }

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] startXStartY = scanner.nextLine().split(" ");

        int startX = Integer.parseInt(startXStartY[0]);

        int startY = Integer.parseInt(startXStartY[1]);

        int goalX = Integer.parseInt(startXStartY[2]);

        int goalY = Integer.parseInt(startXStartY[3]);
        long start = System.currentTimeMillis();
        int result = minimumMoves(grid, startX, startY, goalX, goalY);
        long end = System.currentTimeMillis();
        System.out.println("Result " + result + " took time: " + (end-start));

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
