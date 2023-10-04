package ProblemsOnArray_Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * check if a pair with a given sum exist in the array
 */
public class _2_SumProblem {

    /**
     * Using linear search
     * @param arr
     * @param N
     * @param target
     * @return
     */
    public static String approach_1(int[] arr, int N, int target){
        for( int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                if(arr[i]+arr[j]==target) return "yes";
            }
        }
        return "No";
    }

    public static int[] approach_2(int[] arr, int N, int target){
        int[] ans = new int[2];
        ans[0]=ans[1]=-1;
        for (int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                if(arr[i]+arr[j]==target){
                    ans[0]=i;
                    ans[1]=j;
                    return ans;
                }
            }
        }
        return ans;
    }

    public static String approach_3(int[]arr, int N, int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<N; i++){
            int num = arr[i];
            int reminder = target - num;
            if(map.containsKey(reminder)){
                return "yes";
            }
            map.put(arr[i],i);
        }
        return "No";
    }

    public static int[] approach_4(int[] arr, int N, int target){
        Map<Integer,Integer> map = new HashMap<>();
        int[] ans = new int[2];
        ans[0] = ans[1] = -1;
        for(int i=0; i<N; i++){
            int num = arr[i];
            int reminder = target-num;
            if(map.containsKey(reminder)){
                ans[0]=map.get(reminder);
                ans[1]=i;
                return ans;
            }
            map.put(arr[i],i);
        }
        return ans;
    }

    public static String approach_5(int[] arr, int N, int target){
        Arrays.sort(arr);
        int left=0; int right = N-1;

        while(left<right){
            int sum = arr[left]+arr[right];
            if(sum==target){
                return "YES";
            } else if (sum<target) left++;
            else right--;
        }
        return "NO";
    }
    public static void main(String[] args) {
        int[] arr= {2,16,3,8,11};
        int N = arr.length;
        int target = 14;
        int[] result = approach_4(arr,N,target);

        System.out.println("Index of the target value is ["+result[0]+","+result[1]+"]" );
    }
}
