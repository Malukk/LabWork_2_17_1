package labWork_2_17_8and9;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Bulik on 06.09.2016.
 */
public class Transfer extends Thread {
    private Bank bank;
    private int from;
    private int max;
    private Lock lock;
    public Transfer(Bank bank, int from, int max_amount) {
        this.bank = bank;
        this.from = from;
        max = max_amount;
        lock = new ReentrantLock();
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true){
            int sum = random.nextInt(max)+1;
            int to = (int)(Math.random()* bank.getNumberAccounts());
//            lock.lock();
//            try {
//                bank.transfer(from, to, sum);
//            }finally {
//                lock.unlock();
//            }

            synchronized (bank){

            bank.transfer(from, to, sum);
            }
        }
    }
}



