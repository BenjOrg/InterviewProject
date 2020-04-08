package pers.benjamin.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[] {3, 5, 3, 0, 8, 6, 1, 5, 8, 6, 2, 4, 9, 4, 7, 0, 1, 8, 9, 7, 3, 1, 2, 5, 9, 7, 4, 0, 2,
                6};

        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    public static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int pivot = arr[begin];

            int i = begin;
            int j = end;

            while (i < j) {
                while (i < j && arr[j] > pivot) {
                    j--;
                }
                if (i < j) {
                    arr[i] = arr[j];
                    i++;
                }

                while (i < j && arr[i] < pivot) {
                    i++;
                }
                if (i < j) {
                    arr[j] = arr[i];
                    j--;
                }
            }
            arr[i] = pivot;

            quickSort(arr, begin, i - 1);
            quickSort(arr, i + 1, end);
        }
    }
}
