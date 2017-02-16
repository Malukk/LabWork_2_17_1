package labWork_2_17_4;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Bulik on 30.08.2016.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int SIZE_ARRAY = 1000;
        int [] arrayInt = new int[SIZE_ARRAY];
        Random random = new Random();
        for (int i = 0; i<arrayInt.length; i++){
            arrayInt[i] = random.nextInt(1000);
        }
        System.out.println(Arrays.toString(arrayInt));

        MySumCount mySumCount_11 =new MySumCount();
        MySumCount mySumCount_22 =new MySumCount();

        mySumCount_11.setArray(arrayInt);
        mySumCount_22.setArray(arrayInt);

        mySumCount_11.setStartIndex(0);
        mySumCount_11.setStopIndex(arrayInt.length/2-1);

        mySumCount_22.setStartIndex(arrayInt.length/2);
        mySumCount_22.setStopIndex(arrayInt.length-1);

        Thread mySumCount_1 = new Thread(mySumCount_11);
        Thread mySumCount_2 = new Thread(mySumCount_22);

        mySumCount_1.start();
        mySumCount_2.start();

        mySumCount_1.join();
        mySumCount_2.join();

        System.out.println("Sum of array elements: "+ (mySumCount_11.getResultSum()+mySumCount_22.getResultSum()));
    }
}
