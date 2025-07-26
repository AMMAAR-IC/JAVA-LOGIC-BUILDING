import java.util.*;

public class MinimalUniqueSubstrings {
    public static void main(String[] args) {
        String input = "abcababc";
        Set<String> result = findMinimalUniqueSubstrings(input);
        System.out.println("Minimal Unique Substrings: " + result);
    }

    static Set<String> findMinimalUniqueSubstrings(String s) {
        Map<String, Integer> freq = new HashMap<>();
        Set<String> minimal = new HashSet<>();

        for (int len = 1; len <= s.length(); len++) {
            for (int i = 0; i <= s.length() - len; i++) {
                String sub = s.substring(i, i + len);
                freq.put(sub, freq.getOrDefault(sub, 0) + 1);
            }
        }

        for (String sub : freq.keySet()) {
            if (freq.get(sub) == 1) {
                boolean minimalSub = true;
                for (int i = 1; i < sub.length(); i++) {
                    String part1 = sub.substring(0, i);
                    String part2 = sub.substring(i);
                    if (freq.getOrDefault(part1, 0) == 1 || freq.getOrDefault(part2, 0) == 1) {
                        minimalSub = false;
                        break;
                    }
                }
                if (minimalSub) minimal.add(sub);
            }
        }

        return minimal;
    }
}
