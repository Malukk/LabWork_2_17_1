package labWork_2_17_4;


/**
 * Created by Bulik on 30.08.2016.
 */
public class MySumCount implements Runnable{
    private int startIndex, stopIndex;

    private int[] array;
    private long resultSum;

    public int getStartIndex() {
        return startIndex;
    }

    public int getStopIndex() {
        return stopIndex;
    }

    public long getResultSum() {
        return resultSum;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public void setStopIndex(int stopIndex) {
        this.stopIndex = stopIndex;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {

        for(int i =startIndex; i<=stopIndex; i++){
            resultSum+= array[i];
        }
        try{
            Thread.sleep(500);
        }catch (InterruptedException ee){
            ee.printStackTrace();


        }
        System.out.println(Thread.currentThread().getName() + " ended!");

    }
}