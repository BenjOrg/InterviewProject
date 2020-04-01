package pers.benjamin.tree.bintree;

import java.util.ArrayDeque;

public class TreeZView {

    public static void main(String[] args) {
        TreeNode root = constructTreeNode();

        boolean flag = true;

        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        ArrayDeque<TreeNode> queue2 = new ArrayDeque<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.getFirst();

            if (node.left != null) {
                queue2.add(node.left);
            }
            if (node.right != null) {
                queue2.add(node.right);
            }

            queue.removeFirst();

            if (queue.isEmpty()) {
                if (flag) {
                    while (!queue2.isEmpty()) {
                        queue.add(queue2.removeFirst());
                    }
                    flag = false;
                } else {
                    while (!queue2.isEmpty()) {
                        queue.add(queue2.removeLast());
                    }
                    flag = true;
                }
            }

            System.out.print(node.val + "    ");

        }
        System.out.print("\n");
    }

    private static TreeNode constructTreeNode() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        return root;
    }
}
