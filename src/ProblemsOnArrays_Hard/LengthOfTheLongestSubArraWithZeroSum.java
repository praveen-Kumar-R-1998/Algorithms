package ProblemsOnArrays_Hard;

import java.util.HashMap;
import java.util.Map;

public class LengthOfTheLongestSubArraWithZeroSum {

    /**
     * Brute force approach
     * @param arr
     * @param size
     * @return
     */
    public static int approach_1(int[] arr, int size){
        int max = 0;
        for (int i=0; i<size; i++){
            int sum=0;
            for (int j=i; j<size; j++){
                sum+=arr[j];
                if (sum==0){
                    max = Math.max(max,((j-i)+1));
                }
            }
        }
        return max;
    }

    /**
     * Optimal approach
     * @param arr
     * @param size
     * @return
     */
    public static int approach_2(int[] arr, int size){
        Map<Integer,Integer> map = new HashMap<>();
        int maxi=0;
        int sum=0;
        for (int i=0; i<size; i++){
            sum+=arr[i];
            if(sum==0){
                maxi = i+1;
            }else {
                if(map.get(sum)!=null){
                    maxi = Math.max(maxi,i-map.get(sum));
                }
                else{
                    map.put(sum,i);
                }
            }
        }
        return maxi;
    }
    public static void main(String[] args) {
        int[] arr = {9,-3,3,-1,6,-5};
        int size = arr.length;

        System.out.println("Approach_1 solution: "+approach_1(arr,size));
        System.out.println("Approach_2 solution: "+approach_2(arr,size));

    }
}
