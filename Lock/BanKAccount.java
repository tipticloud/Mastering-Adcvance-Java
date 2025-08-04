package Lock;

public class BanKAccount {
    private int balance = 100;

    public synchronized void withdraw(int amount){
        System.out.println(Thread.currentThread().getName() + " atttempting to withdraw "+ amount);
        if(balance >= amount){
            System.out.println(Thread.currentThread().getName() +"Proceeding with withdraw");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            balance -= amount;
            System.out.println(Thread.currentThread().getName() +"completed withdrwal: Remaining balance: "+balance);

        }else{
            System.out.println(Thread.currentThread().getName()+"Insufficient balance");
        }
    }
}
