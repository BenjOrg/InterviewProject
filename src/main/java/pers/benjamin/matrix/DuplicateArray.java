package pers.benjamin.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Benjamin
 * @date 2020/4/4 18:21
 * @module
 * @purpose
 */
public class DuplicateArray {

    public static void main(String[] args) {
        int[] a1 = {0, 1, 2, 2, 3, 4, 5, 5, 5, 6, 6, 7, 8, 9, 9, 10};
        int[] a2 = {1, 2, 2, 2, 2, 3, 4, 4, 4, 5, 5, 5, 5, 6, 6, 7, 8, 10, 11, 12};

        List<Integer> result = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < a1.length && j < a2.length) {
            if (a1[i] == a2[j]) {
                result.add(a1[i]);
                i++;
                j++;
            } else if (a1[i] > a2[j]) {
                j++;
            } else {
                i++;
            }
        }

        System.out.println(Arrays.toString(result.toArray()));
    }
}
