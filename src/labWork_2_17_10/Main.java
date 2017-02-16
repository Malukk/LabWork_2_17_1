package labWork_2_17_10;

/**
 * Created by Bulik on 06.09.2016.
 */
public class Main {
    public static void main(String[] args) {
        MyObject object_1 = new MyObject("Data_" + 1);
        MyObject object_2 = new MyObject("Data_" + 2);
        MyObject object_3 = new MyObject("Data_" + 3);

        MyThread myThread_1 = new MyThread(1, object_1, object_2, object_3);
        MyThread myThread_2 = new MyThread(2, object_2, object_3, object_1);
        MyThread myThread_3 = new MyThread(3, object_3,object_1, object_2);

        myThread_1.start();
        myThread_2.start();
        myThread_3.start();
    }
}
