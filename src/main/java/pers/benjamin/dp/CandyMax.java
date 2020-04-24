package pers.benjamin.dp;

import java.util.Arrays;

/**
 * @author Benjamin
 * @date 2020/4/4 18:46
 * @module
 * @purpose
 */
public class CandyMax {

    public static void main(String[] args) {
        int[] candy = {1, 3, 5, 7, 8, 10, 3, 2, 5, 4};

        int[] result = new int[candy.length];

        result[0] = candy[0];
        result[1] = candy[1];
        for (int i = 2; i < candy.length; i++) {
            result[i] = Math.max(result[i - 1], candy[i] + result[i - 2]);
        }

        System.out.println(Arrays.toString(result));
    }
}
