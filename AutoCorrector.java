import java.util.*;

public class AutoCorrector {
    private static final List<String> dictionary = Arrays.asList(
        "hello", "world", "java", "unique", "github", "programming", "computer", "engineer"
    );

    public static int levenshtein(String a, String b) {
        int[][] dp = new int[a.length()+1][b.length()+1];
        for (int i = 0; i <= a.length(); i++)
            for (int j = 0; j <= b.length(); j++) {
                if (i == 0) dp[i][j] = j;
                else if (j == 0) dp[i][j] = i;
                else if (a.charAt(i-1) == b.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = 1 + Math.min(dp[i-1][j-1], 
                                    Math.min(dp[i-1][j], dp[i][j-1]));
            }
        return dp[a.length()][b.length()];
    }

    public static String suggest(String word) {
        String suggestion = null;
        int best = Integer.MAX_VALUE;
        for (String d : dictionary) {
            int dist = levenshtein(word, d);
            if (dist < best) {
                best = dist;
                suggestion = d;
            }
        }
        return suggestion;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String input = sc.nextLine();
        String suggestion = suggest(input);
        if (suggestion.equals(input)) {
            System.out.println("✔ Word is correct.");
        } else {
            System.out.println("❓ Did you mean: " + suggestion + "?");
        }
    }
}
