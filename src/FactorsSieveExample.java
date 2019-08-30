//import java.io.BufferedWriter;
//import java.io.FileWriter;

import java.io.IOException;
import java.util.*;

public class FactorsSieveExample {

    private static final Scanner scanner = new Scanner(System.in);
    private static final int max = 1000001;


    private static void downToZero( Map<Integer, Integer> dp) {
        for (int i = 2; i < max; i++) {
            if(!dp.containsKey(i) || dp.get(i) > dp.get(i-1) + 1){
                dp.put(i, dp.get(i-1)+1);
            }
            for(int j=1; j<=i && j*i < max; j++){
                if(!dp.containsKey(i*j) || dp.get(i*j) > dp.get(i)+1){
                    dp.put(i*j, dp.get(i) + 1);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int q = Integer.parseInt(scanner.nextLine().trim());
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 0);
        dp.put(1, 1);
        downToZero(dp);
        for (int qItr = 0; qItr < q; qItr++) {
            int n = Integer.parseInt(scanner.nextLine().trim());
            int result = dp.get(n);
            System.out.println(result);
//            bufferedWriter.write(String.valueOf(result));
//            bufferedWriter.newLine();
        }
//        bufferedWriter.close();
    }
}
