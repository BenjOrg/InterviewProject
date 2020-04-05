package pers.benjamin.tree.bintree;

/**
 * @author Benjamin
 * @date 2020/4/5 15:47
 */
public class TreeHeight {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);


        int leftH = height(root.left);
        int rightH = height(root.right);
        System.out.println(leftH);
        System.out.println(rightH);

        int minus = Math.abs(leftH - rightH);
        System.out.println(minus);
    }

    private static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int height = 1;

        int leftHeight = 0;
        int rightHeight = 0;

        leftHeight += height(root.left);
        rightHeight += height(root.right);

        height += Math.max(leftHeight, rightHeight);

        return height;
    }
}
