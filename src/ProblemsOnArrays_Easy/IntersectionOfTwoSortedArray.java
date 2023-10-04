package ProblemsOnArrays_Easy;

import java.util.ArrayList;

/**
 * Here we check if an element is present in both the array and here duplicate are allowed if they are present in both
 * two times each
 * Input array 1 = [1,2,2,3,3,4,5,6]
 * Input array 2 = [2,3,3,4,5,5,6,7]
 *
 * Output array = [2,3,3,4,5,6]
 */
public class IntersectionOfTwoSortedArray {

    public static ArrayList<Integer> approach_1(int[] arr1, int[] arr2){
        int[] visited = new int[arr2.length];
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0; i<arr1.length; i++){
            for(int j=0; j<arr2.length; j++){
                if(arr1[i]==arr2[j] && visited[j]==0){
                    result.add(arr2[j]);
                    visited[j]=1;
                    break;
                }
                if(arr2[j]>arr1[i]) break;
            }

        }
        return result;
    }

    public static ArrayList<Integer> approach_2(int[] arr1, int[] arr2){
        int i=0, j=0;
        ArrayList<Integer> result = new ArrayList<>();

        while(i<arr1.length && j<arr2.length){
            if(arr1[i]<arr2[j]){
                i++;
            }else if (arr2[j]<arr1[i]){
                j++;
            }else{
                result.add(arr1[i]);
                i++;
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,6,9,10,11,14,16};
        int[] arr2 = {2,3,4,5,6,7,8,14,16};
        ArrayList<Integer> result = approach_1(arr1,arr2);
        System.out.println(result);
        System.out.println("\n***********************\n***********************\n");
        ArrayList<Integer> result1 = approach_1(arr1,arr2);
        System.out.println(result1);
    }
}
