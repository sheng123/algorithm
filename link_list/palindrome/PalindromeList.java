package link_list.palindrome;

import java.util.Stack;

// 判断给定的一个链表是否为回文数
// 如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的
public class PalindromeList {
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
        int[] arr = { 1, 2, 3, 2, 1 };

        Node head = new Node(arr[0]);
        Node cur = head;

        for (int i = 1; i < arr.length; i++) {
            cur.next = new Node(arr[i]);
            cur = cur.next;
        }

        boolean b = isPalindrome2(head);

        System.out.println(b);
    }

    public static boolean isPalindrome1(Node head) {
        Stack<Node> stack = new Stack<>();

        Node curNode = head;
        while (curNode != null) {
            stack.push(curNode);
            curNode = curNode.next;
        }

        while (head != null) {
            if (head.value != stack.pop().value) {
                return false;
            }

            head = head.next;
        }
        return true;
    }

    public static boolean isPalindrome2(Node head) {
        Node left = head;
        Node right = head;
        while (right.next != null && right.next.next != null) {
            left = left.next;
            right = right.next.next;
        }

        Stack<Node> stack = new Stack<>();

        while (left.next != null) {
            stack.push(left.next);
            left = left.next;
        }

        while (!stack.isEmpty()) {
            if (head.value != stack.pop().value) {
                return false;
            }

            head = head.next;
        }
        return true;
    }
}
