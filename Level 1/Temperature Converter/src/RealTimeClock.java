import java.text.SimpleDateFormat;
import java.util.Date;

public class RealTimeClock extends Thread {

    public void run() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        while (true) {
            System.out.println("Current Time is : " + sdf.format(new Date()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());;
            }
        }
    }

    public static void main(String[] args) {
        new RealTimeClock().start();
    }
}
