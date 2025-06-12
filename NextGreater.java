import java.util.*;

public class NextGreater {
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 25};
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] > stack.peek()) {
                System.out.println(stack.pop() + " → " + arr[i]);
            }
            stack.push(arr[i]);
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop() + " → -1");
        }
    }
}
