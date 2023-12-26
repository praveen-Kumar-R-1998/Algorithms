package ProblemsOnArrays_Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityElement_nBy3_Times {

    /**
     * Brute Force approach
     * Here in answer we will get maximum of two element only that is why we are checking the condition ans.get(0)!=arr[i] so that the present
     * element in the ans is not equal to the current element
     *
     * @param arr
     * @return
     */
    public static List<Integer> approach_1(int[] arr) {

        int size = arr.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (ans.size() == 0 || ans.get(0) != arr[i]) {
                int count = 0;
                for (int j = 0; j < size; j++) {
                    if (arr[j] == arr[i]) {
                        count++;
                    }
                }
                if (count > (size / 3)) {
                    ans.add(arr[i]);
                }
                if (ans.size() == 2) break;
            }
        }
        return ans;
    }

    /**
     * Better Approach using HashMap data structure
     *
     * @param arr
     * @return
     */
    public static List<Integer> approach_2(int[] arr) {

        int size = arr.length;
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int mini = (int) (arr.length / 3) + 1;
        for (int i = 0; i < size; i++) {
            int value = map.getOrDefault(arr[i], 0);
            map.put(arr[i], value + 1);
            if (map.get(arr[i]) == mini) {
                ans.add(arr[i]);
            }
            if (ans.size() == 2) {
                break;
            }
        }
        return ans;
    }

    /**
     * Optimal approach
     * @param arr
     * @return
     */
    public static List<Integer> approach_3(int[] arr) {
        int size = arr.length;
        int count1 = 0, count2 = 0;
        int num1 = Integer.MIN_VALUE, num2 = Integer.MIN_VALUE;
// Applying th eExtended Boyer Moore's voting algorithm
        for (int i = 0; i < size; i++) {
            if (count1 == 0 && num2 != arr[i]) {
                count1 = 1;
                num1 = arr[i];
            } else if (count2 == 0 && num1 != arr[i]) {
                count2 = 1;
                num2 = arr[i];
            } else if (arr[i] == num1) {
                count1++;
            } else if (arr[i] == num2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        //Manually checking if the stored element in the variable num1 and num2 are majority element
        List<Integer> list = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] == num1) count1++;
            if (arr[i] == num2) count2++;
        }
        int mini = (int) (size / 3) + 1;
        if (count1 >= mini) list.add(num1);
        if (count2 >= mini) list.add(num2);

        return list;
    }

    public static void main(String[] args) {

        int[] arr = {11, 33, 33, 11, 11, 33, 4};
        List<Integer> ans_1 = approach_1(arr);
        System.out.println("Approach 1 answer is: " + ans_1);

        List<Integer> ans_2 = approach_2(arr);
        System.out.println("Approach 2 answer is: " + ans_2);

        List<Integer> ans_3 = approach_3(arr);
        System.out.println("Approach 3 answer is: " + ans_3);

    }
}
