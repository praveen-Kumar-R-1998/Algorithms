package ProblemsOnArrays_Easy;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithGivenSum_K {
    /**
     * Time complexity n3(Brut force approach)
     *
     * @param arr
     * @param N     ---> Size of the array
     * @param value ---> desired sum for the sub-array
     */
    public static long approach_1(int[] arr, int N, int value) {

        int longest = 0;

        for (int i = 0; i < N; i++) { //starting index
            for (int j = i; j < N; j++) { //ending index
                long sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                if (sum == value) longest = Integer.max(longest, (j - i + 1));
            }
        }
        return longest;
    }

    /**
     * Time complexity n2 (Brut force approach)
     *
     * @param arr
     * @param N
     * @param value
     * @return
     */
    public static long approach_2(int[] arr, int N, int value) {

        int longest = 0;

        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = i; j < N; j++) {
                sum += arr[j];
                if (sum == value) longest = Integer.max(longest, (j - i + 1));
            }
        }
        return longest;
    }

    /**
     * Using Hashing technique
     * <p>
     * Here we start from the 0th index and iterate till the last index
     *
     * @param arr
     * @param N
     * @param value
     */
    public static long approach_3(int[] arr, int N, int value) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        int sum = 0;
        int maxLength = 0;

        for (int i = 0; i < N; i++) {
            sum += arr[i];

            if (sum == value) {
                maxLength = Math.max(maxLength, i + 1);
            }
            int rem = sum - value;
            if (sumMap.containsKey(rem)) {
                int len = i - sumMap.get(rem);
                maxLength = Math.max(maxLength, len);
            }
            if (!sumMap.containsKey(rem)) {
                sumMap.put((int) sum, i);
            }
        }
        return maxLength;
    }

    /**
     * Using two pointer approach (best approach)
     *
     * @param arr
     * @param N
     * @param value
     */
    public static int approach_4(int[] arr, int N, int value) {
        int left = 0;
        int right = 0;
        int sum = arr[0];
        int maxLength = 0;

        while (right < N) {
            while (left <= right && sum > value) {
                sum -= arr[left];
                left++;
            }
            if (sum == value) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
            right++;
            if (right < N) {
                sum += arr[right];
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 1, 1, 1};
        int size = arr.length;
        int value = 3;
//        System.out.println(approach_1(arr,size,value));
        System.out.println(approach_4(arr, size, value));
    }
}
