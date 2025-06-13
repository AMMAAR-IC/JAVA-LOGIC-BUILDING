public class MissingNumber {
    public static int findMissing(int[] arr, int n) {
        int total = n * (n + 1) / 2;
        int sum = 0;
        for (int num : arr) sum += num;
        return total - sum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6}; // Missing: 3
        System.out.println("Missing: " + findMissing(arr, 6));
    }
} 
