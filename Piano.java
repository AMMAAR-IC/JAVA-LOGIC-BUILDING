import java.awt.Toolkit;
import java.util.Scanner;

public class Piano {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        System.out.println("Type a letter (A-G) to play, Q to quit:");
        while (true) {
            String key = sc.nextLine().toUpperCase();
            if (key.equals("Q")) break;
            int pitch = switch (key) {
                case "A" -> 200;
                case "B" -> 300;
                case "C" -> 400;
                case "D" -> 500;
                case "E" -> 600;
                case "F" -> 700;
                case "G" -> 800;
                default -> 100;
            };
            toolkit.beep();
            try { Thread.sleep(100); } catch (Exception ignored) {}
        }
        sc.close();
    }
}
