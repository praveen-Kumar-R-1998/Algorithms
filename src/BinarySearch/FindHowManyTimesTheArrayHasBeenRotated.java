package BinarySearch;

public class FindHowManyTimesTheArrayHasBeenRotated {

    public static int linearSearchApproach(int[] arr){
        int min = Integer.MAX_VALUE, index=-1;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                index = i;
            }
        }
        return index;
    }

    public static int binarySearchApproach(int[] arr){
        int low=0, high=arr.length-1;
        int ans=Integer.MAX_VALUE;
        int index=-1;
        while (low<=high){
            int mid=(low+high)/2;

            if (arr[low]<=arr[high]){
                if (arr[low]<ans){
                    ans=arr[low];
                    index=low;
                }
                break;
            }
            if(arr[low]<=arr[mid]){
                if (arr[low]<ans){
                    ans=arr[low];
                    index=low;
                }
                low=mid+1;
            }else {
                if (arr[mid]<ans){
                    index=mid;
                    ans=arr[mid];
                }
                high=mid-1;
            }
        }
        return index;
    }


    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};
        int ans_1 = linearSearchApproach(arr);
        System.out.println("The given array is rotated: " + ans_1 );

        int ans_2 = binarySearchApproach(arr);
        System.out.println("The given array is rotated: " + ans_2 );
//
//        int ans_3 = binarySearchApproach_1(arr);
//        System.out.println("The minimum element is: " + ans_3 );
    }
}
