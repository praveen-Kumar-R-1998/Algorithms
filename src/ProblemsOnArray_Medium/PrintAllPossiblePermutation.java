package ProblemsOnArray_Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Find the next lexicographically greater permutation
 * <p>
 * Examples
 * input : arr={1,2,3}
 * possible combination:
 * 1,3,2
 * 2,1,3
 * 2,3,1
 * 3,1,2
 * 3,2,1
 * <p>
 * output will be 3,2,1
 */
public class PrintAllPossiblePermutation {

    /**
     * Using recursion
     *
     * @param arr  -->It will contain the arrays for which all the permutation needs to be found out
     * @param ds   --> Used to store the list of numbers at each iteration
     * @param ans  --> Used to store all the permutation
     * @param freq -->Used to find out whether a number has been taken or not so that we can proceed to use them
     */
    public static void approach_1(int[] arr, List<Integer> ds, List<List<Integer>> ans, boolean[] freq) {
        if (ds.size() == arr.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!freq[i]) {
                freq[i] = true;
                ds.add(arr[i]);
                approach_1(arr, ds, ans, freq);
                ds.remove(ds.size() - 1);
                freq[i] = false;
            }
        }
    }

    public static List<List<Integer>> permute_1(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean freq[] = new boolean[arr.length];
        approach_1(arr, ds, ans, freq);
        return ans;
    }
//*****************************************************************************************************************************************************************************
//*****************************************************************************************************************************************************************************
//*****************************************************************************************************************************************************************************

    /**
     * Here we won't be using any extra data structure to find all the permutation combination instead we will use swapping approach
    */
    public static void approach_2(int index, int[] arr, List<List<Integer>> ans) {
        if(index == arr.length){
            List<Integer> ds = new ArrayList<>();
            for(int i=0; i<arr.length; i++){
                ds.add(arr[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=index; i<arr.length; i++){
            swap(i, index, arr);
            approach_2(index+1,arr,ans);
            swap(i,index,arr);
        }
    }

    private static void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static List<List<Integer>> permute_2(int[] arr){
        List<List<Integer>> ans = new ArrayList<>();
        approach_2(0, arr,ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> ans_1 = permute_1(arr);
        List<List<Integer>> ans_2 = permute_2(arr);
        System.out.println(ans_1);
        System.out.println(ans_2);

    }
}
