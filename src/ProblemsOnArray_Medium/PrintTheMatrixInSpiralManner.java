package ProblemsOnArray_Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * input array
 *  1 2 3
 *  4 5 6
 *  7 8 9
 *  top=1 bottom=7 left=1 right=3
 *  output: 1,2,3,6,9,8,7,4,5
 *
 *  There is only one approach for this problem
 */
public class PrintTheMatrixInSpiralManner {

    public static List<Integer> printSpiral(int[][] matrix){
        //We will get the number of rows
        int n=matrix.length;
        // we will get the no of columns
        int m=matrix[0].length;

        List<Integer> ans = new ArrayList<>();

        int top=0, left=0, bottom=n-1, right=m-1;

        while(top<=bottom && left<=right){

            for (int i=left; i<=right; i++){
                ans.add(matrix[top][i]);

            }
            top++;
            for (int i=top;i<=bottom;i++){
                ans.add(matrix[i][right]);

            }
            right--;

            if(top<=bottom){
                for (int i=right; i>=left; i--){
                    ans.add(matrix[bottom][i]);

                }
                bottom--;
            }

            if(left<=right){
                for (int i=bottom; i>=top; i--){
                    ans.add(matrix[i][left]);

                }
                left++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        List<Integer> ans = printSpiral(matrix);

        System.out.println(ans);
    }
}
