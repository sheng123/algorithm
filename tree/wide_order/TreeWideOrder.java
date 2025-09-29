package tree.wide_order;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import tree.TreeNode;

public class TreeWideOrder {
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

        int maxWide = maxWide(head);

        System.out.println(maxWide);
    }

    // 获取树的最大宽度
    public static int maxWide(TreeNode head) {
        /*
         * 需要借助一个 map 来记录每个节点是在哪一层
         */
        if (head == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        Map<TreeNode, Integer> levelMap = new HashMap<>();
        levelMap.put(head, 1);
        int curLevel = 1;
        int curLevelNodes = 0;
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            int curNodeLevel = levelMap.get(curNode);
            if (curNodeLevel == curLevel) {
                curLevelNodes++;
            } else {
                max = Math.max(max, curLevelNodes);
                curLevel++;
                curLevelNodes = 1;
            }

            if (curNode.left != null) {
                levelMap.put(curNode.left, curNodeLevel + 1);
                queue.add(curNode.left);
            }

            if (curNode.right != null) {
                levelMap.put(curNode.right, curNodeLevel + 1);
                queue.add(curNode.right);
            }
        }

        return max;
    }
    
    
    // 宽度遍历
    // 使用队列来处理
    public static void wideOrder(TreeNode head) {
        /*
         * 1.先把头节点加入队列
         * 2.取出头节点，打印
         * 3.把取出的节点的左节点放入队列（不为空的话）
         * 4.把取出的节点的右节点放入队列（不为空的话）
         * 5.循环
         */
        if (head == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.print(cur.value + " ");
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }

    }
}
