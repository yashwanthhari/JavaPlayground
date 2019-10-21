package SeptemberEasy2k19;
import java.util.Arrays;
import java.util.Scanner;
public class SpecialtyofSequence {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        long sum =0;
        for(int i=0;i<n-k;i++){
            sum+=arr[i];
        }
        System.out.println(sum);
    }
}
