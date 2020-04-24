package pers.benjamin.tree.bintree;

/**
 * @author Benjamin
 * @date 2020/4/5 21:15 leetcode 124
 */
public class MaxSumRouteTree {
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

//        solution(root);
        solutin2(root);
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

    private static int solutin2(TreeNode root) {
        if (null == root) {
            return 0;
        }

        int left = solutin2(root.left);
        int right = solutin2(root.right);

        max = Math.max(max, root.val + left + right);

        return Math.max(0, Math.max(left, right) + root.val);
    }
}
