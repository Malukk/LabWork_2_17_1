package labWork_2_17_1;

/**
 * Created by Bulik on 30.08.2016.
 */
public class MyTimeBomb extends Thread{
    @Override
    public void run() {
        for (int i = 10; i>0; i--){
            System.out.println(i);
            try {
                Thread.sleep(1000);
            }catch (InterruptedException ee){
                System.out.println("Error!!!");
            }
        }
        System.out.println("Boom!!!");
    }
}
