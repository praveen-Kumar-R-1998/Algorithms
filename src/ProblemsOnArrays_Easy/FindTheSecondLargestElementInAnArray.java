package ProblemsOnArrays_Easy;

import java.util.Arrays;

public class FindTheSecondLargestElementInAnArray {
    public static void approach_1(int[] arr){
        Arrays.sort(arr);
        System.out.println("Second Largest Element in the array is: "+arr[arr.length-2]);
    }

    public static void approach_2(int[] arr){
        for(int i=0; i<arr.length; i++){
            int largest = i;
            for(int j=i; j<arr.length; j++){
                if(arr[j]<arr[largest]){
                    largest=j;
                }
            }
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;

        }
        System.out.println("Second Largest Element in the array is: "+arr[arr.length-2]);
    }

    public static void main(String[] args) {
        int[] arr = {6,5,4,3,2,1};
        approach_1(arr);
        approach_2(arr);
    }
}
