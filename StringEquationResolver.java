import java.util.Scanner;

public class StringEquationResolver {

    public static boolean isValidMerge(String a, String b, String result) {
        int i = 0, j = 0, k = 0;

        while (k < result.length()) {
            if (i < a.length() && result.charAt(k) == a.charAt(i)) {
                i++;
            } else if (j < b.length() && result.charAt(k) == b.charAt(j)) {
                j++;
            } else {
                return false;
            }
            k++;
        }

        return i == a.length() && j == b.length();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter string A:");
        String a = sc.nextLine();

        System.out.println("Enter string B:");
        String b = sc.nextLine();

        System.out.println("Enter Result string:");
        String result = sc.nextLine();

        if (isValidMerge(a, b, result)) {
            System.out.println("✔️ Valid interleaved merge!");
        } else {
            System.out.println("❌ Not a valid merge.");
        }
    }
}
