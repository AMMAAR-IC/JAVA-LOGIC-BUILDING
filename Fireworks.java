import java.util.Random;

public class Fireworks {
    public static void main(String[] args) throws Exception {
        Random rand = new Random();
        String[] sparks = {"*", "✦", "✧", "+", "❋"};
        while (true) {
            int pos = rand.nextInt(60);
            for (int i = 0; i < pos; i++) System.out.print(" ");
            System.out.println(sparks[rand.nextInt(sparks.length)]);
            Thread.sleep(200);
        }
    }
}
