package pers.benjamin.linked;

public class NodeReverse {

    public static void main(String[] args) {
        Node root = Node.constructNodeList(8);

        Node prev = null;

        while (root != null) {
            Node next = root.next;
            root.next = prev;
            prev = root;
            root = next;

        }

        while (prev.next != null) {
            System.out.println(prev.val);
            prev = prev.next;
        }
    }
}
