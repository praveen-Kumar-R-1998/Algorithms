package Algorithms;

/**
 * HERE WE SELECT AN ELEMENT AND MOVE THEM TO THE LEFT SIDE OF THE ARRAY
 *
 * Here we first use a for loop select the element starting from element 0 till the size-1
 * and we assign that variable to j, Now inside the for loop we use another while loop where the element comparison is done
 * So we compare the element with index less than that and if condition satisfies then we swap the element
 */
public class _3_InsertionSort {
    public static void sort(int[] arr, int size){
        for(int i=0; i<=size-1; i++){
            int j=i;
            while(j>0 && arr[j-1]>arr[j]){
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1,10,9,8,7,6};
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
