//import java.io.BufferedWriter;
//import java.io.FileWriter;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TruckTour {

    private static final Scanner scanner = new Scanner(System.in);

    static int truckTour(int[][] petrolpumps) {
        Queue<PetrolPump> queue = new LinkedList<>();
        for (int i = 0; i < petrolpumps.length; i++) {
            queue.add(new PetrolPump(petrolpumps[i][0], petrolpumps[i][1], i));
        }
        int l = 0;
        long tank = 0;
        int count = 0;
        int index = -1;
        while (l != petrolpumps.length - 1 && count < 2 * petrolpumps.length - 1) {
            PetrolPump curr = queue.remove();
            if (index == -1) {
                index = curr.index;
            }
            tank += curr.petrol;
            if (curr.distance > tank) {
                tank = 0;
                l = 0;
                index = -1;
            } else {
                tank -= curr.distance;
                l++;
            }
            if (l == petrolpumps.length - 1)
                return index;
            queue.add(curr);
            count++;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] petrolpumps = new int[n][2];

        for (int petrolpumpsRowItr = 0; petrolpumpsRowItr < n; petrolpumpsRowItr++) {
            String[] petrolpumpsRowItems = scanner.nextLine().split(" ");

            for (int petrolpumpsColumnItr = 0; petrolpumpsColumnItr < 2; petrolpumpsColumnItr++) {
                int petrolpumpsItem = Integer.parseInt(petrolpumpsRowItems[petrolpumpsColumnItr].trim());
                petrolpumps[petrolpumpsRowItr][petrolpumpsColumnItr] = petrolpumpsItem;
            }
        }

        int result = truckTour(petrolpumps);
        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
    }

    static class PetrolPump {
        int petrol;
        int distance;
        int index;

        public PetrolPump(int petrol, int distance, int index) {
            this.petrol = petrol;
            this.distance = distance;
            this.index = index;
        }
    }
}
