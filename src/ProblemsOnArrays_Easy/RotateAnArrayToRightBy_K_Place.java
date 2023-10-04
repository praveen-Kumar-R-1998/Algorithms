package ProblemsOnArrays_Easy;

public class RotateAnArrayToRightBy_K_Place {
    public static void approach_1(int[] arr, int size, int k) {

        if (size == 0 || k == arr.length) return;

        k = k % size;
        int[] temp = new int[k];
        int j = 0;
        for (int i = size - k; i < size; i++) {
            temp[j] = arr[i];
            j++;
        }
        for (int i = size - 1; i >= k; i--) {
            arr[i] = arr[i - k];
        }

        for (int i = 0; i < k; i++) {
            arr[i] = temp[i];
        }
    }

    public static void approach_2(int[] arr, int size, int k) {

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int size = arr.length;
        int arrayRotationValue = 3;

        System.out.println("Array before moving it by " + arrayRotationValue + " place is: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        approach_1(arr, size, arrayRotationValue);

        System.out.println("Array after moving it by " + arrayRotationValue + " place is: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
