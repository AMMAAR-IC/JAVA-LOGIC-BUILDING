public class ReverseWords {
    public static String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        int end = s.length(), i = s.length() - 1;

        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') i--;
            result.append(s.substring(i + 1, end)).append(" ");
            while (i >= 0 && s.charAt(i) == ' ') i--;
            end = i + 1;
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("hello world from java")); // "java from world hello"
    }
}
