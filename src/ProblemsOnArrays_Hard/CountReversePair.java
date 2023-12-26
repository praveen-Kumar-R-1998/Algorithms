package ProblemsOnArrays_Hard;

import java.util.ArrayList;

/**
 * input arr[] = {3,2,1,4}
 * output ans: 1 --> arr[] = {3,1}
 */
public class CountReversePair {

    /**
     * Brut force approach
     * @param arr
     * @param size
     * @return
     */
    public static int approach_1(int[] arr, int size){
        int count=0;
        for (int i=0; i<size; i++){
            for (int j=i+1; j<size; j++){
                if(arr[i]>(2*(arr[j]))) count++;
            }
        }
        return count;
    }

    public static void merge(int[] arr, int low, int mid, int high){
        ArrayList<Integer> temp = new ArrayList<>();
        int left=low;
        int right=mid+1;
        while(left<=mid && right<=high){
            if (arr[left]<=arr[right]){
                temp.add(arr[left]);
                left++;
            }else{
                temp.add(arr[right]);
                right++;
            }
        }

        while (left<=mid){
            temp.add(arr[left]);
            left++;
        }

        while (right<=high){
            temp.add(arr[right]);
            right++;
        }

        for (int i=low; i<=high; i++){
            arr[i] = temp.get(i-low);
        }
    }

    public static int countPairs(int[] arr, int low, int mid, int high){
        int right = mid+1;
        int count = 0;
        for (int i=low; i<=mid; i++){
            while(right<=high && arr[i]>2*arr[right])right++;
            count+=(right-(mid+1));
        }
        return count;
    }
    public static int mergeSort(int[] arr, int low, int high){
        int count = 0;
        if(low>=high) return count;
        int mid = (low+high)/2;
        count+=mergeSort(arr,low,mid);
        count+=mergeSort(arr,mid+1,high);
        count+=countPairs(arr,low,mid,high);
        merge(arr,low,mid,high);
        return count;
    }
    public static int approach_2(int[] arr, int size){
        return mergeSort(arr,0,size-1);
    }

    public static void main(String[] args) {
        int arr_1[] = {4,1,2,3,1};
        int size_1 = arr_1.length;
        System.out.println(approach_1(arr_1,size_1));
        System.out.println("******************************\n******************************");
        int arr[] = {4,1,2,3,1};
        int size = arr.length;
        System.out.println(approach_2(arr,size));
    }
}
