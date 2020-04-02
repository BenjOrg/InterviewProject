package pers.benjamin.dp;

import java.util.Arrays;

public class Fibonacci {

    public static void main(String[] args) {
        int[] arr = new int[5];

        arr[0] = 1;
        arr[1] = 2;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }

        System.out.println(Arrays.toString(arr));
    }
}
