package labWork_2_17_12;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Created by Bulik on 08.09.2016.
 */
public class SumOfNUsingForkJoin {
    private static int N = 1000_000;
    private static final int NUM_THREADS = 20;
    static class RecSumOfN extends RecursiveTask<Long> {
        int from, to;
        int[] array;

        public RecSumOfN(int[] array, int from, int to) {
            this.array = array;
            this.from = from;
            this.to = to;
        }
        public Long compute() {
            if ((to - from) <= 20) {

                long localSum = 0;
                for (int i = from; i < to; i++) {
                    localSum += array[i];
                }

                return localSum;
            } else {
                int mid = (from + to) / 2;

                RecSumOfN firstHalf = new RecSumOfN(array, from, mid);

                firstHalf.fork();

                RecSumOfN secondHalf = new RecSumOfN(array, mid, to);
                long resultSecond = secondHalf.compute();
                return firstHalf.join() + resultSecond;
            }
        }
    }
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool(NUM_THREADS);

        Random random = new Random();
        int [] arr = new int[N];
        for (int i = 0; i<arr.length; i++){
            arr[i]= random.nextInt(100);
        }
        //System.out.println(Arrays.toString(arr));

        long computedSum = pool.invoke(new RecSumOfN(arr, 0, arr.length));
                System.out.printf("Sum = %d %n", computedSum );
    }
}
