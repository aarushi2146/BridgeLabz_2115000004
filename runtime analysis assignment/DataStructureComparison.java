import java.util.*;
public class DataStructureComparison {
    public static boolean arraySearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return true;
            }
        }
        return false;
    }
    public static boolean hashSetSearch(HashSet<Integer> set, int target) {
        return set.contains(target);
    }
    public static boolean treeSetSearch(TreeSet<Integer> set, int target) {
        return set.contains(target);
    }
    public static void testSearchPerformance(int size, int target) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < size; i++) {
            hashSet.add(i);
            treeSet.add(i);
        }
        long start = System.nanoTime();
        boolean arrayResult = arraySearch(array, target);
        long arrayTime = System.nanoTime() - start;
        start = System.nanoTime();
        boolean hashSetResult = hashSetSearch(hashSet, target);
        long hashSetTime = System.nanoTime() - start;
        start = System.nanoTime();
        boolean treeSetResult = treeSetSearch(treeSet, target);
        long treeSetTime = System.nanoTime() - start;
        System.out.println("Searching in a dataset of size: " + size);
        System.out.println("Array Search Time: " + (arrayTime / 1_000_000.0) + " ms");
        System.out.println("HashSet Search Time: " + (hashSetTime / 1_000_000.0) + " ms");
        System.out.println("TreeSet Search Time: " + (treeSetTime / 1_000_000.0) + " ms");
    }
    public static void main(String[] args) {
        int[] testSizes = {1_000, 100_000, 1_000_000};
        int target = 500000;
        for (int size : testSizes) {
            testSearchPerformance(size, target);
        }
    }
}
