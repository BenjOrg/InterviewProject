package pers.benjamin.linked;

/**
 * @author Benjamin
 * @date 2020/4/2 20:57
 */
public class NodeRemoveDuplicate {

    public static void main(String[] args) {
        Node root = new Node(1);
        Node res = root;
        root.next = new Node(2);
        root.next.next = new Node(2);
        root.next.next.next = new Node(2);
        root.next.next.next.next = new Node(3);

        int val = root.val;
        Node pre = root;
        while (root.next != null) {
            root = root.next;
            if (val == root.val) {
                pre.next = root.next;
                pre = root.next;
            } else {
                val = root.val;
            }
        }


        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
