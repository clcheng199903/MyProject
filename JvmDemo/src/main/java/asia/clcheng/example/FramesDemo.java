package asia.clcheng.example;

public class FramesDemo {
    public static void main(String[] args) {
        method1();
    }

    private static void method1(){
        method2(1, 2);
    }

    private static int method2(int a, int b) {
        int c = a + b;
        new Thread(()->{
            System.out.println(Thread.currentThread().getName());
        }).start();
        return c;
    }
}
