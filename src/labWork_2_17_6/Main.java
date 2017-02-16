package labWork_2_17_6;

/**
 * Created by Bulik on 01.09.2016.
 */
public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage();
        Thread counter = new Thread(new Counter(storage, 1000000));
        Thread printer = new Printer(storage, 1000000);
        counter.start();
        printer.start();
    }
}
