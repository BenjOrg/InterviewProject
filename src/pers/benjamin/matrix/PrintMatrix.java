package pers.benjamin.matrix;

import java.util.ArrayList;
import java.util.List;

public class PrintMatrix {

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

        int left = 0;
        int right = arr[0].length - 1;
        int top = 0;
        int bottom = arr.length - 1;

        List<Integer> list = new ArrayList<>();

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                list.add(arr[top][i]);
            }

            for (int i = top + 1; i <= bottom; i++) {
                list.add(arr[i][right]);
            }

            if (top != bottom) {
                for (int i = right - 1; i >= left; i--) {
                    list.add(arr[bottom][i]);
                }
            }

            if (left != right) {
                for (int i = bottom - 1; i > top; i--) {
                    list.add(arr[i][left]);
                }
            }

            left++;
            right--;
            top++;
            bottom--;
        }

        System.out.println(list);
    }
}
