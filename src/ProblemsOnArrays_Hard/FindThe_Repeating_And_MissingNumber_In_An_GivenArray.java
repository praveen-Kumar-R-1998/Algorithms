package ProblemsOnArrays_Hard;

import java.io.FileOutputStream;

/**
 * We are given a read only array of N-integers. Each integer appears exactly once except for A which appears twice and B which is missing. Task
 * is to find A and B which is repeating and missing.
 */
public class FindThe_Repeating_And_MissingNumber_In_An_GivenArray {
    /**
     * Brut force approach
     *
     * @param arr
     * @param size
     * @return
     */
    public static int[] approach_1(int[] arr, int size) {
        int repeatingNumber = -1, missingNumber = -1;
        for (int i = 1; i <= size; i++) {
            int count = 0;
            for (int j = 0; j < size; j++) {
                if (arr[j] == i) count++;
            }
            if (count == 2) repeatingNumber = i;
            else if (count == 0) {
                missingNumber = i;
            }
            if (repeatingNumber != -1 && missingNumber != -1) break;
        }
        int[] ans = {repeatingNumber, missingNumber};
        return ans;
    }

    /**
     * Better Approach using hash function
     *
     * @param arr
     * @param size
     * @return
     */
    public static int[] approach_2(int[] arr, int size) {
        int[] hash = new int[size + 1];
        for (int i = 0; i < size; i++) {
            hash[arr[i]]++;
        }
        int repeatingNumber = -1, missingNumber = 1;
        for (int i = 1; i <= size; i++) {
            if (hash[i] == 2) repeatingNumber = i;
            else if (hash[i] == 0) {
                missingNumber = i;
            }
            if (repeatingNumber != -1 && missingNumber != -1) {
                break;
            }
        }
        int[] ans = {repeatingNumber, missingNumber};
        return ans;

    }

    public static int[] approach_3(int[] arr, int size) {
        /**
         * Formula to find sum of first N natural number
         * (N*(N+1))/2
         *
         * Formula to find sum of first N2(N square) natural number
         * ((N*(N+1)(2*N+1))/6
         */
//        To find N and N2
        long sumOfNaturalNumber = (size * (size + 1)) / 2;
        long sumOfSquareOfNaturalNumber = (size * (size + 1) * (2 * size + 1)) / 6;

//        calculate N and N2
        long sum = 0, sumSquare = 0;
        for (int i = 0; i < size; i++) {
            sum += arr[i];
            sumSquare += arr[i] * arr[i];
        }
            /**
             * sum-sumOfNaturalNumber = X-Y
             * sum = sum of given array
             * sumOfNaturalNumber = sum of given array size
             */
            long value_1 = sumOfNaturalNumber - sum;

            /**
             * sumSquare-sumOfSquareOfNaturalNumber = (X^2+Y^2)
             * sumSquare = sum of square of given array numbers
             * sumOfSquareOfNaturalNumber = sum of square of given array number size
             */
            long value_2 = sumSquare - sumOfSquareOfNaturalNumber;

            /**
             * To find X+Y = ((X^2+Y^2))/(X-Y)
             */
            value_2 = value_2/value_1;

            /**
             * To find X and Y where X-->Repeating number and Y-->missing number
             * X = ((X+Y)+(X-Y))/2 and Y=X-(X-y)
             * Here X-Y = value_1 and X+Y = value_2
             */

            long X = (value_1+value_2)/2;
            long Y = X-value_1;
        int[] ans = {(int)X,(int)Y};
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 5, 4, 6, 7, 5};
        int size = arr.length;
        int[] result_1 = approach_1(arr, size);
        System.out.println("The repeating number is: " + result_1[0]);
        System.out.println("The missing number is: " + result_1[1]);
        System.out.println("******************************\n******************************");
        int[] result_2 = approach_1(arr, size);
        System.out.println("The repeating number is: " + result_2[0]);
        System.out.println("The missing number is: " + result_2[1]);
        System.out.println("******************************\n******************************");
        int[] result_3 = approach_1(arr, size);
        System.out.println("The repeating number is: " + result_3[0]);
        System.out.println("The missing number is: " + result_3[1]);
    }
}
