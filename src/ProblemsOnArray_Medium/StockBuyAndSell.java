package ProblemsOnArray_Medium;

/**
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future
 * to sell the stock. return the maximum profut you can achieve from this transaction.I you cannot achieve any profit return 0
 *
 * You cannot buy on day 2 and sell on day 1. You have to buy before you sell.
 */
public class StockBuyAndSell {

    /**
     * Linear search approach
     * @param arr
     * @param N
     * @return
     */

    public static int approach_1(int[] arr, int N){
        int profit =0;
        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                if(arr[j]>arr[i]){
                    profit = Math.max(profit,arr[j]-arr[i]);
                }
            }
        }
        return profit;
    }

    public static int approach_2(int[] arr, int N){
        int profit=0;
        int minPrice = Integer.MAX_VALUE;
        for (int i=0; i<N; i++){
            minPrice = Math.min(minPrice,arr[i]);
            profit = Math.max(profit, arr[i]-minPrice);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1,6};
        int size = arr.length;
        int result = approach_2(arr,size);
        System.out.println("Maximum profit that can be archived in this transaction is: "+result);
    }
}
