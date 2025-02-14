
public class CountingSort {
    public static void main(String[] args) {
        int[] studentAges = {12, 15, 14, 18, 10, 17, 13, 16, 15};
        countingSort(studentAges, 10, 18);
        for (int i = 0; i < studentAges.length; i++) {
            System.out.print(studentAges[i] + " ");
        }
    }
    public static void countingSort(int[] arr, int min, int max) {
        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }
        System.arraycopy(output, 0, arr, 0, arr.length);
    }
}


