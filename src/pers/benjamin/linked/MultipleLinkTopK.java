package pers.benjamin.linked;

import java.util.PriorityQueue;

/**
 * @author Benjamin
 * @date 2020/4/4 17:24
 * @module
 * @purpose
 */
public class MultipleLinkTopK {

    public static void main(String[] args) {

        Node node1 = Node.constructNodeList(10);
        Node node2 = Node.constructNodeList(13);
        Node node3 = Node.constructNodeList(11);

        Node[] nodes = new Node[3];
        nodes[0] = reverse(node1);
        nodes[1] = reverse(node2);
        nodes[2] = reverse(node3);

        Node result = sort(nodes, 8);

        while (result.next != null) {
            System.out.println(result.next.val);
            result = result.next;
        }
    }

    private static Node reverse(Node root) {
        Node result = null;
        while (root != null) {
            Node cur = root;
            root = root.next;
            cur.next = result;
            result = cur;
        }
        return result;
    }

    private static Node sort(Node[] nodes, int k) {
        Node node = new Node(-1);
        Node root = node;

        for (int i = 0; i < k; i++) {
            Node max = compare(nodes);
            if (max == null) {
                break;
            }

            for (int j = 0; j < nodes.length; j++) {
                if (nodes[j] == max) {
                    nodes[j] = nodes[j].next;
                }
            }

            node.next = new Node(max.val);
            node = node.next;

        }

        return root;
    }

    private static Node compare(Node[] nodes) {
        int val = -1;
        Node result = null;
        for (Node node : nodes) {
            if (node != null && node.val > val) {
                result = node;
                val = node.val;
            }
        }

        return result;
    }
}
