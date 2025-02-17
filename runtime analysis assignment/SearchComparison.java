import java.util.Arrays;
import java.util.Random;
public class SearchComparison {
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    public static void runSearchTests(int dataSize) {
        Random rand = new Random();
        int[] dataset = new int[dataSize];
        for (int i = 0; i < dataSize; i++) {
            dataset[i] = rand.nextInt(dataSize * 10);
        }
        int target = dataset[rand.nextInt(dataSize)];
        long start = System.nanoTime();
        linearSearch(dataset, target);
        long linearTime = System.nanoTime() - start;
        Arrays.sort(dataset);
        start = System.nanoTime();
        binarySearch(dataset, target);
        long binaryTime = System.nanoTime() - start;
        System.out.println("Dataset Size: " + dataSize);
        System.out.println("Linear Search Time: " + linearTime / 1_000_000.0 + " ms");
        System.out.println("Binary Search Time: " + binaryTime / 1_000_000.0 + " ms");
    }
    public static void main(String[] args) {
        int[] sizes = {1_000, 10_000, 1_000_000}; // Test cases
        for (int size : sizes) {
            runSearchTests(size);
        }
    }
}
