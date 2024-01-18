package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class FindSingleElementInAnSortedArray {

    public static int linearSearchApproach(ArrayList<Integer> arr) {
        if (arr.size() == 1) {
            return arr.get(0);
        }

        for (int i = 0; i < arr.size(); i++) {
            if (i == 0) {
                if (!arr.get(i).equals(arr.get(i + 1))) {
                    return arr.get(i);
                }
            } else if (i == arr.size() - 1) {
                if (!arr.get(i).equals(arr.get(i - 1)))
                    return arr.get(i);
            } else {
                if (!arr.get(i).equals(arr.get(i - 1)) && !arr.get(i).equals(arr.get(i + 1)))
                    return arr.get(i);
            }
        }

        return -1;
    }

    public static int conditionalOperatorMethod(ArrayList<Integer> arr) {
        int ans = 0;
        for (int i = 0; i < arr.size(); i++) {
            ans = ans ^ arr.get(i);
        }
        return ans;
    }

    public static int binarySearchMethod(ArrayList<Integer> arr) {
        int size = arr.size();

        if (size == 1) {
            return arr.get(0);
        }
        if (!arr.get(0).equals(arr.get(1))) {
            return arr.get(1);
        }
        if (!arr.get(size - 1).equals(arr.get(size - 2))) {
            return arr.get(size - 1);
        }

        int low = 1, high = size - 2;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (!arr.get(mid).equals(arr.get(mid - 1)) && !arr.get(mid).equals(arr.get(mid + 1))) {
                return arr.get(mid);
            }
            /**
             * if we are standing on the even index and the immediate next index is same(values) then we are that we are stanging on the left
             * side of the mid of the array
             * 1. (even,odd): element is on the right half(We are standing on the left half so eliminate left)
             * 2. (odd,even): element is on the left half (We are standing on the right half so eliminate right)
             *
             * say mid is 5 which is an odd number and if it satisfies any one condition i.e 1 and 2
             */
            if ((mid % 2 == 1 && arr.get(mid).equals(arr.get(mid - 1))) || (mid % 2 == 0 && arr.get(mid).equals(arr.get(mid + 1)))) {
                low = mid + 1;
            }else {
                high=mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6));
        int ans_1 = linearSearchApproach(arr);
        System.out.println("Single element in the given array is: " + ans_1);

        int ans_2 = conditionalOperatorMethod(arr);
        System.out.println("Single element in the given array is: " + ans_2);

        int ans_3 = binarySearchMethod(arr);
        System.out.println("Single element in the given array is: " + ans_3);

    }
}
