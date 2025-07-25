import java.util.*;

public class TopKFrequent {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums)
            freq.put(num, freq.getOrDefault(num, 0) + 1);

        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(freq::get));
        for (int num : freq.keySet()) {
            heap.offer(num);
            if (heap.size() > k) heap.poll();
        }

        List<Integer> result = new ArrayList<>();
        while (!heap.isEmpty()) result.add(heap.poll());
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3, 4, 4, 4};
        int k = 2;
        System.out.println(topKFrequent(nums, k));  // Output: [1, 4]
    }
}
