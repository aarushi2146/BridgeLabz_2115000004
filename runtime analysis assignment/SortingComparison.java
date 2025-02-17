import java.util.Arrays;
import java.util.Random;
public class SortingComparison {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1, n2 = right - mid;
        int[] L = new int[n1], R = new int[n2];
        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            arr[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high], i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
    public static void runSortingTests(int dataSize) {
        Random rand = new Random();
        int[] dataset = new int[dataSize];
        for (int i = 0; i < dataSize; i++) {
            dataset[i] = rand.nextInt(dataSize * 10);
        }
        int[] datasetBubble = Arrays.copyOf(dataset, dataset.length);
        int[] datasetMerge = Arrays.copyOf(dataset, dataset.length);
        int[] datasetQuick = Arrays.copyOf(dataset, dataset.length);
        long start = System.nanoTime();
        bubbleSort(datasetBubble);
        long bubbleTime = System.nanoTime() - start;
        start = System.nanoTime();
        mergeSort(datasetMerge, 0, datasetMerge.length - 1);
        long mergeTime = System.nanoTime() - start;
        start = System.nanoTime();
        quickSort(datasetQuick, 0, datasetQuick.length - 1);
        long quickTime = System.nanoTime() - start;
        System.out.println("Dataset Size: " + dataSize);
        System.out.println("Bubble Sort Time: " + (bubbleTime / 1_000_000.0) + " ms");
        System.out.println("Merge Sort Time: " + (mergeTime / 1_000_000.0) + " ms");
        System.out.println("Quick Sort Time: " + (quickTime / 1_000_000.0) + " ms");
    }
    public static void main(String[] args) {
        int[] sizes = {1_000, 10_000, 1_000_000};
        for (int size : sizes) {
            runSortingTests(size);
        }
    }
}
