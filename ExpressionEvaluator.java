import java.util.Stack;

public class ExpressionEvaluator {

    public static int evaluate(String expr) {
        Stack<Integer> values = new Stack<>();
        Stack<Character> operators = new Stack<>();

        expr = expr.replaceAll(" ", "");  // remove all spaces

        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);

            if (ch == '(') {
                // do nothing
            } else if (Character.isDigit(ch)) {
                int num = 0;
                while (i < expr.length() && Character.isDigit(expr.charAt(i))) {
                    num = num * 10 + (expr.charAt(i) - '0');
                    i++;
                }
                i--; // step back after digit sequence
                values.push(num);
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                operators.push(ch);
            } else if (ch == ')') {
                int b = values.pop();
                int a = values.pop();
                char op = operators.pop();
                int result = applyOp(a, b, op);
                values.push(result);
            }
        }
        return values.pop();
    }

    private static int applyOp(int a, int b, char op) {
        return switch (op) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> a / b;
            default -> throw new IllegalArgumentException("Unknown operator: " + op);
        };
    }

    public static void main(String[] args) {
        String input = "((2 + 3) * (4 + (5 * 6)))";
        int result = evaluate(input);
        System.out.println("Result: " + result);
    }
}
