import java.util.*;

public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];

        Deque<Integer> deque = new LinkedList<>();
        int[] output = new int[nums.length - k + 1];
        int outIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peek() < i - k + 1)
                deque.poll();

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
                deque.pollLast();

            deque.offer(i);

            if (i >= k - 1)
                output[outIndex++] = nums[deque.peek()];
        }
        return output;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println("Sliding window max: " + Arrays.toString(maxSlidingWindow(arr, k)));
    }
}
