import java.util.Arrays;

public class AnagramCheck {
    public static boolean isAnagram(String a, String b) {
        char[] c1 = a.toLowerCase().toCharArray();
        char[] c2 = b.toLowerCase().toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("Listen", "Silent")); // true
    }
}
