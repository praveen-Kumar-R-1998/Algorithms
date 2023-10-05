package ProblemsOnArray_Medium;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * input arr = {1,2,3,4,5}
 * output arr = {1,2,3,5,4}
 *
 * To find the immediate next biggest number to follow the series we will start from the second last number and try to replace it with last to find
 * whether we will get the number combination greater than the current number
 */
public class NextPermutation {

    public static List<Integer> nextGreaterPermutation(List<Integer> num) {
        int size = num.size();

        /**
         * The for loop used is to find the breakpoint i.e a value from the back which is smaller than the value in front of it
         * Example: Here we compare n-2 with n-1 and if n-2 value is smaller than n-1 we consider n-2 as the breakpoint
         * {2,1,5,4,3,0,0} size = 7
         */
        int index = -1;
        for (int i = size - 2; i >= 0; i--) {
            if (num.get(i) < num.get(i + 1)) {
                index = i;
                break;
            }
        }

/**
 * If the break point doesn't exist which means the given combination is the maximum and there is no possible next greatest combination value in
 * this case we will print the smallest combination of these number by simply reversing them.
 */
        if (index == -1) {
            Collections.reverse(num);
            return num;
        }
/**
 * To find the next greater element which is just greater than the index value and swap those two values
 */
        for (int i = size - 1; i > index; i--) {
            if (num.get(i) > num.get(index)) {
                int temp = num.get(i);
                num.set(i, num.get(index));
                num.set(index, temp);
                break;
            }
        }
        /**
         * The sublist is backed by the original list so any manipulation made in the sublist will affect the original list and vice versa
         * however the sublist is still a separate list,so we can manipulate it independently.
         */
        List<Integer> subList = num.subList(index + 1, size);
        Collections.reverse(subList);
        return num;
    }

    public static void main(String[] args) {
        List<Integer> num = Arrays.asList(new Integer[]{2,1,5,4,3,0,0});
        List<Integer> ans = nextGreaterPermutation(num);
        System.out.print("The next permutation is: [");
        for(int i=0; i< ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
        System.out.print("]");
    }
}
