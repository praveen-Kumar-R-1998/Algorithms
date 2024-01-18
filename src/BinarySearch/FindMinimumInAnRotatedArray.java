package BinarySearch;

public class FindMinimumInAnRotatedArray {

    public static int linearSearchApproach(int[] arr){

        int minimun = Integer.MAX_VALUE;
        for (int i=0; i<arr.length; i++){
            minimun=Math.min(minimun,arr[i]);
        }
        return minimun;
    }

    public static int binarySearchApproach_1(int[] arr){
        int low=0, high=arr.length-1;
        int ans=Integer.MAX_VALUE;
        while (low<=high){
            int mid=(low+high)/2;

            if(arr[low]<=arr[high]){
                ans=Math.min(ans,arr[low]);
            }

            if(arr[low]<=arr[mid]){
                ans=Math.min(arr[low],ans);
                low=mid+1;
            }else {
                ans=Math.min(arr[mid],ans);
                high=mid-1;
            }
        }
        return ans;
    }


        public static int binarySearchApproach_2(int[] arr){
        int low=0, high=arr.length-1;
        int ans=Integer.MAX_VALUE;
        while (low<=high){
            int mid=(low+high)/2;

            if(arr[low]<=arr[mid]){
                ans=Math.min(arr[low],ans);
                low=mid+1;
            }else {
                ans=Math.min(arr[mid],ans);
                high=mid-1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};
        int ans_1 = linearSearchApproach(arr);
        System.out.println("The minimum element is: " + ans_1 );

        int ans_2 = binarySearchApproach_2(arr);
        System.out.println("The minimum element is: " + ans_2 );

        int ans_3 = binarySearchApproach_1(arr);
        System.out.println("The minimum element is: " + ans_3 );
    }
}
