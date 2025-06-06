import java.util.*;

public class TruthTableSolver {
    public static void main(String[] args) {
        System.out.println("Truth Table for: (A AND NOT B) OR (B AND NOT C)");

        boolean[] values = {true, false};
        System.out.printf("%-6s %-6s %-6s %-6s\n", "A", "B", "C", "Result");

        for (boolean A : values) {
            for (boolean B : values) {
                for (boolean C : values) {
                    boolean result = (A && !B) || (B && !C);
                    System.out.printf("%-6s %-6s %-6s %-6s\n", A, B, C, result);
                }
            }
        }
    }
}
