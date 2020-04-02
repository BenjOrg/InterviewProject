package pers.benjamin.string;

import java.util.TreeSet;

public class FullCharacterString {

    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'c'};

        TreeSet<String> result = new TreeSet<>();

        permutation(arr, 0, result);

        System.out.println(result.toString());
    }

    /**
     * <li>ABC ，固定A i=0,j=0 swap
     * <li> BC，固定B i=1,j=1 swap
     * <li>  C，添加ABC i=2,j=2 swap
     * <li> CB，固定C i=1,j=2 swap
     * <li>  B，添加ACB i=1,j=2 swap
     * <li>
     * <li>BAC，固定B i=0,j=1 swap
     * <li> AC，固定A i=1,j=1 swap
     * <li>  C，添加BAC i=2,j=2 swap
     * <li> CA，固定C i=1,j=2 swap
     * <li>  A，添加BCA i=1,j=2 swap
     * <li>
     * <li>CBA，固定C i=0,j=2 swap
     * <li> BA，固定B i=1,j=1 swap
     * <li>  A，添加CBA i=2,j=2 swap
     * <li> AB，固定A i=1,j=2 swap
     * <li>  B，添加CAB i=1,j=2 swap
    */
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
