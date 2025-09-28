package link_list.loop_list;

import link_list.list_partition.ListPartition.Node;

public class LoopList {
    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 5, 3, 4, 8, 6, 8, 2, 1 };
        int[] arr2 = { 1, 2, 3, 5, 3, 4 };


        Node head1 = new Node(arr1[0]);
        Node cur1 = head1;

        for (int i = 1; i < arr1.length; i++) {
            cur1.next = new Node(arr1[i]);
            cur1 = cur1.next;
        }

        Node head2 = new Node(arr2[0]);
        Node cur2 = head2;

        for (int i = 1; i < arr2.length; i++) {
            cur2.next = new Node(arr2[i]);
            cur2 = cur2.next;
        }

        // 构建两个链表相交
        cur1.next = cur2.next = new Node(10);

        // 构建一个有环的链表
        // cur.next = head.next.next.next;

        Node n = noLoop(head1, head2);

        if (n != null) {
            System.out.println(n.value);
        } else {
            System.out.println(n);
        }
    }

    // 判断两个链表是否相交，如果相交的话，给出交点的 Node
    public static Node noLoop(Node head1, Node head2) {
        /*
         * 1.先确定两个链表是没有环的
         * 2.循环遍历两个链表，确定链表的长度 length1 和 length2，同时确定最后一个节点是否相同，相同的话是相交的
         * 3.长链表先走 length1 - length2 步长
         * 4.然后长短链表一起走，第一个相同的位置就是交点
         */
        Node current1 = head1;
        Node current2 = head2;

        int length1 = 0;
        int length2 = 0;
        while (current1 != null) {
            length1++;
            current1 = current1.next;
        }
        while (current2 != null) {
            length2++;
            current2 = current2.next;
        }
        // 连个链表遍历到最后一个节点，如果相交的话，最后一个节点必然是相同的
        if (current1 != current2) {
            return null;
        }

        // 判断一下链表的长度，让 current1 指向长的链表， current2 指向短的链表
        current1 = length1 > length2 ? head1 : head2;
        current2 = current1 == head1 ? head2 : head1;
        int step = Math.abs(length1 - length2);
        while (step != 0) {
            current1 = current1.next;
            step--;
        }

        while (current1 != current2) {
            current1 = current1.next;
            current2 = current2.next;
        }

        return current1;
    }

    // 判断一个链表是否有环
    public static Node getLoopNode(Node head) {
        // 1.设置快慢指针，慢指针走一步，快指针走两步
        // 2.结束条件为快指针的next或者next.next为null
        // 3.如果有环的话，快指针和慢指针必然会相遇
        // 4.相遇以后，把快指针设置回 head，然后一次走一步，快慢指针下次相遇的时候，就是环的起点位置（没有证明）

        Node slow = head;
        Node fast = head;
        slow = slow.next;
        fast = fast.next.next;
        while (slow != fast) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }
}
