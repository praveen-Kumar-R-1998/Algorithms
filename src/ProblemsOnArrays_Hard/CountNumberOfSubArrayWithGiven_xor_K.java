package ProblemsOnArrays_Hard;

import java.util.HashMap;
import java.util.Map;

/**
 * XOR operation example
 * int a = 5;    // Binary: 0101
 * int b = 3;    // Binary: 0011
 * int result = a ^ b; // Binary: 0110 (Decimal: 6)
 * Same number(In binary) will be converted into 0 and if different number then it will be
 */
public class CountNumberOfSubArrayWithGiven_xor_K {

    /**
     * Brut force approach
     * <p>
     * Here we try to get the sub array using three for loops
     *
     * @param arr
     * @param size
     * @param target
     * @return
     */
    public static int approach_1(int[] arr, int size, int target) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                int x_OR = 0;
                for (int k = i; k <= j; k++) {
                    x_OR = x_OR ^ arr[k];
                }
                if (x_OR == target) count++;
            }
        }
        return count;
    }

    /**
     * Optimal approach
     * <p>
     * Here we try to eliminate the third
     *
     * @param arr
     * @param size
     * @param target
     * @return
     */
    public static int approach_2(int[] arr, int size, int target) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            int x_OR = 0;
            for (int j = i; j < size; j++) {
                x_OR = x_OR ^ arr[j];
                if (x_OR == target) count++;
            }
        }
        return count;
    }

    public static int approach_3(int[] arr, int size, int target) {
        int x_OR = 0;
        Map<Integer, Integer> maps = new HashMap<>(); //x_OR value and count value
        maps.put(x_OR, 1);
        int count = 0;
        
        for (int i = 0; i < size; i++) {
            x_OR = x_OR ^ arr[i];
            int x = x_OR ^ target;

            if (maps.containsKey(x)) {
                count += maps.get(x);
            }

            if (maps.containsKey(x_OR)) {
                maps.put(x_OR, maps.get(x_OR) + 1);
            } else {
                maps.put(x_OR, 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 6, 4};
        int size = arr.length;
        int target = 6;
        System.out.println("Approach 1 answer: " + approach_1(arr, size, target));
        System.out.println("Approach 2 answer: " + approach_2(arr, size, target));
        System.out.println("Approach 3 answer: " + approach_3(arr, size, target));


    }
}
