package pers.benjamin.tree.bintree;

/**
 * @author Benjamin
 * @date 2020/4/5 21:15
 * leetcode 124
 */
public class MaxSumRouteTree {
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        solution(root);
        System.out.println(max);
    }

    private static int solution(TreeNode root) {
        if (null == root) {
            return 0;
        }

        int left = Math.max(solution(root.left), 0);
        int right = Math.max(solution(root.right), 0);

        max = Math.max(max, root.val + left + right);

        return root.val + Math.max(left, right);
    }
}