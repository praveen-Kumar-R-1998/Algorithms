package ProblemsOnArrays_Hard;

import java.util.Arrays;

public class MergeTwoSortedArraysWithoutExtraSpace {

    public static void approach_1(long[] arr1, long[] arr2, int n, int m) {
        long[] arr3 = new long[n + m];
        int left = 0;
        int right = 0;
        int index = 0;

        while (left < n && right < m) {
            if (arr1[left] <= arr2[right]) {
                arr3[index] = arr1[left];
                left++;
                index++;
            } else {
                arr3[index] = arr2[right];
                right++;
                index++;
            }
        }
        while (left < n) {
            arr3[index++] = arr1[left++];
        }
        while (right < m) {
            arr3[index++] = arr2[right++];
        }

        for (int i = 0; i < n + m; i++) {
            if (i < n) {
                arr1[i] = arr3[i];
            } else {
                arr2[i - n] = arr3[i];
            }
        }
    }

    public static void approach_2(long[] arr1, long[] arr2, int n, int m) {
        int left = n - 1;
        int right = 0;
        while (left >= 0 && right < m) {
            if (arr1[left] > arr2[right]) {
                long temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;
                left--;
                right++;
            } else {
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    /**
     * Approach 3: Gap method
     *
     * @param args
     */
    public static void approach_3(long[] arr1, long[] arr2, int n, int m) {
        int length = n + m;
        int gap = (length / 2) + (length % 2);

        while (gap > 0) {
            int left = 0;
            int right = left + gap;

            while (right < length) {
//                case_1: left is in arr1[]
//                and right is in arr2[]
                if (left < n && right >= n) {
                    swapIfGreater(arr1, arr2, left, right - n);
                }
//                case_2: both pointers are in arr2[]
                else if (left >= n) {
                    swapIfGreater(arr2, arr2, left - n, right - n);
                }
//                case_3: both pointers are in arr1[]
                else {
                    swapIfGreater(arr1, arr1, left, right);
                }
                left++;
                right++;
            }
            if (gap == 1) break;
            gap = (gap / 2) + (gap % 2);
        }
    }

    public static void swapIfGreater(long[] arr1, long[] arr2, int index_1, int index_2) {
        if (arr1[index_1] > arr2[index_2]) {
            long temp = arr1[index_1];
            arr1[index_1] = arr2[index_2];
            arr2[index_2] = temp;
        }
    }

    public static void main(String[] args) {
        long[] arr1 = {1, 4, 8, 10};
        long[] arr2 = {2, 3, 9};
        int n = 4, m = 3;
        approach_1(arr1, arr2, n, m);
        System.out.println("The merged arrays are: ");
        System.out.print("arr1[] = ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.print("\narr2[] = ");
        for (int i = 0; i < m; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
        System.out.println("******************************\n******************************\n******************************");

        approach_2(arr1, arr2, n, m);
        System.out.println("The merged arrays are: ");
        System.out.print("arr1[] = ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.print("\narr2[] = ");
        for (int i = 0; i < m; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
        System.out.println("******************************\n******************************\n******************************");

        approach_3(arr1, arr2, n, m);
        System.out.println("The merged arrays are: ");
        System.out.print("arr1[] = ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.print("\narr2[] = ");
        for (int i = 0; i < m; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();


    }
}
