import java.util.Scanner;

public class ParenthesesBalancer {

    public static int minAddToMakeValid(String s) {
        int balance = 0, insertions = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                balance++;
            } else if (c == ')') {
                if (balance > 0) {
                    balance--;
                } else {
                    insertions++;  // need to insert '('
                }
            }
        }

        return insertions + balance; // balance is unclosed '('
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter parentheses string: ");
        String input = sc.nextLine();

        int result = minAddToMakeValid(input);
        if (result == 0) {
            System.out.println("✔️ Parentheses are balanced!");
        } else {
            System.out.println("❌ Need " + result + " insertions to balance.");
        }
    }
}
