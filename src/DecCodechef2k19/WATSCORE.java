package DecCodechef2k19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WATSCORE {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            int n=Integer.parseInt(br.readLine());
            int[] res=new int[8];
            int score=0;
            while(n-->0){
                String[] tok=br.readLine().split(" ");
                int p=Integer.parseInt(tok[0])-1;
                int s=Integer.parseInt(tok[1]);
                if(p>=8) continue;
                res[p]=Math.max(s,res[p]);
            }
            for(int i=0;i<8;i++){
                score+=res[i];
            }
            System.out.println(score);
        }
    }
}
