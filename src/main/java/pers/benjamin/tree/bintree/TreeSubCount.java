package pers.benjamin.tree.bintree;

import java.util.ArrayList;
import java.util.List;

public class TreeSubCount {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(5);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(7);

        findPath(root, 8);
    }

    private static void findPath(TreeNode root, int expectNum) {
        List<Integer> list = new ArrayList<>();

        if (root != null) {
            findPath(root, 0, expectNum, list);
        }
    }

    private static void findPath(TreeNode root, int curSum, int expertNum, List<Integer> list) {
        if (null == root) {
            return;
        }

        curSum += root.val;
        list.add(root.val);
        if (curSum < expertNum) {
            findPath(root.left, curSum, expertNum, list);
            findPath(root.right, curSum, expertNum, list);
        } else if (curSum == expertNum) {
            if (root.left == null && root.right == null) {
                System.out.println(list);
            }
        }

        list.remove(list.size() - 1);
    }
}
