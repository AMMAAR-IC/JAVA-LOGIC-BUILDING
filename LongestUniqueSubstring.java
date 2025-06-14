import java.util.*;

public class LongestUniqueSubstring {
    public static int longestUnique(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right)))
                left = Math.max(map.get(s.charAt(right)) + 1, left);
            map.put(s.charAt(right), right);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestUnique("abcabcbb")); // 3 ("abc")
    }
}
