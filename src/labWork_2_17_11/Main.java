package labWork_2_17_11;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Bulik on 06.09.2016.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException{
        final int NUMBER_THREAT = 10;
        final int NUMBER_READ_WRITE = 50;

        Map<Integer, String> map = new ConcurrentHashMap<>();//without concurent
       // Map<Integer, String> map = new HashMap<>();

        WriteThread[] writeThreads = new WriteThread[NUMBER_THREAT];
        ReadThtead[] readThteads = new ReadThtead[NUMBER_THREAT];

        int key = 13;
        for (int i = 0; i<NUMBER_THREAT; i++){
            writeThreads[i] = new WriteThread(map, NUMBER_READ_WRITE, key);
            readThteads[i] = new ReadThtead(map, NUMBER_READ_WRITE, key);
            key+=7;
        }
        for (int i=0; i<NUMBER_THREAT; i++){
            writeThreads[i].start();
        }
        for (int i=0; i<NUMBER_THREAT; i++) {
            readThteads[i].start();
        }
        long startTime = System.currentTimeMillis();
        for (int i =0; i<NUMBER_THREAT; i++){
            writeThreads[i].join();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time = " + (endTime-startTime + " ms"));
    }
}
