package pers.benjamin.linked;

/**
 * @author Benjamin
 * @date 2020/3/31 23:22
 */
public class Node {

    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }


    public static Node constructNodeList(int len) {
        Node root = new Node(0);
        Node node = root;
        Node next;
        for (int i = 1; i < len; i++) {
            next = new Node(i);
            node.next = next;
            node = next;
        }

        return root;
    }
}
