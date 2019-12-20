package DecCodechef2k19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PLMU {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            int n=Integer.parseInt(br.readLine());
            long twos=0;
            long zeroes=0;
            String[] tok = br.readLine().split(" ");
            for(int i=0;i<n;i++){
                int x=Integer.parseInt(tok[i]);
                if(x==0) zeroes++;
                else if(x==2) twos++;
            }
            System.out.println((zeroes*(zeroes-1))/2+(twos*(twos-1))/2);
        }
    }
}
