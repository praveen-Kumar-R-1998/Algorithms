package ProblemsOnArrays_Easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Here both positive and negative values can be present
 */
public class LongestSubArrayWithSum_K {

    public static int approach_1(int[] arr, int N, int value) {
        int longest = 0;
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = i; j < N; j++) {
                sum += arr[j];
                if (sum == value) {
                    longest = Math.max(longest, j - i + 1);
                }
            }
        }
        return longest;
    }

    /**
     * Using Hashing technique using a map
     * Here we are looking for any sub array with sum=Value
     * @param arr
     * @param N
     * @param value
     * @return
     */
    public static int approach_2(int[] arr, int N, int value){
        Map<Integer,Integer> sumMap = new HashMap<>();
        int sum=0;
        int longestValue=0;
        for (int i=0; i<N; i++){
            sum+=arr[i];
            if(sum==value){
                longestValue = Math.max(longestValue, i+1);
            }
            int reminder = sum-value;

            if(sumMap.containsKey(reminder)){
                int length = i-sumMap.get(reminder);
                longestValue = Math.max(longestValue,length);
            }

            if(!sumMap.containsKey(reminder)){
                sumMap.put(sum,i);
            }
        }
        return longestValue;
    }

    public static void main(String[] args) {
//        int[] arr = {0,1,4,2,1,1,3};
        int[] arr = {1,2,3,1,1,1,1,4,2,3};
        int size = arr.length;
        int value = 3;
        System.out.println(approach_2(arr,size,value));
    }
}
