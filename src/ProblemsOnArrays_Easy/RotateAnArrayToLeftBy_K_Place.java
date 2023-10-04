package ProblemsOnArrays_Easy;


/**
 * Input array {1,2,3,4,5,6,7} left rotate by k=3 place
 * Output array {4,5,6,7,1,2,3}
 */
public class RotateAnArrayToLeftBy_K_Place {

    /**
     * @param arr  ---> Array
     * @param size ---> size of the array
     * @param k    ---> no if elements to be moved to left or right
     */
    public static void approach_1(int[] arr, int size, int k) {
        if (size == 0) return;

        k = k % size;
        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = arr[i];
        }

//        Here we are moving the array to front
        for (int i = k; i < size; i++) {
            arr[i - k] = arr[i];
        }

//        Here we are adding the temp array elements at the back of the main array
        int j = 0;
        for (int i = size - k; i < size; i++) {
            arr[i] = temp[j];
            j++;
        }
    }

    /**
     * In this approach we are getting rid of variable j
     *
     * @param arr  ---> Array
     * @param size ---> size of the array
     * @param k    ---> no if elements to be moved to left or right
     */
    public static void approach_2(int[] arr, int size, int k) {
        k = k % size;

        if (size == 0) return;

        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = arr[i];
        }

        for (int i = k; i < size; i++) {
            arr[i - k] = arr[i];
        }

        for (int i = size - k; i < size; i++) {
            arr[i] = temp[i - (size - k)];
        }
    }

    /**
     * In this approach we use array reversing technique where we
     *  1. split the given array from the value that has to be rotated
     *  2. Pass that array to reverse (first and second half of the array)
     *  3. Reverse the entire array 
     * @param arr
     * @param size
     * @param k
     */
    public static void approach_3(int[] arr, int size, int k) {
        reverse(arr,0, k-1);
        reverse(arr, k, size-1);
        reverse(arr,0,size-1);
    }

    public static void reverse(int[] arr, int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;

        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int size = arr.length;
        int k = 3;

        System.out.println("Array before moving it by " + k + " place is: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
//        approach_1(arr, size, k);
//        approach_2(arr, size, k);
        approach_3(arr, size, k);

        System.out.println("Array after moving it by " + k + " place is: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
