package labWork_2_17_6;

/**
 * Created by Bulik on 01.09.2016.
 */
public class Counter implements Runnable {
    Storage storage;
    int n;

    public Counter(Storage storage, int n) {
        this.storage = storage;
        this.n=n;
    }

    @Override
    public void run() {
        for (int i=0; i< n; i++){
            synchronized (storage) {
                while (storage.isFlag()){
                    try {
                        storage.wait();
                    }catch (InterruptedException e){}

                }
                storage.setValue(storage.getValue() + 1);
                storage.setFlag(true);
                storage.notify();
            }
//            try{
//                Thread.sleep(100);
//            }catch (InterruptedException ee){
//                System.out.println("Error");
//            }
        }

    }
}
