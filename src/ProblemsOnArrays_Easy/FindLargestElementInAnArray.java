package ProblemsOnArrays_Easy;

import java.util.Arrays;

public class FindLargestElementInAnArray {

    /*
    * Using Inbuilt approach
    */
    public static void approach_1(int[] arr){
        Arrays.sort(arr);
        System.out.println("Largest element in the array is: "+arr[arr.length-1]);
    }

    public static void approach_2(int[] arr){
        for(int i=0; i<arr.length-1; i++){
            int min = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[j]<arr[min]){
                    min=j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i]=temp;
        }

        System.out.println("Largest element in the array is "+ arr[arr.length-1]);

    }
    public static void approach_3(int[] arr){
        int max = arr[0];
        for(int i=0; i<arr.length; i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        System.out.println("Highest element in the array is: "+max);
    }

    public static void main(String[] args) {
        int arr[] = {100,45,23,56,76,123};

        System.out.print("Array before sorting: ");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        approach_1(arr);
        System.out.println("********************##########********************");
        approach_2(arr);
        System.out.println("********************##########********************");

        approach_3(arr);

        System.out.print("Array after sorting: ");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
