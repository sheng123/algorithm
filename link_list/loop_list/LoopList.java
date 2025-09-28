package link_list.loop_list;

import link_list.list_partition.ListPartition.Node;

// 判断两个链表是否相交，并且给出交点
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

        Node n = getIntersectNode(head1, head2);

        if (n != null) {
            System.out.println(n.value);
        } else {
            System.out.println(n);
        }
    }

    // 判断两个链表是否相交
    public static Node getIntersectNode(Node head1, Node head2) {
        /*
         * 1.两个链表都无环的情况，判断是否相交
         * 2.一个链表有环，一个链表无环，不可能存在
         * 3.两个链表都有环的情况
         * a.不相交
         * b.相交，交点相同
         * c.相交，交点不同
         */
        if (head1 == null || head2 == null) {
            return null;
        }

        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        }

        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, loop1, head2, loop2);
        }
        return null;
    }

    // 两个链表都有环的情况
    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        // 1.两个链表相交，并且交点相同的情况，类似与 noLoop 的操作
        // 2.不相交和交点不同的情况，只需要从 loop1 开始，不断的进行 next 操作，如果回到 loop1 的时候，还是没有 loop2，那么就不相交
        Node current1 = null;
        Node current2 = null;
        if (loop1 == loop2) {
            current1 = head1;
            current2 = head2;

            int lenght1 = 0;
            int lenght2 = 0;
            while (current1 != null) {
                lenght1++;
                current1 = current1.next;
            }

            while (current2 != null) {
                lenght2++;
                current2 = current2.next;
            }

            current1 = lenght1 > lenght2 ? head1 : head2;
            current2 = current1 == head1 ? head2 : head1;
            int step = Math.abs(lenght1 - lenght2);
            while (step != 0) {
                step--;
                current1 = current1.next;
            }

            while (current1 != current2) {
                current1 = current1.next;
                current2 = current2.next;
            }
            return current1;

        } else {
            // 交点不同的时候，要嘛相交，要嘛不相交，使用 current1 沿着环走一圈
            // 如果不能与 loop2 相等，那么必定不相交；
            // 如果相等，loop1 和 loop2 都是交点，随便返回一个就行
            current1 = loop1.next;
            while (current1 != loop1) {
                if (current1 == loop2) {
                    return loop1;
                }
                current1 = current1.next;
            }

            return null;
        }
    }

    // 判断两个无环链表是否相交，如果相交的话，给出交点的 Node
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
