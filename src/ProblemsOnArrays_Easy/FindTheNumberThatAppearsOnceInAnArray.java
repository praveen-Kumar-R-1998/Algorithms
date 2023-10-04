package ProblemsOnArrays_Easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a array of two consecutive numbers find the one number which appears only once
 */
public class FindTheNumberThatAppearsOnceInAnArray {

    /**
     * Using loops approach / Linear search approach
     *
     * @param arr
     * @return
     */
    public static int approach_1(int[] arr){

        int num = -1;
        for(int i=0; i<arr.length; i++){
            int count=0;
            num = arr[i];

            for(int j=0; j<arr.length; j++){
                if(arr[j]==num){
                    count ++;
                }
            }
            if(count==1){
                return num;
            }
        }
        return -1;
    }

    /**
     * using hashing function
     *  Approach
     *      1. Using array hashing(not applicable if array contains negative or very large number)
     *         In order to use array hashing first we need to find the maximum element in the array and assign the
     *         corresponding maxValue+1 value to the HashArray.
     * @param arr
     * @return
     */
    public static int approach_2(int[] arr){

        int max=arr[0];
        for(int i=0; i<arr.length; i++){
            max = Integer.max(max,arr[i]);
        }
        int[] hash = new int[max+1];

        for(int i=0; i< arr.length; i++){
            hash[arr[i]]++;
        }
        for(int i=0; i< arr.length; i++){
            if(hash[arr[i]]==1){
                return arr[i];
            }
        }
        return -1;
    }

    /**
     * Using Map data structure
     * @param arr
     * @return
     */
    public static int approach_3(int[] arr){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
           int value = map.getOrDefault(arr[i],0);
           map.put(arr[i],value+1);
        }

        for(Map.Entry<Integer,Integer> x : map.entrySet()){
            if(x.getValue() == 1){
                return x.getKey();
            }
        }
        return -1;
    }


    /**
     * Using XOR operator
     * @param arr
     * @return
     */
    public static int approach_4(int[] arr){
        int XOR=0;
        for (int i=0; i< arr.length; i++){
            XOR = XOR^arr[i];
        }
        return XOR;
    }

    /**
     * Using XOR approach
     * @param arr
     */

    public static void main(String[] args) {
        int[] arr = {1,5,4,1,5};
//        System.out.println("The number that appears once is: "+approach_1(arr));
//        System.out.println("The number that appears once is: "+approach_2(arr));
        System.out.println("The number that appears once is: "+approach_4(arr));
    }
}
