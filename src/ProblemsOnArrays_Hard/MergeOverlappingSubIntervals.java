package ProblemsOnArrays_Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeOverlappingSubIntervals {

    public static List<List<Integer>> approach_1(int[][] arr, int size) {
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < size; i++) {

            int start = arr[i][0];
            int end = arr[i][1];

            if (!ans.isEmpty() && end <= ans.get(ans.size() - 1).get(1)) {
                continue;
            }
            for (int j = i + 1; j < size; j++) {
                if (arr[j][0] <= end) {
                    end = Math.max(end, arr[j][1]);
                } else {
                    break;
                }
            }
            ans.add(Arrays.asList(start, end));
        }
        return ans;
    }

    public static List<List<Integer>> approach_2(int[][] arr, int size) {
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            if (ans.isEmpty() || arr[i][0] > ans.get(ans.size() - 1).get(1)) {
                ans.add(Arrays.asList(arr[i][0], arr[i][1]));
            } else {

                /**
                 * ans.get(ans.size() - 1) : This piece of code will get the latest value inserted into the array list
                 * set(1,...) : This piece of code will manipulate the value of 2nd index of inner list array (1,3) in this case 3 value will be modified
                 * Math.max(ans.get(ans.size() - 1).get(1), arr[i][1]) : manipulated value of 3 in the above code.
                 * ans.get(ans.size() - 1).get(1) : This will get the current value of 2nd index eg: if (1,3) is present then 3 will be retrived.
                 * arr[i][1] : current values 1st index will be retrived.
                 */
                ans.get(ans.size() - 1).set(1, Math.max(ans.get(ans.size() - 1).get(1), arr[i][1]));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        int size = arr.length;

        List<List<Integer>> ans_1 = approach_1(arr, size);
        System.out.println(ans_1);

        List<List<Integer>> ans_2 = approach_2(arr, size);
        System.out.println(ans_2);
    }
}
