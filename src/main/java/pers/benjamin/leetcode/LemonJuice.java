package pers.benjamin.leetcode;

/**
 * @author Benjamin
 * @date 2020/4/5 16:46
 * leetcode 860
 */
public class LemonJuice {

    public static void main(String[] args) {
        int[] money = {5, 5, 10, 10, 20};

        System.out.println(solution(money));
    }

    private static boolean solution(int[] money) {
        int count5 = 0;
        int count10 = 0;

        for (int i = 0; i < money.length; i++) {
            if (money[i] == 5) {
                count5++;
            } else {
                if (money[i] == 10) {
                    if (count5 == 0) {
                        return false;
                    }
                    count5--;
                    count10++;
                } else {
                    if (count10 == 0) {
                        if (count5 < 3) {
                            return false;
                        } else {
                            count5 -= 3;
                        }
                    } else {
                        if (count5 == 0) {
                            return false;
                        } else {
                            count5--;
                        }
                    }
                }
            }
        }

        return true;
    }
}
