package Algorithms;

/**
 * WE WILL PLACE THE HIGHEST ELEMENT IN THE LAST POSITION OF THE ARRAY BY CONTINUOUS SWAPPING.
 *
 * Here in bubble sort we will compare the first two element and if the first element is greater than the second element then we swap
 * both the element. BY following this till the end of the array the highest element will move to the end.
 *
 * Here the outer loop will start from last index element and continue till the first index element
 *
 * The inner loop element will start from first element continue till the i-1 index. This is inside the inner loop we are comparing
 * the current element with the next element to swap and the moment we reach the first element the comparison happens between 1 and 0
 * elements, so we stop the inner loop as soon as we reach the i-1 element
 */

public class _2_BubbleSort {
    public static void sort(int[] arr, int size){
        for(int i=size-1; i>=0; i--){

            for(int j=0; j<=i-1; j++){

                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {4,3,2,1};
        int size = arr.length;
        System.out.println("Array before sorting: ");
        for(int i=0; i<size; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        sort(arr,size);

        System.out.println("Array after sorting: ");
        for(int i=0; i<size; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();

    }
}
