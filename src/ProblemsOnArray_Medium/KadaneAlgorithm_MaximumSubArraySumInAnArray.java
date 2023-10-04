package ProblemsOnArray_Medium;

/**
 * Given an array arr, find the contiguous subarray(contining at least one number) which has the largest sum and return its
 * sum and print the sub-array.
 */
public class KadaneAlgorithm_MaximumSubArraySumInAnArray {
    public static int approach_1(int[] arr, int N) {
        int maxi = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {

                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                maxi = Math.max(maxi, sum);
            }
        }
        return maxi;
    }

    public static int approach_2(int[] arr, int N) {
        int maxi = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = i; j < N; j++) {
                sum += arr[j];
                maxi = Math.max(maxi, sum);
            }
        }
        return maxi;
    }

    /**
     * Kadane's Algorithm
     *
     * @param arr
     * @param N
     * @return
     */
    public static int approach_3(int[] arr, int N) {
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];

            if (sum > maxi) {
                maxi = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxi;
    }

    /**
     * To print sub-array value which has maximum sum
     *
     * @param arr
     * @param N
     * @return
     */
    public static int approach_4(int[] arr, int N) {
        int maxi = Integer.MIN_VALUE;
        int sum = 0;

        int start = 0;
        int ansStart = -1, ansEnd = -1;
        for (int i = 0; i < N; i++) {
            if (sum == 0) start = i;
            sum += arr[i];
            if (sum > maxi) {
                maxi = sum;
                ansStart=start;
                ansEnd=i;
            }
            if (sum < 0) {
                sum = 0;
            }
        }

        System.out.print("The sub-array is: [");
        for(int i=ansStart; i<=ansEnd; i++){
            System.out.print(arr[i]+",");
        }
        System.out.println("]");
        return maxi;
    }

    public static void main(String[] args) {
//        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};

        int N = arr.length;
        int maxSum = approach_4(arr, N);
        System.out.println("The maximum sub-array sum is: " + maxSum);
    }
}
