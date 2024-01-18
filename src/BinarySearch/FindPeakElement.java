package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class FindPeakElement {

    public static int linearSearchApproach(ArrayList<Integer> arr){
        int size = arr.size();
        for (int i=0; i<size; i++){
            if((i==0 || arr.get(i-1)<arr.get(i)) && (i==size-1) || arr.get(i)>arr.get(i+1)){
                return i;
            }
        }
        return -1;
    }

    public static int binarySearchApproach(ArrayList<Integer> arr){
        int size = arr.size();
        if (size==1)return 0;
        if(arr.get(0)>arr.get(1))return 0;
        if (arr.get(size-1)>arr.get(size-2))return (size-1);

        int low=1,high=size-2;
        while (low<=high){
            int mid = (low+high)/2;

            if (arr.get(mid-1)<arr.get(mid) && (arr.get(mid)>arr.get(mid+1)))return mid;
            if(arr.get(mid)>arr.get(mid-1)){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr =
                new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 5, 1));
        int ans_1 = linearSearchApproach(arr);
        int ans_2 = binarySearchApproach(arr);
        System.out.println("Using linear search approach we found that the peak is at index: " + ans_1);
        System.out.println("Using binary search approach we found that the peak is at index: " + ans_2);

    }
}
