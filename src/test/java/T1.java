public class T1 {
    public static void main(String[] args) {
        int result = test(); System.out.println(result);
    }
    public static int test() {
        try {
            int a = 1/0;
            return 10;
        }catch (Exception e){

        }
        finally {
        }
        return 20;

    }
}
