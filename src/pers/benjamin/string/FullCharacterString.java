package pers.benjamin.string;

import java.util.TreeSet;

public class FullCharacterString {

    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'c'};

        TreeSet<String> result = new TreeSet<>();

        permutation(arr, 0, result);

        System.out.println(result.toString());
    }

    public static void permutation(char[] arr, int from, TreeSet<String> result) {
        if (from > arr.length - 1) {
            return;
        }

        if (from == arr.length - 1) {
            result.add(String.valueOf(arr));
        } else {
            for (int i = from; i < arr.length; i++) {
                swap(arr, i, from);
                permutation(arr, from + 1, result);
                swap(arr, from, i);
            }
        }
    }

    public static void swap(char[] arr, int from, int to) {
        char tmp = arr[from];
        arr[from] = arr[to];
        arr[to] = tmp;
    }
}
