package pers.benjamin.tree.multipletree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Benjamin
 * @date 2020/4/2 23:12
 * @module
 * @purpose
 */
public class MultipleTreeNode {

    int val;
    List<MultipleTreeNode> child;

    public MultipleTreeNode(int val) {
        this.val = val;
        this.child = new ArrayList<>();
    }

    public void addChild(MultipleTreeNode m){
        this.child.add(m);
    }
}
