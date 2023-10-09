package ProblemsOnArray_Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Example 1
 * array = {3,1,2,4}  sum = 6
 * ans = 2  {3,1,2} and {2,4}
 * <p>
 * Example 2
 * array = {1,2,3}  k = 3
 * ans = 2  {1,2}  and {3}
 */
public class CountSubArrayWithGivenSum {

    public static int approach_1(int[] arr, int result) {
        int size = arr.length;
        int count = 0;

        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                if (sum == result) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int approach_2(int[] arr, int k){
        int size = arr.length;
        int count = 0;
        for (int i=0; i<size; i++){
            int sum=0;
            for (int j=i; j<size; j++){
                sum+=arr[j];
                if(sum==k){
                    count++;
                }
            }
        }
        return count;
    }
    public static int approach_3(int[] arr, int k){
        int size = arr.length;
        Map<Integer,Integer> map = new HashMap<>();
        int preSum=0, count=0;
        map.put(0,1);
        for (int i=0; i<size; i++){
            preSum+=arr[i];
            int remove = preSum-k;
            count+=map.getOrDefault(remove,0);
            map.put(preSum,map.getOrDefault(preSum,0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        int result = 6;
        int count_1 = approach_1(arr, result);
        System.out.println("Number of sub-array with sum " + result + " is " + count_1);
        System.out.println("\n*************************\n*************************\n");
        int count_2 = approach_2(arr, result);
        System.out.println("Number of sub-array with sum " + result + " is " + count_2);
        System.out.println("\n*************************\n*************************\n");
        int count_3 = approach_3(arr, result);
        System.out.println("Number of sub-array with sum " + result + " is " + count_3);

    }
}
