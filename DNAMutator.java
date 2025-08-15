import java.util.*;

public class DNAMutator {
    public static void main(String[] args) {
        String dna = "ATGCGTACGTAGCTAGCTAG";
        Random rand = new Random();
        char[] bases = {'A','T','G','C'};

        System.out.println("Original DNA: " + dna);
        StringBuilder mutated = new StringBuilder(dna);
        for (int i = 0; i < dna.length(); i++) {
            if (rand.nextDouble() < 0.2) { // 20% mutation rate
                mutated.setCharAt(i, bases[rand.nextInt(4)]);
            }
        }
        System.out.println("Mutated DNA:  " + mutated);
    }
}
