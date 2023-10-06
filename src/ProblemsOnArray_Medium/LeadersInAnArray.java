package ProblemsOnArray_Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeadersInAnArray {

    public static List<Integer> approach_1(int[] arr, int size){

        ArrayList<Integer> leaderArray = new ArrayList<>();
        for (int i=0; i<size; i++){
            boolean leader = true;

            for (int j=i+1; j<size; j++){
                if(arr[j]>arr[i]){
                    leader=false;
                    break;
                }
            }
            if(leader){
                leaderArray.add(arr[i]);
            }
        }
        return leaderArray;

    }

    public static List<Integer> approach_2(int[] arr, int size){
        int maxi = Integer.MIN_VALUE;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=size-1; i>=0; i--){
            if(arr[i]>maxi){
                ans.add(arr[i]);
                maxi = arr[i];
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {10,22,12,3,0,6};
        int size = arr.length;

        ArrayList<Integer> ans_1 = (ArrayList<Integer>) approach_1(arr,size);
        System.out.println(ans_1);

        ArrayList<Integer> ans_2 = (ArrayList<Integer>) approach_2(arr,size);
        Collections.sort(ans_2,Collections.reverseOrder());
//        Collections.reverse(ans_2);
        System.out.println(ans_2);

    }
}
