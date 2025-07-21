import java.util.*;

public class LineSweepOverlap {
    public static void main(String[] args) {
        int[][] intervals = {{1, 5}, {2, 6}, {4, 8}, {7, 9}};
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int[] interval : intervals) {
            map.put(interval[0], map.getOrDefault(interval[0], 0) + 1);
            map.put(interval[1], map.getOrDefault(interval[1], 0) - 1);
        }

        int maxOverlap = 0, active = 0;
        for (int change : map.values()) {
            active += change;
            maxOverlap = Math.max(maxOverlap, active);
        }

        System.out.println("Maximum Overlapping Intervals: " + maxOverlap);
    }
}
