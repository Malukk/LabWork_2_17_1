package labWork_2_17_6;

/**
 * Created by Bulik on 01.09.2016.
 */
public class Printer extends Thread {
    Storage storage;
    int n;

    public Printer(Storage storage, int n) {
        this.storage = storage;
        this.n = n;
    }

    @Override
    public void run() {
        for( int i =0; i<n; i++){
            synchronized (storage){
                while (!storage.isFlag()){
                    try {
                        storage.wait();
                    }catch (InterruptedException e){}
                }
                System.out.println(storage.getValue());
                storage.setFlag(false);
                storage.notify();
            }

//            try {
//                Thread.sleep(100);
//            }catch (InterruptedException ee){
//                System.out.println("Error!!!");
//            }
        }
    }
}
