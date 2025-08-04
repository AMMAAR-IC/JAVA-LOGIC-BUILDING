import java.util.*;

public class GeneticStringEvolver {
    static final String TARGET = "hello world";
    static final int POP_SIZE = 200;
    static final double MUTATION_RATE = 0.02;
    static Random rand = new Random();

    static String mutate(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (rand.nextDouble() < MUTATION_RATE)
                chars[i] = (char) (32 + rand.nextInt(95));
        }
        return new String(chars);
    }

    static String crossover(String a, String b) {
        int pivot = rand.nextInt(a.length());
        return a.substring(0, pivot) + b.substring(pivot);
    }

    static int fitness(String s) {
        int score = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == TARGET.charAt(i)) score++;
        }
        return score;
    }

    public static void main(String[] args) {
        List<String> population = new ArrayList<>();
        for (int i = 0; i < POP_SIZE; i++)
            population.add(randomString(TARGET.length()));

        int generation = 0;
        while (true) {
            population.sort(Comparator.comparingInt(GeneticStringEvolver::fitness).reversed());
            String best = population.get(0);
            System.out.println("Gen " + generation + ": " + best);

            if (best.equals(TARGET)) break;

            List<String> newPop = new ArrayList<>();
            for (int i = 0; i < POP_SIZE; i++) {
                String parent1 = population.get(rand.nextInt(50));
                String parent2 = population.get(rand.nextInt(50));
                String child = mutate(crossover(parent1, parent2));
                newPop.add(child);
            }
            population = newPop;
            generation++;
        }
    }

    static String randomString(int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++)
            sb.append((char) (32 + rand.nextInt(95)));
        return sb.toString();
    }
}
