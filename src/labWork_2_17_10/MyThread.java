package labWork_2_17_10;

/**
 * Created by Bulik on 06.09.2016.
 */
public class MyThread extends Thread {
    private int numberThread;
    private MyObject obj_1;
    private MyObject obj_2;
    private MyObject obj_3;

    public MyThread(int numberThread, MyObject obj_1, MyObject obj_2, MyObject obj_3) {
        this.numberThread = numberThread;
        this.obj_1 = obj_1;
        this.obj_2 = obj_2;
        this.obj_3 = obj_3;
    }

    @Override
    public void run() {
       synchronized (obj_1){
           System.out.println("Thread "+ numberThread + ": "+"Holding lock " +obj_1.getName() + " ...");
           try{
               Thread.sleep((long)(Math.random()*10));
           }catch (InterruptedException ee){
               ee.printStackTrace();
           }
           synchronized (obj_2){
               System.out.println("Thread "+ numberThread+": Waiting for lock "+obj_2.getName()+"...");
           }
       }
    }
}
