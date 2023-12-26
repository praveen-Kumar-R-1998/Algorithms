package ProblemsOnArrays_Hard;

import java.util.*;

/**
 * Given an array of N integers you task is to find unique triplet that adds up to give a sum of zero.
 * <p>
 * Example 1: Input array = [-1,0,1,2,-1,4]
 * output [-1,0,1] [-1,2,-1] these three values in the array constitute sum=0 condition.
 */
public class _3_SumProblem {
    /**
     * Brute force approach using for loops
     *
     * @param arr
     * @param size
     * @return
     */
    public static List<List<Integer>> approach_1(int[] arr, int size) {
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                for (int k = j + 1; k < size; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                        temp.sort(null); //Default ordering happens i.e ascending order so that the elements are sorted before adding it to set. or else duplication os elements happens
                        set.add(temp);
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }

    /**
     * Using hashing technique and reducing the loop from 3-->2
     *
     * arr[k] = -[arr[i]+arr[j]] and check whether arr[k] is present in set data structure or not
     *  Initially the set will be empty and as we iterate through the 2nd loop we will add the numbers to the set data structure
     *
     * @param arr
     * @param size
     * @return
     */
    public static List<List<Integer>> approach_2(int[] arr, int size){
        Set<List<Integer>> sets = new HashSet<>();
        for (int i = 0; i<size; i++){
            Set<Integer> hashSet = new HashSet<>(); // This set is used for Hashing the elements. and we are declaring it here because every
            // time we increment the value of i the hashing elements should change
            for (int j=i+1; j<size; j++){
                int thirdNumber = -(arr[i]+arr[j]);
                if(hashSet.contains(thirdNumber)){
                    List<Integer> temp = Arrays.asList(arr[i],arr[j],thirdNumber);
                    temp.sort(null);
                    sets.add(temp);
                }
                hashSet.add(arr[j]);
            }
        }
        List<List<Integer>> ans = new ArrayList<>(sets);
        return ans;
    }

    /**
     * Optimal approach where we eliminate the external data structure used in approach_2
     * Here we will first sort the array and use two pointer approach
     *
     * Here i will be the first element j will be element next to i and k will be the last element. The element i will be fixed, and we will find the
     * triplet by moving j and k forward or backward until they don't cross over each-other and if they do then we stop at that point.
     * @param arr
     * @param size
     */
    public static List<List<Integer>> approach_3(int[] arr, int size){
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        for (int i=0; i<size; i++){
            if(i!=0 && arr[i]==arr[i-1]) continue;
            int j=i+1;
            int k=size-1;
            while(j<k){
                int sum = arr[i]+arr[j]+arr[k];
                if(sum<0){
                    j++;
                } else if (sum>0) {
                    k--;
                }else {
                    List<Integer> temp = Arrays.asList(arr[i], arr[j],arr[k]);
                    ans.add(temp);
                    j++;
                    k--;
                    while(j<k && arr[j]==arr[j-1])j++;
                    while(j<k && arr[k]==arr[k+1])k--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, 4};
        int size = arr.length;
        List<List<Integer>> ans_1 = approach_1(arr, size);
        System.out.println("Approach_1 ---> "+ans_1);

        List<List<Integer>> ans_2 = approach_2(arr, size);
        System.out.println("Approach_2 ---> "+ans_2);

        List<List<Integer>> ans_3 = approach_3(arr, size);
        System.out.println("Approach_3 ---> "+ans_3);
    }
}
