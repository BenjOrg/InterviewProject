package pers.benjamin.tree.multipletree;

import pers.benjamin.tree.bintree.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Benjamin
 * @date 2020/4/2 23:16
 * @module
 * @purpose
 */
public class MultipleTreeMain {

    public static void main(String[] args) {
        Tuple t1 = new Tuple(1, 2);
        Tuple t2 = new Tuple(1, 3);
        Tuple t3 = new Tuple(2, 4);
        Tuple t4 = new Tuple(2, 5);
        Tuple t5 = new Tuple(4, 6);

        List<Tuple> tuples = Arrays.asList(t1, t2, t3, t4, t5);

        List<Integer> parent = new ArrayList<>();
        List<Integer> child = new ArrayList<>();

        for (Tuple tuple : tuples) {
            parent.add(tuple.parent);
            child.add(tuple.child);
        }

        List<Integer> rootChild = child.stream().filter(parent::contains).distinct().collect(Collectors.toList());
        List<Integer> root = parent.stream().filter(p -> !rootChild.contains(p)).distinct().collect(Collectors.toList());
        if (root.size() != 1) {
            System.out.println("error");
        } else {
            MultipleTreeNode treeNode = new MultipleTreeNode(root.get(0));
            rebuildTree(treeNode, tuples);

            System.out.println(treeNode.val);
        }


    }

    private static void rebuildTree(MultipleTreeNode root, List<Tuple> child) {
        List<Tuple> subTuple = child.stream().filter(c -> root.val == c.parent).collect(Collectors.toList());
        if (subTuple.size() == 0) {
            return;
        }
        for (Tuple t : subTuple) {
            MultipleTreeNode m = new MultipleTreeNode(t.child);
            root.addChild(m);

            rebuildTree(m, child);
        }


    }

    public static class Tuple {
        int parent;
        int child;

        public int getParent() {
            return parent;
        }

        public Tuple(int parent, int child) {
            this.parent = parent;
            this.child = child;
        }
    }
}
