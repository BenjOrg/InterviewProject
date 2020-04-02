package pers.benjamin.tree.bintree;

/**
 * @author Benjamin
 * @date 2020/4/2 21:21
 * @module
 * @purpose
 */
public class FindCommonFather {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);

        TreeNode res = find(treeNode, treeNode.left, treeNode.left.right);
        if (res != null) {
            System.out.println(res.val);
        } else {
            System.out.println("null");
        }
    }

    private static TreeNode find(TreeNode root, TreeNode a, TreeNode b) {

        if (root == null || root == a || root == b) {
            return root;
        }

        TreeNode left = find(root.left, a, b);
        TreeNode right = find(root.right, a, b);

        if (left != null && right != null) {
            return root;
        }

        if (left == null) {
            return right;
        }
        return left;

    }

}
