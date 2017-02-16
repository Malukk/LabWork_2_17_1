package labWork_2_17_7;

/**
 * Created by Bulik on 03.09.2016.
 */
public class StudentServ extends Thread {

    private DiningHall diningHall;

    public StudentServ(DiningHall diningHall) {
        this.diningHall = diningHall;
    }

    @Override
    public void run() {
        synchronized (diningHall) { // синхрогнізуєм
            diningHall.servePizza();
        }
    }
}
