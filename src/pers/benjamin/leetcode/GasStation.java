package pers.benjamin.leetcode;

/**
 * @author Benjamin
 * @date 2020/4/5 16:19
 * leetcode 134
 */
public class GasStation {

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};

        System.out.println(solution(gas, cost));
    }

    private static int solution(int[] gas, int[] cost) {
        int spare = 0;

        int minIndex = 0;

        int totalSpare = Integer.MAX_VALUE;

        for (int i = 0; i < gas.length; i++) {
            spare += gas[i] - cost[i];
            System.out.println(spare + ":" + totalSpare);
            if (spare < totalSpare) {
                totalSpare = spare;
                minIndex = i;
            }
        }

        return spare < 0 ? -1 : minIndex;
    }
}
