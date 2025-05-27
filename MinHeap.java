package heaps;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MinHeap {
    private ArrayList<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    /**
     * Inserts a new key into the heap.
     */
    public void insert(int val) {
        heap.add(val);
        siftUp(heap.size() - 1);
    }

    /**
     * Returns the minimum element without removing it.
     */
    public int peek() {
        if (heap.isEmpty()) throw new NoSuchElementException("Heap is empty");
        return heap.get(0);
    }

    /**
     * Removes and returns the minimum element from the heap.
     */
    public int extractMin() {
        if (heap.isEmpty()) throw new NoSuchElementException("Heap is empty");
        int min = heap.get(0);
        int last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            siftDown(0);
        }
        return min;
    }

    /**
     * Heap sort: sorts an array in-place using this MinHeap.
     */
    public static void heapSort(int[] arr) {
        MinHeap h = new MinHeap();
        for (int v : arr) h.insert(v);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = h.extractMin();
        }
    }

    private void siftUp(int idx) {
        while (idx > 0) {
            int parent = (idx - 1) / 2;
            if (heap.get(idx) < heap.get(parent)) {
                swap(idx, parent);
                idx = parent;
            } else break;
        }
    }

    private void siftDown(int idx) {
        int n = heap.size();
        while (true) {
            int left = 2 * idx + 1;
            int right = 2 * idx + 2;
            int smallest = idx;
            if (left < n && heap.get(left) < heap.get(smallest)) smallest = left;
            if (right < n && heap.get(right) < heap.get(smallest)) smallest = right;
            if (smallest != idx) {
                swap(idx, smallest);
                idx = smallest;
            } else break;
        }
    }

    private void swap(int i, int j) {
        int tmp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, tmp);
    }

    // Demo
    public static void main(String[] args) {
        int[] data = { 5, 3, 8, 1, 2, 9, 4 };
        System.out.println("Before: " + java.util.Arrays.toString(data));
        MinHeap.heapSort(data);
        System.out.println("After:  " + java.util.Arrays.toString(data));

        MinHeap pq = new MinHeap();
        pq.insert(7);
        pq.insert(2);
        pq.insert(6);
        System.out.println("Min element: " + pq.peek());
        System.out.println("Extracting: " + pq.extractMin());
        System.out.println("Now min: " + pq.peek());
    }
}
