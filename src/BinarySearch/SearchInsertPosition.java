package BinarySearch;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * This sum is a replica of lower bound problem
 */
public class SearchInsertPosition {
    /**
     * Recursive approach
     * @param arr
     * @param size
     * @param target
     * @return
     */
    public static int insertPosition(int[] arr, int size, int target){
        int low=0,high=size-1;
        int ans=size;

        while (low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>=target){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {3,5,8,9,15,19};
        int size = arr.length;
        int target = 10;
        int result = insertPosition(arr,size,target);
        System.out.println(result);
    }
}
