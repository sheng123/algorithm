package link_list.three_partition_list;

import java.util.ArrayList;

// 给定一个链表，按照一个指定的值 pivot 进行划分，小于的放在新链表的左边，等于的放在中间，小于的放在右边
public class ThreePartitionList {
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

        Node n = threePartitionList(head, 5);

        System.out.println(n.value);
    }

    // 快速的解法，把链表转换成 Node 列表，按照列表进行荷兰国旗算法划分
    // 把数组分为三个区域，小于区域，等于区域和大于区域
    // 初始的 less 区域为 l-1；more 区域为数组最右边+1；因为初始的时候大于区和小于区都没有数字
    // 遍历数组，如果对应位置上的数字小于 pivot 时，less 区域加一，交换 less 和 l，l++
    // 如果对应位置上的数字大于 pivot 时，more--，交换 more 和 l；l 不变
    // 如果对应位置上的数字等于 pivot 时，l++
    public static Node threePartitionList(Node head, int pivot) {
        ArrayList<Node> list = new ArrayList<>();
        while (head != null) {
            list.add(new Node(head.value));
            head = head.next;
        }

        Node[] nodes = list.toArray(new Node[0]);

        int l = 0;
        int more = nodes.length;
        int less = l - 1;
        while (l < more) {
            if (nodes[l].value < pivot) {
                less++;
                swap(nodes, less, l);
                l++;
            } else if (nodes[l].value > pivot) {
                more--;
                swap(nodes, more, l);
            } else if (nodes[l].value == pivot) {
                l++;
            }
        }

        Node h = nodes[0];
        Node cur = h;

        for (int i = 1; i < nodes.length; i++) {
            cur.next = nodes[i];
            cur = cur.next;
        }

        return h;
    }

    public static void swap(Node[] nums, int i, int j) {
        Node temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
