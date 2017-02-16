package labWork_2_17_8and9;

/**
 * Created by Bulik on 06.09.2016.
 */
public class BankTest {
    public static final int N_ACCOUNTS = 5;
    public static final int INIT_BALANCE = 1000;

    public static void main(String args[]) {
        Bank bank = new Bank(N_ACCOUNTS, INIT_BALANCE);

        for ( int i = 0; i<N_ACCOUNTS; i++){
            new Transfer(bank, i, INIT_BALANCE).start();
        }
    }
}