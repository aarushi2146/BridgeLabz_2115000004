
public class QuickSort {
    public static void main(String[] args) {
        int[] productPrices = {1000, 500, 300, 1500, 700, 1200};
        quickSort(productPrices, 0, productPrices.length - 1);
        for (int i = 0; i < productPrices.length; i++) {
            System.out.print(productPrices[i] + " ");
        }
    }
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;      
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
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
}

