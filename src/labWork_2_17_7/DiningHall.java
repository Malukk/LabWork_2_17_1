package labWork_2_17_7;

/**
 * Created by Bulik on 02.09.2016.
 */
public class DiningHall {
    static int pizzaNum;
    static int studentID;

    public void makePizza() {
        pizzaNum++;
    }
    public void servePizza() {
        String result;
        if (pizzaNum > 0) {
            result = "Served ";
            pizzaNum--;
        } else result = "Starved ";
        System.out.println(result + studentID);
        studentID++;
    }

    public static void main(String[] args) {
        DiningHall d = new DiningHall();

        for (int i = 0; i < 10; i++)
            d.makePizza();

        StudentServ[] servs = new StudentServ[20];
        for (int i = 0; i<servs.length; i++){
            servs[i] = new StudentServ(d);
        }
        for (StudentServ studentServ : servs){
            studentServ.start();
        }

//        for (int i = 0; i < 20; i++)
//            d.servePizza();
    }
}

