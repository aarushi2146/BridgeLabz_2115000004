
public class InsertionSort {
    public static void main(String[] args) {
        int[] employeeIDs = {101, 45, 78, 12, 56, 89};
        insertionSort(employeeIDs);
        for (int i = 0; i < employeeIDs.length; i++) {
            System.out.print(employeeIDs[i] + " ");
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}

