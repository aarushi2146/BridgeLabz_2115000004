import java.util.Arrays;
public class RandomNumberStats {
    public static int[] generate4DigitRandomArray(int size) {
        int[] randomNumbers = new int[size];
        for (int i = 0; i < size; i++) {
            randomNumbers[i] = (int) (Math.random() * 9000) + 1000;
        }
        return randomNumbers;
    }
    public static double[] findAverageMinMax(int[] numbers) {
        double[] result = new double[3];
        int min = numbers[0];
        int max = numbers[0];
        double sum = 0;
        for (int num : numbers) {
            sum += num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        result[0] = sum / numbers.length;
        result[1] = min;
        result[2] = max;
        return result;
    }
    public static void main(String[] args) {
        int size = 5;
        int[] randomNumbers = generate4DigitRandomArray(size);
        double[] stats = findAverageMinMax(randomNumbers);
        System.out.println("Generated 4-digit random numbers: " + Arrays.toString(randomNumbers));
        System.out.println("Average: " + stats[0]);
        System.out.println("Minimum value: " + stats[1]);
        System.out.println("Maximum value: " + stats[2]);
    }
}

