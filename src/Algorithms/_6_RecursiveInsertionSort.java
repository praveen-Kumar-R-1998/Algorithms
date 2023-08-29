package Algorithms;

public class _6_RecursiveInsertionSort {
    public static void sort(int[] arr, int i, int size) {
        if (i == size) return;
        int j = i;

        while (j > 0 && arr[j - 1] > arr[j]) {
            int temp = arr[j];
            arr[j] = arr[j - 1];
            arr[j - 1] = temp;
            j--;
        }
        sort(arr, i + 1, size);
    }

    public static void main(String[] args) {
        int arr[] = {6, 5, 4, 3, 2, 1};
        int size = arr.length;


        System.out.println("Array before sorting: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        sort(arr, 0, size);

        System.out.println("Array before sorting: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
