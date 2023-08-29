package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * In this quick sort algorithm we are arranging the elements in ascending order
 *
 * Here first we pick a pivot which is usually the first element of the array and try to place it in its correct position and the remaining elements os the array will be placed
 * in such a way that elements smaller than the pivot will come on the left and the elements greater than the pivot will come on the right of pivot.(It can be vice verse)
 * and once the picked pivot is place in it correct position then we again call the same element (using recursion) but this time we will pass the array length from low-pivot-1
 * and pivot+1 to high since pivot is already in its correct place.
 */
public class _7_QuickSort {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr = Arrays.asList(new Integer[]{4,6,2,5,7,9,1,3});
        int n = arr.size();

        System.out.println("Array before sorting: ");
        for(int i=0; i<n; i++){
            System.out.print(arr.get(i)+" ");
        }
        System.out.println();

        quickSort(arr);

        System.out.println("Array after sorting: ");
        for(int i=0; i<n; i++){
            System.out.print(arr.get(i)+" ");
        }
        System.out.println();
    }

    public static List<Integer> quickSort(List<Integer> arr){
        sort(arr, 0, arr.size()-1);
        return arr;
    }

    public static void sort(List<Integer> arr, int low, int high){
        if(low<high){
            int pIndex = partition(arr,low,high);
            sort(arr,low, pIndex-1);
            sort(arr, pIndex+1, high);

        }
    }

    public static int partition(List<Integer> arr, int low, int high){

        int pivot = arr.get(low);
        int i = low;
        int j = high;

        while(i<j){
            while(arr.get(i)<=pivot && i<=high-1){
                i++;
            }
            while (arr.get(j)>pivot && j>=low+1){
                j--;
            }
            if(i<j){
                int temp = arr.get(i);
                arr.set(i,arr.get(j));
                arr.set(j,temp);
            }
        }
        int temp = arr.get(low);
        arr.set(low,arr.get(j));
        arr.set(j,temp);
        return j;
    }
}
