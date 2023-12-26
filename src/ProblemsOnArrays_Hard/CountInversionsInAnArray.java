package ProblemsOnArrays_Hard;

import java.util.ArrayList;

/**
 * input array arr[] = {5,3,2,4,1}
 * output:count = 8 --> (5,3)(5,2)(5,4)(5,1)(3,2)(3,1)(2,1)(4,1)
 */
public class CountInversionsInAnArray {
    /**
     * Brut force approach using two for loops
     */
    public static int approach_1(int[] arr, int size){
        int count=0;
        for (int i=0; i<size; i++){
            for (int j=i+1; j<size; j++){
                if (arr[i]>arr[j]) count++;
            }
        }
        return count;
    }

    /**
     * Using merge sort approach
     * @return
     */
    public static int approach_2(int[] arr, int size){
         return mergeSort(arr,0,size-1);
    }

    public static int mergeSort(int[] arr, int low, int high){
        int count=0;
        if(low>=high) return count;
        int mid = (low+high)/2;
        count+=mergeSort(arr,low,mid);
        count+=mergeSort(arr,mid+1,high);
        count+=merge(arr,low,mid,high);
        return count;
    }

    public static int merge(int[] arr, int low, int mid, int high){
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;  //Starting index of left half of array
        int right= mid+1;   //Starting index of right half of array
//        Modification 1: count variable to count the pairs
        int count = 0;

//        Sorting element in temporary array in a sorted manner

        while(left<=mid && right<=high){
            if(arr[left]<=arr[right]){
                temp.add(arr[left]);
                left++;
            }else{
                temp.add(arr[right]);
                count+=(mid - left+1);
                right++;
            }
        }
        while(left<=mid){
            temp.add(arr[left]);
            left++;
        }
        while(right<=high){
            temp.add(arr[right]);
            right++;
        }
        for (int i=low; i<=high; i++){
            arr[i]=temp.get(i-low);
        }
        return count;
    }

    public static void main(String[] args) {
//        int[] arr = {5,4,3,2,1};
//        int size = arr.length;
//        int count_1 = approach_1(arr,size);
//        System.out.println("The number of inversion using approach_1 is: "+count_1);
        System.out.println("******************************\n******************************");
        int[] arr = {5,4,3,2,1};
        int size = arr.length;
        int count_2 = approach_2(arr,size);
        System.out.println("The number of inversion using approach_1 is: "+count_2);
    }
}
