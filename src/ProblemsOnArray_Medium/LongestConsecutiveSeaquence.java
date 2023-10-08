package ProblemsOnArray_Medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSeaquence {

    public static boolean linearSearch(int[] arr, int num){
        int size = arr.length;
        for (int i=0; i<size; i++){
            if(arr[i]==num){
                return true;
            }
        }
        return false;
    }
    public static int approach_1(int[] arr){
        int size = arr.length;
        if(size==0) return 0;
        int longest = 1;

        for (int i=0; i<size; i++){
            int x = arr[i];
            int count = 1;

            while(linearSearch(arr, x+1)==true){
                x+=1;
                count+=1;
            }
            longest = Math.max(longest,count);
        }
        return longest;
    }

    public static int approach_2(int[] arr){
        int size = arr.length;
        if(size==0) return 0;

        Arrays.sort(arr);
        int lastSmaller = Integer.MIN_VALUE;
        int count = 0;
        int longest = 1;

        for (int i=0; i<size; i++){
            if(arr[i]-1==lastSmaller){
                count+=1;
                lastSmaller = arr[i];
            } else if (arr[i]!=lastSmaller) {
                count = 1;
                lastSmaller = arr[i];
            }
            longest = Math.max(longest,count);
        }
        return longest;
    }

    public static int approach_3(int[] arr){
        int size = arr.length;
        if(size==0) return 0;

        int longest = 1;
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<size; i++){
            set.add(arr[i]);
        }

        for(int it : set){
            if (!set.contains(it-1)){
                int count = 1;
                int x = it;
                while(set.contains(x+1)){
                    x=x+1;
                    count+=1;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }

    public static void main(String[] args) {

        int[] arr = {100,200,1,2,3,4,5};
        int ans_1 = approach_1(arr);
        System.out.println("approach_1 ----> Longest consecutive sequence is: "+ans_1);
        System.out.println("\n*****************************\n*****************************\n");
        int ans_2 = approach_2(arr);
        System.out.println("approach_2 ----> Longest consecutive sequence is: "+ans_2);
        System.out.println("\n*****************************\n*****************************\n");
        int ans_3 = approach_3(arr);
        System.out.println("approach_2 ----> Longest consecutive sequence is: "+ans_3);

    }
}
