package pers.benjamin.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[] {3, 5, 3, 0, 8, 6, 1, 5, 8, 6, 2, 4, 9, 4, 7, 0, 1, 8, 9, 7, 3, 1, 2, 5, 9, 7, 4, 0, 2,
                6};

        mergeSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void mergeSort(int[] arr) {
        int[] res = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, res);
    }

    public static void mergeSort(int[] arr, int left, int right, int[] tmp) {
        if (left < right) {
            System.out.println(Arrays.toString(arr));
            int mid = (right + left) >> 1;

            System.out.println(left + "-" + mid + "-" + right);
            mergeSort(arr, left, mid, tmp);
            mergeSort(arr, mid + 1, right, tmp);
            merge(arr, left, mid, right, tmp);
            System.out.println(Arrays.toString(arr));
            System.out.println(
                            "-------------------------------------------------------------------------------------------------");
        }
    }

    public static void merge(int[] arr, int left, int mid, int right, int[] tmp) {
        int i = left;
        int j = mid + 1;
        int t = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                tmp[t++] = arr[i++];
            } else {
                tmp[t++] = arr[j++];
            }
        }

        while (i <= mid) {
            tmp[t++] = arr[i++];
        }
        while (j <= right) {
            tmp[t++] = arr[j++];
        }

        t = 0;
        while (left <= right) {
            arr[left++] = tmp[t++];
        }
    }
}
