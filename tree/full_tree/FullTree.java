package tree.full_tree;

import tree.TreeNode;

// 判断一棵树是否为满二叉树，满二叉树满足的条件
// 树的高度为 height，那么对应树的节点个数为 2 的 height 次方 - 1（（1 << height） - 1）
public class FullTree {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(3);
        head.right = new TreeNode(8);
        // head.left.left = new TreeNode(2);
        // head.left.right = new TreeNode(4);
        // head.left.left.left = new TreeNode(1);
        // head.right.left = new TreeNode(7);
        // head.right.left.left = new TreeNode(6);
        // head.right.right = new TreeNode(10);
        // head.right.right.left = new TreeNode(9);
        // head.right.right.right = new TreeNode(11);

        System.out.println(isFull(head));
    }

    public static boolean isFull(TreeNode head) {
        Info info = process(head);

        return info.Nodes == ((1 << info.Height) -1 );
    }

    
    public static Info process(TreeNode head) {
        if (head == null) {
            return new Info(0, 0);
        }

        Info infoLeft = process(head.left);
        Info infoRight = process(head.right);

        int height = Math.max(infoLeft.Height, infoRight.Height) + 1;
        int nodes = infoLeft.Nodes + infoRight.Nodes + 1;

        return new Info(height, nodes);
    }

    public static class Info {
        public int Height; // 树的高度
        public int Nodes; // 对应节点的个数

        public Info(int height, int nodes){
            this.Height = height;
            this.Nodes = nodes;
        }
        
    }
}
