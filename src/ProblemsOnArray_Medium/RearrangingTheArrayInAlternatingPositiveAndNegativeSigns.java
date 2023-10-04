package ProblemsOnArray_Medium;
/**
 * input arr=[1,2,3,4,5,-5,-4,-3,-2,-1]
 * output arr = [1,-5,2,-4,3,-3,4,-2,5,-1]
 *
 * if there are still few values left then add them up in the end
 *
 * input arr = [1,2,3,4,5,6,7,-5,-4,-3,-2,-1]
 * output arr = [1,-5,2,-4,3,-3,4,-2,5,-1,6,7]
 */

import java.util.ArrayList;

public class RearrangingTheArrayInAlternatingPositiveAndNegativeSigns {

    public static int[] approach_1(int[] arr, int N){
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();

        for(int i=0; i<N; i++){
            if(arr[i]>0){
                positive.add(arr[i]);
            }else{
                negative.add(arr[i]);
            }
        }

        for(int i=0; i<N/2; i++){
            arr[2*i] = positive.get(i);
            arr[2*i+1] = negative.get(i);
        }
        return arr;
    }

    /**
     *
     * @param arr
     * @param N
     */
    public static int[] approach_2(int[] arr, int N){
        int[] ans = new int[N];
        int positive=0, negative=1;
        for(int i=0; i<N; i++){
           if(arr[i]>0){
               ans[positive]=arr[i];
               positive+=2;
           }else {
               ans[negative]=arr[i];
               negative+=2;
           }
        }
        return ans;
    }

    /**
     * If the array contains odd number of values i.e uneven odd and even numbers
     * @param arr
     * @param N
     */
    public static int[] approach_3(int[] arr, int N) {
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (arr[i] > 0) {
                positive.add(arr[i]);
            } else {
                negative.add(arr[i]);
            }
        }
        if (positive.size() > negative.size()) { //negative are limited in number
            for (int i = 0; i < negative.size(); i++) {
                arr[2 * i] = positive.get(i);
                arr[2 * i + 1] = negative.get(i);
            }
            int index = negative.size() * 2;
            for (int i = negative.size(); i < positive.size(); i++) {
                arr[index] = positive.get(i);
                index++;
            }
        } else {
            for (int i = 0; i < positive.size(); i++) {
                arr[2 * i] = positive.get(i);
                arr[2 * i + 1] = negative.get(i);
            }

            int index = positive.size() * 2;
            for (int i = positive.size(); i < negative.size(); i++) {
                arr[index] = negative.get(i);
                index++;
            }


        }
        return arr;
    }

        public static void main (String[]args){
            int[] arr = {5,4,3, 2, 1, -1, -2, -3,-14,-15,-16,-17,-18};
            int size = arr.length;
            int[] result = approach_3(arr, size);

            for (int i = 0; i < size; i++) {
                System.out.print(result[i] + "  ");
            }
            System.out.println();
        }
    }

