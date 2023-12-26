package ProblemsOnArrays_Hard;

public class MaximumProductSubArrayInAnArray {

    /**
     * Brut force approach: using three loops
     */
    public static int approach_1(int[] arr, int size){
        int result = Integer.MIN_VALUE;
        for (int i=0; i<size-1; i++){
            for (int j=i+1; j<size; j++){
                int product=1;
                for (int k=i; k<=j; k++){
                    product*=arr[k];
                    result = Math.max(result,product);
                }
            }
        }
        return result;
    }

    public static int approach_2(int[] arr, int size){
        int result = arr[0];
        for (int i=0; i<size-1; i++){
            int product = arr[i];
            for (int j=i+1; j<size; j++){
                result = Math.max(result,product);
                product*=arr[j];
            }
            result=Math.max(result,product);
        }
        return result;
    }
    public static int approach_3(int[] arr, int size){
        int prefix=1,sufix=1;
        int ans = Integer.MIN_VALUE;
        for (int i=0;i<size; i++){
            if(prefix==0)prefix=1;
            if(sufix==0)sufix=1;
            prefix*=arr[i];
            sufix*=arr[size-i-1];
            ans = Math.max(ans,Math.max(prefix,sufix));
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,-3,0,-4,-5};
        int size = arr.length;
        int answer_1 = approach_1(arr,size);
        System.out.println("Answer_1: "+answer_1);

        System.out.println("******************************\n******************************");

        int answer_2 = approach_2(arr,size);
        System.out.println("Answer_2: "+answer_2);

        System.out.println("******************************\n******************************");

        int answer_3 = approach_3(arr,size);
        System.out.println("Answer_2: "+answer_3);
    }
}
