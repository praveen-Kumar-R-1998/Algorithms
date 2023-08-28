package Algorithms;

public class _5_RecursiveBubbleSort {
    public static void sort(int[] arr, int size){
        if(size==1) return;
        for(int j=0; j<size-1; j++){
            if(arr[j]>arr[j+1]){
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
        sort(arr, size-1);
    }

    public static void main(String[] args) {
        int[] arr = {6,5,4,3,2,1};
        int size = arr.length;
        System.out.println("Array before sorting: ");
        for(int i=0; i<size; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        sort(arr,size);
        System.out.println("Array After sorting: ");
        for(int i=0; i<size; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();

    }
}
