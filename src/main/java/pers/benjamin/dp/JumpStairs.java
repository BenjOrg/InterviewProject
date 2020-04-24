package pers.benjamin.dp;

public class JumpStairs {

    public static void main(String[] args) {

        System.out.println(jump(4));

    }

    public static int jump(int target) {
        int[] arr = new int[target];

        if (target <= 0) {
            return 0;
        }

        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }

        arr[0] = 1;
        arr[1] = 2;

        for (int i = 2; i < target; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[target - 1];
    }
}
