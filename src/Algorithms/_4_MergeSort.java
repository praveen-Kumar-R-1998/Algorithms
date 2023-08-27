package Algorithms;

import java.util.ArrayList;

/**
 * IT'S DIVIDE AND CONQUER ALGORITHM, IT DIVIDES A ARRAY INTO TWO EQUAL PART AND THEN MERGES THE TWO SORTED ARRAY PARTS
 * THERE ARE TWO FUNCTION HAPPENING 1. MERGE 2. MERGESORT
 */


public class _4_MergeSort {
    public static void sort(int[] arr, int low, int high){
        if(low>=high) return;
        int mid = (low+high)/2;
        _4_MergeSort.sort(arr, low, mid);
        _4_MergeSort.sort(arr, mid+1, high);
        _4_MergeSort.merge(arr,low,mid,high);
    }

    public static void merge(int[] arr, int low, int mid, int high){
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int left = low;
        int right = mid+1;

        while(left<=mid && right<=high){
            if(arr[left]<=arr[right]){
                temp.add(arr[left]);
                left++;
            }else {
                temp.add(arr[right]);
                right++;
            }
        }
        /**
         * if elements on left side are still pending
         */
        while (left<=mid){
            temp.add(arr[left]);
            left++;
        }

        /**
         * if elements on right half are still pending
         */
        while(right<-high){
            temp.add(arr[right]);
            right++;
        }

        /**
         * Transferring all the element from temporary array to main array
         */

        for(int i=low; i<=high; i++){
            arr[i] = temp.get(i-low);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        int size = arr.length;

        System.out.println("Array before sorting: ");
        for(int i=0; i<size; i++){
            System.out.print(arr[i]+" ");
        }

        sort(arr,0,size-1);
        System.out.println();

        System.out.println("Array after sorting: ");
        for(int i=0; i<size; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
