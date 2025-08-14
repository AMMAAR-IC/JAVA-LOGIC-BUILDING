import java.time.LocalTime;

public class ConsoleClock {
    public static void main(String[] args) throws InterruptedException {
        while ConsoleClock(true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            LocalTime now = LocalTime.now();
            System.out.println("   DIGITAL CLOCK   ");
            System.out.println("====================");
            System.out.printf("%02d:%02d:%02d%n", now.getHour(), now.getMinute(), now.getSecond());
            Thread.sleep(1000);
        }
    }
}
