import java.util.Scanner;

public class StringRotationCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String s1 = sc.nextLine();
        System.out.print("Enter second string: ");
        String s2 = sc.nextLine();

        if (s1.length() == s2.length() && (s1 + s1).contains(s2)) {
            System.out.println("Yes, it's a rotation.");
        } else {
            System.out.println("No, it's not a rotation.");
        }
    }
}
