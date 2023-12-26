package ProblemsOnArrays_Hard;

import java.util.*;

/**
 * Give an array of N integer , your task is to find unique quads that add up to give a target value. in short, you need to return an array of all
 * unique quadruplets such that their sum is equal to the given target
 *
 * Example 1: arr=[1,0,-1,0,-2,2]  target=0
 * answer: [-2,2,-1,1], [-2,0,0,2] [1,0,0,-1]
 */
public class _4_SumProblem {

    /**
     * Brute force approach Using 4 loops
     * @param arr
     * @param size
     * @param target
     * @return
     */
    public static List<List<Integer>> approach_1(int[] arr, int size, int target){
        Set<List<Integer>> set = new HashSet<>();
        for (int i=0; i<size; i++){
            for (int j=i+1; j<size; j++){
                for (int k = j+1; k<size; k++){
                    for(int l=k+1; l<size; l++){
                        long sum = arr[i]+arr[j];
                        sum+=arr[k];
                        sum+=arr[l];

                        if(sum == target){
                            List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k], arr[l]);
                            Collections.sort(temp);
                            set.add(temp);
                        }
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }

    /**
     * Better approach: Here we eliminate the fourth loop
     * @param arr
     * @param size
     * @param target
     * @return
     */
    public static List<List<Integer>> approach_2(int[] arr, int size, int target){
        Set<List<Integer>> set = new HashSet<>();
        for (int i=0; i<size; i++){
            for (int j=i+1; j<size; j++){
                Set<Long> hashSet = new HashSet<>();
                for (int k=j+1; k<size; k++){
                    long sum = arr[i]+arr[j];
                    sum+=arr[k];
                    long fourthNumber = target-sum;
                    if (hashSet.contains(fourthNumber)){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[k]);
                        temp.add((int) fourthNumber);
                        Collections.sort(temp);
                        set.add(temp);
                    }
                    hashSet.add((long) arr[k]);
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }

    public static List<List<Integer>> approach_3(int[] arr, int size, int target){
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        for (int i=0; i<size; i++){
            if(i!=0 && arr[i]==arr[i-1])continue;
            for (int j=i+1; j<size; j++){
                if (j>i+1 && arr[j]==arr[j-1])continue;

                int k=j+1;
                int l=size-1;
                while (k<l){
                    long sum = arr[i]+arr[j]+arr[k]+arr[l];
                    if(sum==target){
                        List<Integer>temp = Arrays.asList(arr[i],arr[j],arr[k],arr[l]);
                        ans.add(temp);
                        k++;
                        l--;

                        while (k<l && arr[k]==arr[k-1])k++;
                        while (k<l && arr[l]==arr[l+1])l--;

                    } else if (sum<target)k++;
                    else l--;
                }
            }

        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {4,3,3,4,4,2,1,2,1,1};
        int size = arr.length;
        int target = 9;
        List<List<Integer>> ans_1 = approach_1(arr, size,target);
        System.out.println("Approach 1 solution: "+ans_1);

        List<List<Integer>> ans_2 = approach_2(arr, size,target);
        System.out.println("Approach 2 solution: "+ans_2);

        List<List<Integer>> ans_3 = approach_3(arr, size,target);
        System.out.println("Approach 3 solution: "+ans_3);
    }
}
