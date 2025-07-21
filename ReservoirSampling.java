import java.util.*;

public class ReservoirSampling {
    public static void main(String[] args) {
        int[] stream = new int[1000];
        for (int i = 0; i < stream.length; i++) stream[i] = i + 1;

        int k = 5;
        int[] reservoir = new int[k];

        for (int i = 0; i < k; i++)
            reservoir[i] = stream[i];

        Random rand = new Random();
        for (int i = k; i < stream.length; i++) {
            int j = rand.nextInt(i + 1);
            if (j < k) reservoir[j] = stream[i];
        }

        System.out.println("Sampled Elements: " + Arrays.toString(reservoir));
    }
}
