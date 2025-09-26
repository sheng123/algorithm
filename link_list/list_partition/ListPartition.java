package link_list.list_partition;

public class ListPartition {
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 5, 3, 4, 8, 6, 8, 2, 1 };

        Node head = new Node(arr[0]);
        Node cur = head;

        for (int i = 1; i < arr.length; i++) {
            cur.next = new Node(arr[i]);
            cur = cur.next;
        }

        Node n = listPartition(head, 5);

        System.out.println(n.value);
    }

    public static Node listPartition(Node head, int pivot) {
        Node sH = null; // small head
        Node sT = null; // small tail
        Node eH = null; // equal head
        Node eT = null; // equal tail
        Node mH = null; // max head
        Node mT = null; // max tail

        while (head != null) {
            Node next = head.next;
            head.next = null;
            if (head.value < pivot) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            } else if (head.value == pivot) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            } else {
                if (mH == null) {
                    mH = head;
                    mT = head;
                } else {
                    mT.next = head;
                    mT = head;
                }
            }

            head = next;
        }

        // 小于区和等于区连接起来
        if (sT != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT; // 如果等于区域为空，那么就使用小于区的尾巴，不为空就使用等于区的尾巴
        }

        // 上面的 if，不管执行没有，与 eT 没有关系
        // 所有的链表进行连接
        if (eT != null) {
            eT.next = mH;
        }

        // 上面所有的链表都串起来以后，再来判断怎么返回
        // 如果 sH 不为空，那么就返回 sH，如果 sH 为空那么就返回 eH 或者 mH 中不为空的
        return sH != null ? sH: (eH != null ? eH : mH);
    }
}
