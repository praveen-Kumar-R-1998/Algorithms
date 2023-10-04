package ProblemsOnArrays_Easy;

/**
 * N will be given, and we have to find the missing number between 1 to N
 * the array will contain n-1 number
 * <p>
 * Input format: N=5, array[] = {1,2,4,5}
 * result: 3 is the missing number
 * <p>
 * input format: n=3 array[] = {1,3}
 * result: 2 is the missing number
 */
public class FindTheMissingNumberInTheArray {

    public static int approach_1(int[] arr, int N) {

        for (int i = 1; i <= N; i++) {
            int flag = 0;

            for (int j = 0; j < N - 1; j++) {
                if (arr[j] == i) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) return i;

        }
        return -1;
    }

    /**
     * Using hashing concept
     * @param arr
     * @param size
     * @return
     */
    public static int approach_2(int[] arr, int size) {
        int[] hash = new int[size + 1];

        for (int i = 0; i < size - 1; i++) {
            hash[arr[i]]++;
        }
        for (int i = 1; i <= size; i++) {
            if (hash[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Using summation approach
     * @param arr
     * @param N
     */
    public static int approach_3(int[] arr, int N){
        int sum1=0;
        int sum2=0;
        for(int i=0; i<=N; i++){
            sum1 = sum1 + i;
        }

        for(int i=0; i<arr.length; i++){
            sum2 = sum2+arr[i];
        }
        return sum1-sum2;
    }

    /**
     * Using XOR approach
     */
    public static void approach_4(){

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int n = 5;
        int result = approach_3(arr, n);
        System.out.println("The missing number is: " + result);
    }
}
