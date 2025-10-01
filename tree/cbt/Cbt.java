package tree.cbt;

import java.util.LinkedList;

import tree.TreeNode;

// 判断一棵树是否为完全二叉树
public class Cbt {
    public static void main (String[] args) {
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

        System.out.println(isCbt(head));
    }
    
    // 完全二叉树，从左往右，依次变满
    // 完全二叉树满足的条件
    // 1.任意一个节点，不存在左边为空，右边有孩子的情况
    // 2.情况1满足的条件下，宽度遍历，遇到第一个节点左孩子或者右孩子为空的情况后，其余节点都是叶子节点
    public static boolean isCbt(TreeNode head) {
        // 宽度遍历，使用队列
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        boolean isLeaf = false;

        while (!queue.isEmpty()) {
            head = queue.poll();
            System.out.print(head.value + " ");
            if ((isLeaf && (head.left != null || head.right != null)) || (head.left == null && head.right != null)) {
            System.out.println();
                return false;
            }

            if (head.left != null) {
                queue.add(head.left);
            }

            if (head.right != null) {
                queue.add(head.right);
            }

            // 宽度遍历，第一次遇见某个节点的左孩子或者右孩子为空的情况
            if (head.left == null || head.right == null) {
                isLeaf = true;
            }
        }

        System.out.println();

        return true;
    }
}
