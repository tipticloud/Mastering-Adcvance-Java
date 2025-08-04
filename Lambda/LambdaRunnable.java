package Lambda;

public class LambdaRunnable {
    public static void main(String[] args) {
        Runnable r = () -> System.out.println("Hello from a lambda Runnable!");
        new Thread(r).start();
    }
}
