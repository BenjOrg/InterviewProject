package pers.benjamin.linked;

public class NodeReverse {

    public static void main(String[] args) {
        Node root = Node.constructNodeList(8);

        Node result = null;

        while (root != null) {
            Node cur = root;
            root = root.next;
            cur.next = result;
            result = cur;

        }

        while (result.next != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
