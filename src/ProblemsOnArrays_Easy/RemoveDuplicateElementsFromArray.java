package ProblemsOnArrays_Easy;

import java.util.HashSet;


/**
 * Here we are removing duplicate elements from the array
 *
 * There are two approach
 *      1. In first approach we use HashSet data structure to filter the duplicate elements from the array
 *      2. In second approach we use two pointers
 */
public class RemoveDuplicateElementsFromArray {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6};
        int size = arr.length;
//        int k = approach_1(arr,size);
        int k = approach_2(arr,size);

        System.out.println("Array size before removing duplicate element is: "+size);
        System.out.println("Array size after removing duplicate element is: "+k);
        System.out.println("Elements in the array are");
        for(int i=0; i<k; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();

    }

    public static int approach_1(int[] arr, int size) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            set.add(arr[i]);
        }
        int k = set.size();
        int j = 0;
        for (int x : set) {
            arr[j++] = x;
        }
        return k;
    }

    public static int approach_2(int[] arr, int size){
        int i = 0;
        for(int j=0; j< size; j++){
            if(arr[i] != arr[j]){
                i++;
                arr[i]=arr[j];
            }
        }
        return i+1;
    }
}
