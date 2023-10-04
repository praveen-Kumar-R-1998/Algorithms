package ProblemsOnArray_Medium;

import java.util.HashMap;
import java.util.Map;

public class MajorityElementWhichAppearsMoreThanHalfOf_N_times {

    /**
     * Using linear search aproach
     *
     * @param arr
     * @param N
     * @return
     */
    public static int approach_1(int[] arr, int N) {

        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count > (N / 2)) return arr[i];
        }
        return -1;
    }

    /**
     * Using hash map data structure
     *
     * @param arr
     * @param N
     */
    public static int approach_2(int[] arr, int N) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int value = map.getOrDefault(arr[i], 0);
            map.put(arr[i], value + 1);
        }

        for (Map.Entry<Integer, Integer> mapValue : map.entrySet()) {
            if (mapValue.getValue() > (N / 2)) {
                return mapValue.getKey();
            }
        }
        return -1;
    }

    public static int approach_3(int[] arr, int N) {
        int count = 0;
        int element = 0;
        for (int i = 0; i < arr.length; i++) {
            if (count == 0) {
                count = 1;
                element = arr[i];
            } else if (element == arr[i]) {
                count++;
            } else {
                count--;
            }
        }
        int counter = 0;
        for (int i = 0; i < N; i++) {
            if(arr[i]==element) counter++;
        }

        if(counter>(N/2)) return element;
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 1, 1, 2, 2, 2, 2};
        int size = arr.length;
        System.out.println("Number which appears greater than half the size of array is: " + approach_3(arr, size));
    }
}
