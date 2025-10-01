package tree.balance;

import tree.TreeNode;

// 判断一棵树是否为平衡二叉树
// 平衡二叉树的含义，任意一个子树，它对应的左子树与右子树的高度差小于等于1
public class Balance {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(3);
        head.right = new TreeNode(8);
        head.left.left = new TreeNode(2);
        head.left.right = new TreeNode(4);
        head.left.left.left = new TreeNode(1);
        // head.left.left.left.left = new TreeNode(2);
        head.right.left = new TreeNode(7);
        head.right.left.left = new TreeNode(6);
        head.right.right = new TreeNode(10);
        head.right.right.left = new TreeNode(9);
        head.right.right.right = new TreeNode(11);

        System.out.println(isBalance(head));
    }

    public static boolean isBalance(TreeNode head) {
        return process(head).isBalance;
    }

    public static class ReturnType {
        public int height; // 高度
        public boolean isBalance; // 是否平衡

        public ReturnType(int height, boolean isBalance) {
            this.height = height;
            this.isBalance = isBalance;
        }
    }

    public static ReturnType process(TreeNode head) {
        if (head == null) {
            return new ReturnType(0, true);
        }

        ReturnType leftType = process(head.left);
        ReturnType rightType = process(head.right);

        int height = Math.max(leftType.height, rightType.height) + 1;
        boolean isBalance = leftType.isBalance && rightType.isBalance && (Math.abs(leftType.height - rightType.height) < 2);
        return new ReturnType(height, isBalance);
    }
}
