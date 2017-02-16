package labWork_2_17_11;

import java.util.Map;

/**
 * Created by Bulik on 06.09.2016.
 */
public class WriteThread extends Thread {
    Map<Integer, String> map;
    private int numbers;
    private int key;

    public WriteThread(Map<Integer, String> map, int numbers, int key) {
        this.map = map;
        this.numbers = numbers;
        this.key = key;
}

    @Override
    public void run() {
        for (int i = 0; i < numbers; i++){
//            synchronized (map){
//                map.put(key,"value_" + key);
//                key++;
//                System.out.println(this.getName() + " : put -> " + (i+1));
//            }
            map.put(key,"value_" + key);
            key++;
            System.out.println(this.getName() + " : put -> " + (i+1));

            try {
                Thread.sleep(10);
            }catch (InterruptedException ee){}
        }
    }
}
