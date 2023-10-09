package ProblemsOnArray_Medium;

import java.util.ArrayList;
import java.util.Arrays;

public class SetMatrixZeros {

    public static void markRow(ArrayList<ArrayList<Integer>> matrix, int n, int m, int i) {
        for (int j = 0; j < m; j++) {
            if (matrix.get(i).get(j) != 0) {
                matrix.get(i).set(j, -1);
            }
        }
    }

    public static void markColumn(ArrayList<ArrayList<Integer>> matrix, int n, int m, int j) {
        for (int i = 0; i < n; i++) {
            if (matrix.get(i).get(j) != 0) {
                matrix.get(i).set(j, -1);
            }
        }
    }

    /**
     * Here we follow a linear search approach where we first iterate over the matrix and mark all columns and rows that contain 0 as -1
     * and then in the end make all -1 as 0
     *
     * @param matrix
     * @param n
     * @param m
     * @return
     */
    public static ArrayList<ArrayList<Integer>> zeroMatrix_approach_1(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
//        set -1 for rows and columns that contains 0
//        Don't mark any 0 as -1

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == 0) {
                    markRow(matrix, n, m, i);
                    markColumn(matrix, n, m, j);
                }
            }
        }
//        Finally mark all -1 as 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == -1) {
                    matrix.get(i).set(j, 0);
                }
            }
        }
        return matrix;
    }

//    ****************************************************************************************************************************************
//    ****************************************************************************************************************************************
//    ****************************************************************************************************************************************

    /**
     * Here we will have two marking arrays which will be initially initialized to zero and as we iterate over the array, If we find any zero
     * value then the corresponding marking array value will be set to 1 and in the end the rows and columns for which the marking array value
     * is set to 1 will be made 0
     *
     * @param matrix
     * @param n
     * @param m
     * @return
     */
    public static ArrayList<ArrayList<Integer>> zeroMatrix_approach_2(ArrayList<ArrayList<Integer>> matrix, int n, int m) {

        int[] row = new int[n];
        int[] col = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] == 1 || row[j] == 1) {
                    matrix.get(i).set(j, 0);
                }
            }
        }
        return matrix;
    }

    public static ArrayList<ArrayList<Integer>> zeroMatrix_approach_3(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        int col_0 = 1;
//  step_1: traverse the matrix
//  mark first row and column accordingly
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (matrix.get(i).get(j) == 0) {
//                    mark i-th row
                    matrix.get(i).set(0, 0);

//                    mark j-th row
                    if (j != 0) {
                        matrix.get(0).set(j, 0);
                    } else {
                        col_0 = 0;
                    }
                }
            }
        }
            for (int i=1;i<n; i++){
                for (int j=1; j<m; j++){
                    if (matrix.get(i).get(j)!=0){
                        if(matrix.get(i).get(0)==0 || matrix.get(0).get(j)==0){
                            matrix.get(i).set(j,0);
                        }
                    }
                }
            }

            if(matrix.get(0).get(0)==0){
                for (int j=0; j<m; j++){
                    matrix.get(0).set(j,0);
                }
            }
            if(col_0==0){
                for (int i=0; i<n; i++){
                    matrix.get(i).set(0,0);
                }
            }

        return matrix;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix_1 = new ArrayList<>();
        matrix_1.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        matrix_1.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
        matrix_1.add(new ArrayList<>(Arrays.asList(1, 1, 1)));

        ArrayList<ArrayList<Integer>> matrix_2 = new ArrayList<>();
        matrix_2.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        matrix_2.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
        matrix_2.add(new ArrayList<>(Arrays.asList(1, 1, 1)));

        ArrayList<ArrayList<Integer>> matrix_3 = new ArrayList<>();
        matrix_3.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        matrix_3.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
        matrix_3.add(new ArrayList<>(Arrays.asList(1, 1, 1)));

        int n1 = matrix_1.size();
        int m1 = matrix_1.get(0).size();

        int n2 = matrix_1.size();
        int m2 = matrix_1.get(0).size();

        int n3 = matrix_1.size();
        int m3 = matrix_1.get(0).size();

        ArrayList<ArrayList<Integer>> ansMatrix_approach_1 = zeroMatrix_approach_1(matrix_1, n1, m1);
        ArrayList<ArrayList<Integer>> ansMatrix_approach_2 = zeroMatrix_approach_2(matrix_2, n2, m2);
        ArrayList<ArrayList<Integer>> ansMatrix_approach_3 =zeroMatrix_approach_3(matrix_3, n3, m3);
        System.out.println(ansMatrix_approach_1);
        System.out.println(ansMatrix_approach_2);
        System.out.println(ansMatrix_approach_3);
    }
}
