package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class FirstAndLastOccuranceIndex {
    /**
     * Linear Search Approach
     */
    public static int[] linearSearchApproach(ArrayList<Integer> arr, int size, int target) {
        int first = -1, last = -1;
        for (int i = 0; i < size; i++) {
            if (arr.get(i) == target) {
                if (first == -1) {
                    first = i;
                }
                last = i;
            }
        }
        return new int[]{first, last};
    }

    class lowerBoundAndUpperBoundApproach{
        public static int lowerBound(ArrayList<Integer> arr, int size, int target){
            int low=0,high=size-1;
            int ans=size;
            while(low<=high){
                int mid=(low+high)/2;
                if(arr.get(mid)>=target){
                    ans=mid;
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }
            return ans;
        }

        public static int upperBound(ArrayList<Integer> arr, int size, int target){
            int low=0, high=size-1;
            int ans=size;
            while(low<=high){
                int mid=(low+high)/2;
                if(arr.get(mid)>target){
                    ans=mid;
                    high=mid-1;
                }else {
                    low=mid+1;
                }
            }
            return ans;
        }
        public static int[] firstAndLastOcuranceInAnArray(ArrayList<Integer> arr, int size, int target){
            int lowerBound = lowerBoundAndUpperBoundApproach.lowerBound(arr,size,target);
            if(lowerBound==size || (arr.get(lowerBound))!=target) return new int[]{-1,-1};

            int upperBound = lowerBoundAndUpperBoundApproach.upperBound(arr,size,target);
            return new int[]{lowerBound,upperBound-1};
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(new Integer[]{2, 4, 6, 8, 8, 8, 11, 13}));
        int size = arr.size();
        int target = 11;
        int[] ans_1 = linearSearchApproach(arr, size, target);
        System.out.println("The first and the last occurrence of number " + target + " is at index " + ans_1[0] + " and " + ans_1[1]);
        int [] ans_2 = lowerBoundAndUpperBoundApproach.firstAndLastOcuranceInAnArray(arr,size,target);
        System.out.println("The first and the last occurrence of number " + target + " is at index " + ans_2[0] + " and " + ans_2[1]);
    }
}
