package ProblemsOnArrays_Hard;

/**
 * Pascals triangle
 *          1
 *       1     1
 *     1    2     1         2-->Came up as the sum of the above two number
 *   1   3      3   1       3-->Came up as sum of 1+2 and 2+1
 * 1  4     6     4    1    4&6--> Came up as sum of 1+3 & 3+3
 */

import java.util.ArrayList;
import java.util.List;

/**
 * This problem has three variation.

 * Variation 1: Given row number r and column number c. print the element at position (r,c) in pascals triangle.

 * Variation 2: Given the row number n. Print the nth row of the pascal's triangle.

 * Variation 3: Given the number of rows n. Print the first n rows of the pascal's triangle.
 */
public class PascalsTriangle {
    public static long variation_1(int n, int r) {
        long res = 1;

        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }

    public static int pascalsTriangle_1(int r, int c) {
        int element = (int) variation_1(r - 1, c - 1);
        return element;
    }

    /*
    ********************************************************************************************************************************************
    ********************************************************************************************************************************************
    ********************************************************************************************************************************************
     */

    public static long variation_2(int n, int r){
        long res=1;
        for(int i=0; i<r; i++){
            res=res*(n-i);
            res=res/(i+1);
        }
        return res;
    }
    public static void pascalsTriangle_2(int n){
        for(int c=1; c<=n; c++){
            System.out.print(variation_2(n-1,c-1)+" ");
        }
        System.out.println();
    }
    /*
     ********************************************************************************************************************************************
     ********************************************************************************************************************************************
     ********************************************************************************************************************************************
     */

    public static int variation_3(int n, int r){

        long res=1;
        for (int i=0; i<r; i++){
            res = res*(n-i);
            res = res/(i+1);
        }
        return (int)res;
    }

    public static List<List<Integer>> pascals_triangle_3(int n){
        List<List<Integer>> ans = new ArrayList<>();
        for (int row = 1; row<=n; row++){
            List<Integer> tempList = new ArrayList<>();
            for (int col = 1; col<=row; col++){
                tempList.add(variation_3(row-1, col-1));
            }
            ans.add(tempList);
        }
        return ans;
    }

    /*
     ********************************************************************************************************************************************
     ********************************************************************************************************************************************
     ********************************************************************************************************************************************
     */
    public static List<Integer> optimalApproach(int row){
        long ans =1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1);
        for (int col =1; col<row; col++){
            ans = ans * (row-col);
            ans = ans/col;
            ansRow.add((int)ans);
        }
        return ansRow;
    }

    public static List<List<Integer>> pascalsTriangle_4(int n){
        List<List<Integer>> ans = new ArrayList<>();
        for (int row = 1; row<=n; row++){
            ans.add(optimalApproach(row));
        }
        return ans;
    }

    public static void main(String[] args) {
        int row = 5;
        int col = 3;
        int element = pascalsTriangle_1(row, col);
        System.out.println("Element at position (row,col) is: " + element);

        System.out.println("\n********************\n********************\n");
        int n=3;
        System.out.println("Element at "+n+" row of a pascal's triangle are: "); pascalsTriangle_2(n);

        System.out.println("\n********************\n********************\n");
        int n1=5;
        System.out.println("Element at "+n1+" row of a pascal's triangle are:");
        System.out.println(pascals_triangle_3(n1));

        System.out.println("\n********************\n********************\n");

        int n2=5;
        System.out.println("Element at "+n2+" row of a pascal's triangle are:");
        System.out.println(pascalsTriangle_4(n1));

    }
}
