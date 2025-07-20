import java.util.*;

public class ZAlgorithm {
    public static int[] computeZ(String s) {
        int n = s.length();
        int[] Z = new int[n];
        int l = 0, r = 0;

        for (int i = 1; i < n; i++) {
            if (i <= r) {
                Z[i] = Math.min(r - i + 1, Z[i - l]);
            }
            while (i + Z[i] < n && s.charAt(Z[i]) == s.charAt(i + Z[i])) {
                Z[i]++;
            }
            if (i + Z[i] - 1 > r) {
                l = i;
                r = i + Z[i] - 1;
            }
        }

        return Z;
    }

    public static void main(String[] args) {
        String text = "abcabcabc";
        String pattern = "abc";
        String combined = pattern + "$" + text;
        int[] Z = computeZ(combined);

        System.out.println("Pattern found at indices:");
        for (int i = 0; i < Z.length; i++) {
            if (Z[i] == pattern.length()) {
                System.out.println(i - pattern.length() - 1);
            }
        }
    }
}
