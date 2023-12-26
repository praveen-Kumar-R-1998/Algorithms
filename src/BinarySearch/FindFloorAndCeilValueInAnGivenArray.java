package BinarySearch;

public class FindFloorAndCeilValueInAnGivenArray {

    public static int floorValue(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ans = arr.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= target) {
                ans = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static int ceilValue(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ans = arr.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= target) {
                ans = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        int target = 11;
        int result_1 = floorValue(arr, target);
        int result_2 = ceilValue(arr, target);
        System.out.println("Floor value of the given target " + target + " is: " + result_1);
        System.out.println("Ceil value of the given target " + target + " is: " + result_2);
    }
}
