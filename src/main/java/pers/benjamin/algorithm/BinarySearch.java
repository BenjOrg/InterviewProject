package pers.benjamin.algorithm;

/**
 * @author Benjamin
 * @date 2020/4/2 22:13
 * @module
 * @purpose
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 3, 4, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10};

        int target = 5;
        int index = 0;

        int lb = 0;
        int rb = arr.length - 1;
        while (lb < rb) {
            index = (lb + rb) / 2;

            if (target < arr[index]) {
                rb = index;
            } else if (target > arr[index]) {
                lb = index;
            } else {
                break;
            }
        }

        int left = index;
        int right = index;

        while (left - 1 >= 0 && arr[left - 1] == target) {
            left--;
        }

        while (right + 1 < arr.length - 1 && arr[right + 1] == target) {
            right++;
        }

        System.out.println(left + "-" + right);
    }
}
