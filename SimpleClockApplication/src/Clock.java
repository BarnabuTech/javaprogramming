import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Clock {

    private volatile String currentTime = "";

    private final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");

    /**
     * Thread responsible for updating the current time.
     */
    class TimeUpdater extends Thread {

        @Override
        public void run() {

            while (true) {

                currentTime = LocalDateTime.now().format(formatter);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Time Updater interrupted.");
                    return;
                }
            }
        }
    }

    /**
     * Thread responsible for displaying the time.
     */
    class TimeDisplay extends Thread {

        @Override
        public void run() {

            while (true) {

                System.out.println(
                        "Current Time: "
                        + currentTime
                        + " | Thread Priority: "
                        + getPriority());

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Display Thread interrupted.");
                    return;
                }
            }
        }
    }

    public void startClock() {

        TimeUpdater updater = new TimeUpdater();
        TimeDisplay display = new TimeDisplay();

        updater.setPriority(Thread.NORM_PRIORITY);

        display.setPriority(Thread.MAX_PRIORITY);

        updater.start();
        display.start();
    }
}