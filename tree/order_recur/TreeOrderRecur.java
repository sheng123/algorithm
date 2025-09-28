package tree.order_recur;

import java.util.Stack;

import tree.TreeNode;

public class TreeOrderRecur {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(3);
        head.right = new TreeNode(8);
        head.left.left = new TreeNode(2);
        head.left.right = new TreeNode(4);
        head.left.left.left = new TreeNode(1);
        head.right.left = new TreeNode(7);
        head.right.left.left = new TreeNode(6);
        head.right.right = new TreeNode(10);
        head.right.right.left = new TreeNode(9);
        head.right.right.right = new TreeNode(11);

        System.out.println("pre order recur");
        preOrderRecur(head);
        System.out.println();
        preOrderUnrecur(head);

        System.out.println();


        inOrderRecur(head);
        System.out.println();
        inOrderUnrecur(head);

        System.out.println();
        posOrderRecur(head);
        System.out.println();
        posOrderUnrecur(head);
    }

    // 前序遍历
    public static void preOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    // 中序遍历
    public static void inOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }

        inOrderRecur(head.left);
        System.out.print(head.value + " ");
        inOrderRecur(head.right);
    }

    // 后序遍历
    public static void posOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }

        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value + " ");
    }

    // 前序遍历，非递归方式
    // 前序遍历，先处理根节点，然后右节点入栈，再左节点入栈
    // 栈是先进后出，处理的时候就是先处理根，后左，再右
    public static void preOrderUnrecur(TreeNode head) {
        System.out.println("pre order unrecur");
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.print(head.value + " ");
                if (head.right != null) {
                    stack.push(head.right);
                }

                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    // 中序遍历，非递归方式
    // 所有的左节点都压栈，然后依次弹出处理栈中的节点，打印
    // 对弹出的节点的右节点，做上面相同的处理
    public static void inOrderUnrecur(TreeNode head) {
        System.out.println("in-order unrecur");
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.value + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    // 后序遍历，非递归方式
    // 后序遍历，使用两个栈，先处理根节点，然后左节点入栈，再右节点入栈
    // 栈是先进后出，处理的时候就是先处理根，后右，再左；按照这个顺序进入第二个栈
    // 第二个栈出栈，就是按照 左右根 的顺序出来，就是后序遍历了
    public static void posOrderUnrecur(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> s1 = new Stack<>();
            Stack<TreeNode> s2 = new Stack<>();

            s1.push(head);
            while (!s1.isEmpty()) {
                head = s1.pop();
                s2.push(head);

                if (head.left != null) {
                    s1.push(head.left);
                }

                if (head.right != null) {
                    s1.push(head.right);
                }
            }

            while (!s2.isEmpty()) {
                head = s2.pop();
                System.out.print(head.value + " ");
            }
        }
    }
}
