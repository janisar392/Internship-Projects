import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ClockWithSynchronization {
    private String currentTime;
    private final Lock lock = new ReentrantLock();

    public void updateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        lock.lock();
        try {
            currentTime = sdf.format(new Date());
        } finally {
            lock.unlock();
        }
    }

    public void displayTime() {
        lock.lock();
        try {
            System.out.println("Current Time is : " + currentTime);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ClockWithSynchronization clock = new ClockWithSynchronization();

        Thread updater = new Thread(() -> {
            while (true) {
                clock.updateTime();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread displayer = new Thread(() -> {
            while (true) {
                clock.displayTime();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        updater.start();
        displayer.start();
    }
}