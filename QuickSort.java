package algorithms;

public class QuickSort {

    /** Public API: sorts the entire array in-place */
    public static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    /** Internal recursive method */
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    /** Lomuto partition scheme */
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];       // choose last element as pivot
        int i = low - 1;             // place for the smaller element
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    /** Utility to swap two elements */
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /** Quick demonstration */
    public static void main(String[] args) {
        int[] data = { 33, 10, 55, 71, 29, 3, 18, 42 };
        System.out.println("Before: " + java.util.Arrays.toString(data));
        QuickSort.sort(data);
        System.out.println("After:  " + java.util.Arrays.toString(data));
    }
}
