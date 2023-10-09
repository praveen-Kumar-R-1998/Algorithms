package ProblemsOnArray_Medium;

/**
 * Also called rotate image
 * <p>
 * here we have to rotate the matrix in clockwise direction by 90 degree
 */

public class RotateMatrixBy_90_Degree {

    /**
     * Here we will first transpose the given matrix(replacing row with column and vice verse) and then reverse the row to get the
     * desired answer
     * Here we won't be using any extra space we will be operating in the given array it self
     *
     * @param matrix
     */
    public static void rotate_Approach_2(int[][] matrix) {
//        Transpose operation
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
//        Reversing operation
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - i] = temp;
            }
        }
    }

    public static int[][] rotate_Approach_1(int[][] matrix) {
        int size = matrix.length;
        int[][] rotated = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                rotated[j][size - i - 1] = matrix[i][j];

            }
        }
        return rotated;
    }

    public static void main(String[] args) {
        int[][] arr_1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("Before rotation\n");
        for (int i = 0; i < arr_1.length; i++) {
            for (int j = 0; j < arr_1.length; j++) {
                System.out.print(arr_1[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\n********************\n********************\n");
        int[][] ans = rotate_Approach_1(arr_1);
        System.out.println("Rotated array \n");
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans.length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();

        }

        System.out.println("\n####################\n####################\n");
        int[][] arr_2 = {{7, 8, 9}, {4, 5, 6}, {1, 2, 3}};
        System.out.println("Before rotation\n");
        for (int i = 0; i < arr_2.length; i++) {
            for (int j = 0; j < arr_2.length; j++) {
                System.out.print(arr_2[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\n********************\n********************\n");
        int[][] ans_2 = rotate_Approach_1(arr_1);
        System.out.println("Rotated array \n");
        for (int i = 0; i < ans_2.length; i++) {
            for (int j = 0; j < ans_2.length; j++) {
                System.out.print(ans_2[i][j] + " ");
            }
            System.out.println();
        }
    }
}



