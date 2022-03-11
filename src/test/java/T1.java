public class T1 {
    public static void main(String[] args) {
        new Thread(()->{
            System.out.println("1");
            Thread.yield();
            System.out.println("2");
        }).start();
    }

}
