
public class SelectionSort {
    public static void main(String[] args) {
        int[] examScores = {88, 92, 75, 98, 84, 67};
        selectionSort(examScores);
        for (int i = 0; i < examScores.length; i++) {
            System.out.print(examScores[i] + " ");
        }
    }
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}


