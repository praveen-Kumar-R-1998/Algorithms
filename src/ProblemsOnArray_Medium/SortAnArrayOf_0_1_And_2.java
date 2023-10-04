package ProblemsOnArray_Medium;

import java.util.Arrays;

public class SortAnArrayOf_0_1_And_2 {

    /**
     * Using arrays approach
     *
     * @param arr
     * @param N
     * @return
     */
    public static int[] approach_1(int[] arr, int N) {
        Arrays.sort(arr);
        return arr;
    }

    /**
     * Using counting approach
     *
     * @param arr
     * @param N
     * @return
     */
    public static int[] approach_2(int[] arr, int N) {
        int count_0 = 0;
        int count_1 = 0;
        int count_2 = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] == 0) count_0++;
            if (arr[i] == 1) count_1++;
            if (arr[i] == 2) count_2++;
        }

        for (int i = 0; i < count_0; i++) {
            arr[i] = 0;
        }

        for (int i = count_0; i < count_0 + count_1; i++) {
            arr[i] = 1;
        }

        for (int i = count_1 + count_0; i < N; i++) {
            arr[i] = 2;
        }
        return arr;
    }

    /**
     * Using Dutch national flag algorithm
     *
     * @param arr
     * @param N
     */
    public static int[] approach_3(int[] arr, int N) {
        int low = 0;
        int mid = 0;
        int high = N - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                int temp = arr[mid];
                arr[mid]=arr[high];
                arr[high]=temp;
                high--;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 0, 2, 1, 0};
        int size = arr.length;
        int[] result = approach_3(arr, size);
        for (int i = 0; i < size; i++) {
            System.out.println(result[i]);
        }
    }
}
