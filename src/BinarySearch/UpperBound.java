package BinarySearch;

public class UpperBound {

    public static int upperBoundImplementationUsingLinearSearch(int[] arr, int size, int target){
        for (int i=0; i<size; i++){
            if(arr[i]>target){
                return i;
            }
        }
        return size;
    }

    public static int upperBoundImplementationUsingRecursion(int[] arr, int size, int target){
        int low=0,high=size-1;
        int ans=size;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]>target){
                ans=mid;
                high=mid+1;
            }else {
                low=mid+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr={3,5,8,9,15,19};
        int size = arr.length;
        int target = 5;
        int result_1 = upperBoundImplementationUsingLinearSearch(arr,size,target);
        if (result_1 != size) {
            System.out.println("The lower bound is at index: " + result_1);
        } else {
            System.out.println("The target "+target+" is not present in the array");
        }
        int result_2 = upperBoundImplementationUsingLinearSearch(arr,size,target);
        if (result_2 != size) {
            System.out.println("The lower bound is at index: " + result_2);
        } else {
            System.out.println("The target "+target+" is not present in the array");
        }

    }
}
