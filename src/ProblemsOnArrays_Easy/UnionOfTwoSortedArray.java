package ProblemsOnArrays_Easy;

import java.util.*;

public class UnionOfTwoSortedArray {

    public static void approach_1(int[] arr1, int arr_1_Size, int[] arr2, int arr_2_Size) {
//        Set<Integer> set1 = new HashSet<>(); //It will give unordered retrieval
//        Set<Integer> set1 = new LinkedHashSet<>();  //It will give insertion order retrieval
        Set<Integer> set1 = new TreeSet<>(); //It will give sorted order retrieval
        for (int i = 0; i < arr_1_Size; i++) {
            set1.add(arr1[i]);
        }
        for (int i = 0; i < arr_2_Size; i++) {
            set1.add(arr2[i]);
        }
        System.out.println(set1);
    }

    /**
     * For approach_2 to work the arrays that are been passed should be sorted
     *
     * @param arr1
     * @param size1
     * @param arr2
     * @param size2
     * @return
     */
    public static ArrayList<Integer> approach_2(int[] arr1, int size1, int[] arr2, int size2) {
        int i = 0, j = 0;
        ArrayList<Integer> union = new ArrayList<>();
        while (i < size1 && j < size2) {
            if (arr1[i] <= arr2[j]) {
                if (union.size() == 0 || union.get(union.size() - 1) != arr1[i]) {
                    union.add(arr1[i]);
                }
                i++;
            } else {
                if (union.size() == 0 || union.get(union.size() - 1) != arr2[j]) {
                    union.add(arr2[j]);
                }
                j++;
            }
        }
        while (i < size1) {
            if (union.get(union.size() - 1) != arr1[i]) {
                union.add(arr1[i]);
            }
            i++;
        }
        while (j < size2) {
            if (union.get(union.size() - 1) != arr2[j]) {
                union.add(arr2[j]);
            }
            j++;
        }
        return union;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 4, 5};
        int size1 = arr1.length;
        int[] arr2 = {3, 4, 5, 6, 7, 12, 14};
        int size2 = arr2.length;
        approach_1(arr1, size1, arr2, size2);
        ArrayList<Integer> result = approach_2(arr1, size1, arr2, size2);
        for (int i : result) {
            System.out.print(i + ", ");
        }
        System.out.println();

    }
}
