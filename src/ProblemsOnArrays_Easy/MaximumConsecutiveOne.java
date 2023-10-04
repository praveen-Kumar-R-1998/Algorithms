package ProblemsOnArrays_Easy;

/**
 * Given an array of 1's and 0's give me the count of maximum number of consecutive zero
 */
public class MaximumConsecutiveOne {

   public static int approach_1(int[] arr){
       int max = 0;
       int count = 0;
        for (int i=0; i<arr.length; i++){
            if(arr[i]==1){
                count++;
                max = Integer.max(max,count);
            }else{
                count=0;
            }
        }

       return max;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,1,0,1,0,1,1,1};
        System.out.println("Maximum number of consecutive 1's is: "+approach_1(arr));
    }
}
