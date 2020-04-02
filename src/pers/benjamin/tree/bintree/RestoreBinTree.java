package pers.benjamin.tree.bintree;

import java.util.Arrays;

public class RestoreBinTree {

    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] midOrder = {4, 7, 2, 1, 5, 3, 8, 6};


        TreeNode root = restore(preOrder, midOrder);
    }

    public static TreeNode restore(int[] preOrder, int[] midOrder) {
        if (preOrder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preOrder[0]);

        int rootIndex = 0;
        for (int i = 0; i < midOrder.length; i++) {
            if (midOrder[i] == preOrder[0]) {
                rootIndex = i;
            }
        }

        root.left = restore(Arrays.copyOfRange(preOrder, 1, rootIndex + 1), Arrays.copyOfRange(midOrder, 0, rootIndex));

        root.right = restore(Arrays.copyOfRange(preOrder, rootIndex + 1, preOrder.length),
                        Arrays.copyOfRange(midOrder, rootIndex + 1, midOrder.length));

        return root;
    }
}
