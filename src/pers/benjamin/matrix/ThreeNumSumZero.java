package pers.benjamin.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Benjamin
 * @date 2020/4/5 15:31
 * @module
 * @purpose
 */
public class ThreeNumSumZero {

    public static void main(String[] args) {
        int[] arr = {-1, -1, 0, -3, 2, 2, 0, -2, 4};

        Arrays.sort(arr);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int start = i + 1;
            int end = arr.length - 1;

            while (start < end) {
                int sum = arr[start] + arr[end];

                if (sum + arr[i] > 0) {
                    end--;
                } else if (sum + arr[i] < 0) {
                    start++;
                } else {
                    String res = arr[i] + ":" + arr[start] + ":" + arr[end];
                    if (!result.contains(res)) {
                        result.add(res);
                    }
                    end--;
                }
            }
        }

        for (String s : result) {
            System.out.println(s);
        }
    }
}
