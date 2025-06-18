import java.util.Scanner;

public class NextPermutation {

    public static void nextPermutation(char[] arr) {
        int i = arr.length - 2;

        // Step 1: Find first decreasing element from the end
        while (i >= 0 && arr[i] >= arr[i + 1])
            i--;

        if (i < 0) {
            System.out.println("No next permutation");
            return;
        }

        // Step 2: Find the smallest character on right of i which is larger than arr[i]
        int j = arr.length - 1;
        while (arr[j] <= arr[i])
            j--;

        // Step 3: Swap
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        // Step 4: Reverse from i+1 to end
        int left = i + 1, right = arr.length - 1;
        while (left < right) {
            temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        System.out.println("Next permutation: " + new String(arr));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        nextPermutation(input.toCharArray());
    }
}
