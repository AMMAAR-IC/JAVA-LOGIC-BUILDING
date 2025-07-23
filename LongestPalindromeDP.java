public class LongestPalindromeDP {
    public static String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String result = "";

        for (int len = 0; len < n; len++) {
            for (int i = 0; i + len < n; i++) {
                int j = i + len;
                if (s.charAt(i) == s.charAt(j) && (len < 2 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    if (len + 1 > result.length()) {
                        result = s.substring(i, j + 1);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "babad";
        System.out.println("Longest Palindromic Substring: " + longestPalindrome(str));
    }
}
