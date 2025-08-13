import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ReverseClock {
    public static void main(String[] args) throws InterruptedException {
        LocalTime t = LocalTime.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss");

        while (true) {
            System.out.print("\r" + t.format(fmt));
            t = t.minusSeconds(1);
            Thread.sleep(1000);
        }
    }
}
