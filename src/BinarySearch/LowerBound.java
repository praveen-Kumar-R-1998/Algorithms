package BinarySearch;

public class LowerBound {
    public static int lowerBoundImplementationUsingLinearSearch(int[] arr,int size, int x){
        for(int i=0;i<size; i++){
            if(arr[i]>=x){
                return i;
            }
        }
        return size;
    }

    public static int lowerBoundImplementationUsingRecursion(int[] arr, int size, int x){
        int low=0,high=size-1;
        int ans=size;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]>=x){
                ans = mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {3,5,6,7,8,15,19};
        int size = arr.length;
        int target = 9;
        int result_1 = lowerBoundImplementationUsingLinearSearch(arr,size,target);
        if (result_1 != size) {
            System.out.println("The lower bound is at index: " + result_1);
        } else {
            System.out.println("The target is not present in the array");
        }
        int result_2 = lowerBoundImplementationUsingRecursion(arr,size,target);
        if (result_2 != size) {
            System.out.println("The lower bound is at index: " + result_2);
        } else {
            System.out.println("The target is not present in the array");
        }
    }
}
