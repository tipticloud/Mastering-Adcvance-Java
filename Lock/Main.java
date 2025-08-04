package Lock;

public class Main {
    public static void main(String[] args) {
        BanKAccount banKAccount = new BanKAccount();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                banKAccount.withdraw(50);
            }
        };
        Thread t1 = new Thread(task,"Thread 1");
        Thread t2 = new Thread(task,"Thread 1");
        t1.start();
        t2.start();



    }
}
