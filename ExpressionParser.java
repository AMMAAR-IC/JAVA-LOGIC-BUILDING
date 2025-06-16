import java.util.*;

public class ExpressionParser {

    public static int evaluate(String expr) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        int num = 0;
        char prev = '+';

        for (int i = 0; i <= expr.length(); i++) {
            char c = (i < expr.length()) ? expr.charAt(i) : '+';

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '(') {
                int j = i, brackets = 0;
                while (i < expr.length()) {
                    if (expr.charAt(i) == '(') brackets++;
                    if (expr.charAt(i) == ')') brackets--;
                    if (brackets == 0) break;
                    i++;
                }
                num = evaluate(expr.substring(j + 1, i));
            }

            if ("+-*/".indexOf(c) >= 0 || i == expr.length()) {
                switch (prev) {
                    case '+': nums.push(num); break;
                    case '-': nums.push(-num); break;
                    case '*': nums.push(nums.pop() * num); break;
                    case '/': nums.push(nums.pop() / num); break;
                }
                num = 0;
                prev = c;
            }
        }

        int res = 0;
        while (!nums.isEmpty()) res += nums.pop();
        return res;
    }

    public static void main(String[] args) {
        String input = "3 + (2 * (4 + 5)) - 6";
        System.out.println("Result: " + evaluate(input)); // Output: 15
    }
}
