package pers.benjamin.linked;

/**
 * @author Benjamin
 * @date 2020/3/31 23:23
 */
public class NodeTripleReverse {

    public static void main(String[] args) {
        Node root = constructNodeList(6);

        reverse(root, root.next.next.next);

        System.out.println("---------------------------------");
        while (root != null) {
            System.out.println(root.val);
            root = root.next;
        }
    }

    private static Node reverse(Node head) {
        Node result = null;
        while (head != null) {
            Node cur = head;
            head = head.next;
            cur.next = result;
            result = cur;
        }

        return result;
    }

    private static void reverse(Node head, Node tail) {
        Node cur = head;
        Node pre = null;
        while (true) {
            Node next = cur.next;

            if (pre == null) {
                cur.next = tail.next;
            } else {
                cur.next = pre;
            }

            if (cur.val == tail.val) {
                break;
            }

            pre = cur;
            cur = next;
        }

    }

    private static Node reverseSection(Node root, int size) {
        if (size <= 1) {
            return root;
        }

        int total = size(root);

        if (total < size) {
            return root;
        }

        while (true) {
            Node head = root;
            Node tail = root;
            for (int i = 0; i < size; i++) {
                tail = tail.next;
                if (tail == null) {
                    return head.next;
                }
            }

            reverse(head, tail);
        }

    }

    private static int size(Node root) {
        int total = 0;

        Node tmp = root;
        while (tmp != null) {
            total++;
            tmp = tmp.next;
        }

        return total;
    }

    private static Node constructNodeList(int len) {
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
