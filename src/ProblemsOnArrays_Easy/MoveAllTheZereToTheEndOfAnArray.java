package ProblemsOnArrays_Easy;

import java.util.ArrayList;

public class MoveAllTheZereToTheEndOfAnArray {

    /**
     * In approach_1 we will make use of a temporary array to store all the non-zero numbers and then reassign them to
     * the original array from the starting and once it is done then remaining places will be occupied by hte zero till
     * the size of the original arrya
     *
     * @param arr  ---> array to be sorted
     * @param size ---> size of the array that is to be sorted
     */
    public static void approach_1(int[] arr, int size) {
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) array.add(arr[i]);
        }
        for (int i = 0; i < array.size(); i++) {
            arr[i] = array.get(i);
        }
        for (int i = array.size(); i < size; i++) {
            arr[i] = 0;
        }
    }

    public static void approach_2(int[] arr, int size) {
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] == 0) {
                j = i;
                System.out.println("Value of J is: " + j);
                break;
            }
        }

        for (int i = j + 1; i < size; i++) {
            if (arr[i] != 0) {
                swap(arr, i, j);
                j++;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 0, 3, 0, 4, 0, 0, 0, 0, 5, 0, 6, 7, 0, 7, 0, 5};
        int size = arr.length;

        System.out.println("Array before sorting: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        approach_1(arr, size);
        approach_2(arr, size);

        System.out.println("Array after sorting: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
