package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchElementInAnRotatedSortedArrayWithDupliacateValue {

    public static int linearSearchApproach(ArrayList<Integer> arr, int target) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == target) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearchApproach(ArrayList<Integer> arr, int target) {
        int low = 0, high = arr.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr.get(mid) == target) {
                return mid;
            }

            if (arr.get(low) == arr.get(mid) && arr.get(mid) == arr.get(high)) {
                low = low + 1;
                high = high - 1;
                continue;
            }

//         Left part of the array is sorted
            if (arr.get(low) <= arr.get(mid)) {
                if (arr.get(low) <= target && target <= arr.get(mid)) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (arr.get(mid) <= target && target <= arr.get(high)) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(7, 8, 1, 2, 3, 3, 3, 4, 5, 6));
        int target = 1;
        int solution_1 = linearSearchApproach(arr, target);
        if (solution_1 != -1) {
            System.out.println("Target element " + target + " is found at index " + solution_1);
        } else {
            System.out.println("Target element is not found in the given array");
        }

        int solution_2 = binarySearchApproach(arr, target);
        if (solution_2 != -1) {
            System.out.println("Target element " + target + " is found at index " + solution_2);
        } else {
            System.out.println("Target element is not found in the given array");
        }
    }
}
