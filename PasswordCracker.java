import java.util.Random;

public class PasswordCracker {
    public static void main(String[] args) throws InterruptedException {
        String password = "JAVA";
        String attempt = "";
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rand = new Random();

        while (!attempt.equals(password)) {
            attempt = "";
            for (int i = 0; i < password.length(); i++) {
                attempt += chars.charAt(rand.nextInt(chars.length()));
            }
            System.out.println("Trying: " + attempt);
            Thread.sleep(50);
        }
        System.out.println("Password cracked: " + attempt + " 🔓");
    }
}
