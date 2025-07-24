import java.util.Timer;
import java.util.TimerTask;

public class CronSimulator {
    public static void main(String[] args) {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("⏰ Task executed at " + new java.util.Date());
            }
        };

        Timer timer = new Timer();
        int intervalInSeconds = 10;
        timer.scheduleAtFixedRate(task, 0, intervalInSeconds * 1000);
    }
}
