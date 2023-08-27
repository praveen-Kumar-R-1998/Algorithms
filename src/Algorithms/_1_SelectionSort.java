package Algorithms;

/**
 * HERE WE WILL PLACE THE LOWEST ELEMENT IN THE FIRST INDEX OF THE ARRAY
 *
 * Here we select the first element from the array and assume it as the minimum now in the inner loop we will check if there is any
 * other number smaller than the minimum if yes replace the minimum with the smaller number. After iteration finishes exchange the
 * minimum number with the first number in the array.
 * If the minimum number is same i.e. selected i value itself even then the replacement happens but the value will remain the same
 *
 * In the outer loop we will iterate till arraySize-1 because in the inner loop we are comparing the element with i+1 element and if
 * the i value comes to the last element and inside the loop we will be checking i+1 value which exceeds the array size and we will get
 * Exception called: arrayIndexOutOfBoundException and the program will crash.
 */
public class _1_SelectionSort {
    public static void sort(int[] arr, int size){
        for(int i=0; i<size-1; i++){
            int minimum = i;
            for(int j=i+1; j<size; j++){
                if(arr[j]<arr[minimum]){
                    minimum=j;
                }
            }
            int temp = arr[minimum];
            arr[minimum] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {10,9,8,7,6,5,4,3,2,1};
        int size = arr.length;
        System.out.println("Array before selection sorting: ");
        for(int i=0; i <size; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        sort(arr,size);

        System.out.println("Array after selection sorting: ");
        for(int i=0; i <size; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
