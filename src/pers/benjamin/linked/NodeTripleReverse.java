package pers.benjamin.linked;

/**
 * @author Benjamin
 * @date 2020/3/31 23:23
 */
public class NodeTripleReverse {

    public static void main(String[] args) {
        Node root = constructNodeList(8);

        Node res = reverseSection(root, 2);

        System.out.println("---------------------------------");
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    private static Node reverse(Node head, Node tail) {
        Node pre = head;
        Node cur = head.next;
        Node tmp;

        while (cur != tail) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        head.next = tail;

        return pre;
    }

    private static Node reverseSub(Node head, Node tail) {
        Node pre = head;
        Node cur = head.next;
        Node tmp;

        while (cur != tail) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        head.next = null;

        return pre;
    }

    private static Node reverseSection(Node head, int size) {
        // 虚拟节点dummy
        Node dummy = new Node(-1);

        // 将dummy链接到链表第一个元素
        dummy.next = head;

        // 节点pre tail
        Node pre = dummy;
        Node tail = dummy;

        while (true) {
            int count = 0;

            // 移动tail到指定位置
            while (tail != null && count != size) {
                count++;
                tail = tail.next;
            }

            // 当tail为null时，表示不满足size数量反转条件
            if (tail == null) {
                break;
            }

            // 虚拟头节点tmpHead，反转后为尾节点
            Node tmpHead = pre.next;

            // 当pre当下一节点不是tail时
            // node: 0->1->2->3->4 size:2
            // pre = 0, tail = 2
            while (pre.next != tail) {
                // 当前节点是pre.next, cur = 1
                Node cur = pre.next;
                // 空出cur
                pre.next = cur.next;
                // cur的下一节点添加到尾部
                cur.next = tail.next;
                // 结束节点的下一节点是当前节点 tail.next = 1
                tail.next = cur;
            }

            pre = tmpHead;
            tail = tmpHead;
        }

        return dummy.next;

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
