import java.io.BufferedReader;
import java.io.InputStreamReader;

class TestClass {
    public static void main(String[] args) throws Exception {
        System.out.println(doReturn());
    }
    private static int doReturn(){
        try{
            System.out.println("Try");
            return ret();
        } catch (Exception e){
            System.out.println("Ex");
            return 0;
        } finally {
            System.out.println("fin");
        }
    }

    private static int ret(){
        System.out.println("ret");
        return 20;
    }
}
