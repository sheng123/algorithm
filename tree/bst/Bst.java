package tree.bst;

import java.util.Stack;

import tree.TreeNode;

// 判断一棵树是否为搜索二叉树
public class Bst {
    public static void main(String[] args) {
        /*
         * 搜索二叉树的定义是任意一个节点，它的左孩子都比它小，右孩子都比它大；左 < 根 < 右
         * 如果按照中序遍历，那么一定是升序的
         * 所以可以使用中序遍历来判断是否为搜索二叉树
         */
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

        System.out.println(isBSTUnrecur(head));
    }

    public static int tempValue = Integer.MIN_VALUE;

    public static boolean isBSTRecur(TreeNode head) {
        if (head == null) {
            return true;
        }

        boolean isBst = isBSTRecur(head.left);
        if (!isBst) {
            return false;
        }

        if (tempValue < head.value) {
            tempValue = head.value;
        } else {
            return false;
        }

        return isBSTRecur(head.right);
    }

    // 先完成非递归的中序遍历
    public static boolean isBSTUnrecur(TreeNode head) {
        if (head == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                if (tempValue < head.value) {
                    tempValue = head.value;
                } else {
                    return false;
                }
                head = head.right;
            }
        }
        return true;
    }

}
