package BinarySearch;

public class BinarySearch {
    /**
     *
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearchImplementationUsingLinearApproach(int[] arr, int target){
        int size = arr.length;
        int low=0,high=size-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]==target) return mid;
            else if (target>arr[mid]) {
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }

    public static int binarySearchImplementationUsingRecurssiveMethod(int[] arr, int low, int high, int target){
        if(low>high) return -1;
        int mid = (low+high)/2;
        if(arr[mid]==target) return mid;
        else if (target>arr[mid]) {
            return binarySearchImplementationUsingRecurssiveMethod(arr,mid+1,high,target);
        }else {
            return binarySearchImplementationUsingRecurssiveMethod(arr,0,mid-1,target);
        }

    }

    public static void main(String[] args) {
        int[] arr = {3,4,6,7,8,9,12,16,17};
        int target = 12;
        int result_1 = binarySearchImplementationUsingLinearApproach(arr,target);
        if(result_1==-1){
            System.out.println("The target "+target+" is not present in the given array");
        }else{
            System.out.println("The target is at index: "+result_1);
        }

        int result_2 = binarySearchImplementationUsingRecurssiveMethod(arr,0,arr.length,target);
        if(result_1==-1){
            System.out.println("The target "+target+" is not present in the given array");
        }else{
            System.out.println("The target is at index: "+result_2);
        }


    }
}
