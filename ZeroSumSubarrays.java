
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
public class ZeroSumSubarrays {
    public static List<List<Integer>> findSubarrays(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int cumulativeSum = 0;
        map.put(0, new ArrayList<>());
        for (int i = 0; i < arr.length; i++) {
            cumulativeSum += arr[i];
            if (map.containsKey(cumulativeSum)) {
                ArrayList<Integer> indices = map.get(cumulativeSum);
                for (int index : indices) {
                    List<Integer> subarray = new ArrayList<>();
                    for (int j = index + 1; j <= i; j++) {
                        subarray.add(arr[j]);
                    }
                    result.add(subarray);
                }
            }
            if (!map.containsKey(cumulativeSum)) {
                map.put(cumulativeSum, new ArrayList<>());
            }
            map.get(cumulativeSum).add(i);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {6, -1, -3, 4, -2, 2, 5, -5};
        List<List<Integer>> subarrays = findSubarrays(arr);
        for (List<Integer> subarray : subarrays) {
            System.out.println(subarray);
        }
    }
}

