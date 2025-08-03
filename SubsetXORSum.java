public class SubsetXORSum {
    public static void main(String[] args) {
        int[] nums = {1, 3};
        System.out.println("Total XOR sum of subsets: " + subsetXORSum(nums));
    }

    static int subsetXORSum(int[] nums) {
        int total = 0;
        int n = nums.length;
        int subsets = 1 << n; // 2^n subsets

        for (int mask = 0; mask < subsets; mask++) {
            int xor = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    xor ^= nums[i];
                }
            }
            total += xor;
        }

        return total;
    }
}
