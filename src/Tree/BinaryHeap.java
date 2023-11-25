package Tree;

public class BinaryHeap {
    private final int[] heap;
    private int size;
    private final int capacity;

    public BinaryHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity + 1];
    }

    private int parent(int i) {
        return i / 2;
    }

    private int leftChild(int i) {
        return 2 * i;
    }

    private int rightChild(int i) {
        return 2 * i + 1;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void heapifyUp(int i) {
        while (i > 1 && heap[parent(i)] < heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    private void heapifyDown(int i) {
        int maxIndex = i;
        int left = leftChild(i);
        if (left <= size && heap[left] > heap[maxIndex]) {
            maxIndex = left;
        }
        int right = rightChild(i);
        if (right <= size && heap[right] > heap[maxIndex]) {
            maxIndex = right;
        }
        if (i != maxIndex) {
            swap(i, maxIndex);
            heapifyDown(maxIndex);
        }
    }

    public void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap is full. Cannot insert.");
            return;
        }
        size++;
        heap[size] = value;
        heapifyUp(size);
    }

    public int extractMax() {
        if (size == 0) {
            System.out.println("Heap is empty.");
            return -1; // Assuming -1 as a sentinel value for an empty heap
        }
        int result = heap[1];
        heap[1] = heap[size];
        size--;
        heapifyDown(1);
        return result;
    }

    public void printHeap() {
        for (int i = 1; i <= size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}