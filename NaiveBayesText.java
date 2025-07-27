import java.util.*;

public class NaiveBayesText {
    static Map<String, Integer> spamCounts = new HashMap<>();
    static Map<String, Integer> hamCounts = new HashMap<>();
    static int spamTotal = 0, hamTotal = 0;
    static int spamDocs = 0, hamDocs = 0;

    static void train(String[] docs, boolean[] isSpam) {
        for (int i = 0; i < docs.length; i++) {
            String[] tokens = docs[i].toLowerCase().split("\\s+");
            if (isSpam[i]) spamDocs++;
            else hamDocs++;

            for (String token : tokens) {
                if (isSpam[i]) {
                    spamCounts.put(token, spamCounts.getOrDefault(token, 0) + 1);
                    spamTotal++;
                } else {
                    hamCounts.put(token, hamCounts.getOrDefault(token, 0) + 1);
                    hamTotal++;
                }
            }
        }
    }

    static double classify(String doc) {
        String[] tokens = doc.toLowerCase().split("\\s+");
        double pSpam = Math.log(spamDocs / (double)(spamDocs + hamDocs));
        double pHam = Math.log(hamDocs / (double)(spamDocs + hamDocs));
        Set<String> vocab = new HashSet<>();
        vocab.addAll(spamCounts.keySet());
        vocab.addAll(hamCounts.keySet());

        for (String token : tokens) {
            int sc = spamCounts.getOrDefault(token, 0);
            int hc = hamCounts.getOrDefault(token, 0);
            pSpam += Math.log((sc + 1.0) / (spamTotal + vocab.size()));
            pHam += Math.log((hc + 1.0) / (hamTotal + vocab.size()));
        }

        return pSpam > pHam ? 1.0 : 0.0;
    }

    public static void main(String[] args) {
        String[] train = {
            "Win cash now", "Free money offer", "Hello how are you", "Project meeting tomorrow",
            "Exclusive deal just for you", "See you at the club"
        };
        boolean[] labels = {true, true, false, false, true, false};

        train(train, labels);

        String test = "Free money for you";
        double result = classify(test);
        System.out.println("Test: \"" + test + "\" => " + (result == 1.0 ? "SPAM" : "HAM"));
    }
}
