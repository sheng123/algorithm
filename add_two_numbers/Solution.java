package add_two_numbers;

// 243
// 564
// 708

public class Solution {
    public static void main(String[] args) {
        // ListNode node2 = new ListNode(9);
        // ListNode node4 = new ListNode(4, node2);
        ListNode l1 = new ListNode(9);

        ListNode node5 = new ListNode(9);
        ListNode node6 = new ListNode(9, node5);
        ListNode l2 = new ListNode(9, node6);

        ListNode result = addTwoNumbers(l1, l2);

        while (result.next != null) {
            System.out.println(result.val);
            result = result.next;
        }
        System.out.println(result.val);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode();
        ListNode result = node;

        int temp = 0;
        while (l1 != null || l2 != null) {
            int v1 = 0;
            int v2 = 0;

            if (l1 != null) {
                v1 = l1.val;
            } else {
                l1 = new ListNode();
                v1 = 0;
            }

            if (l2 != null) {
                v2 = l2.val;
            } else {
                l2 = new ListNode();
                v2 = 0;
            }

            node.val = (v1 + v2 + temp) % 10;

            if (v1 + v2 + temp >= 10) {
                temp = 1;
            } else {
                temp = 0;
            }

            l1 = l1.next;
            l2 = l2.next;

 
            if (l1 == null && l2 == null && temp != 0) {
                node.next = new ListNode(temp);
                node = node.next;
                break;
            }

            if (l1 == null && l2 == null) {
                break;
            }

            node.next = new ListNode();
            node = node.next;
        }

        return result;
    }
}
