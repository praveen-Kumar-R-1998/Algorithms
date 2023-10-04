package ProblemsOnArrays_Easy;

public class CheckIfTheGivenArrayIsSorted {
    public static boolean approach_1_arrayStatus(int[] arr, int size) {
        if (size == 1) return true;

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j <=size - 1; j++) {
                if (arr[i] > arr[j]) {
                    return false;
                }
            }
        }
        return true;
    }
    

    public static void main(String[] args) {
        int[] arr = {11, 12, 14,};
        int size = arr.length;
        System.out.println("Is the given array sorted? "+approach_1_arrayStatus(arr, size));
    }

}
