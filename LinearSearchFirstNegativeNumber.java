
public class LinearSearchFirstNegativeNumber {
    public static void main(String[] args) {
        int[] array = {3, 5, -1, 7, 9, -2};
        int result = findFirstNegative(array);
        System.out.println("Index of first negative number: " + result);
    }
    public static int findFirstNegative(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                return i;
            }
        }
        return -1;
    }
}

