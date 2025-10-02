package tree.lowest_ancestor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import tree.TreeNode;

// 给定两个二叉树节点node1和node2，找到他们的最低公共祖先节点
public class LowestAncestor {
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

        TreeNode result = findLowestAncestor(head, head.left.left.left, head.left.right);

        System.out.println(result.value);
    }

    // 1.从头节点开始，依次把每个节点和它的父亲节点加入到 map，key 为自己，value 为父亲
    // 2.从 node1 开始，依次找到根节点，路线上所有节点都加入到一个 set 中
    // 3.从 node2 开始，依次找到根节点，然后判断路线上的节点是否在 set 中，第一个出现在 set 中的节点就是最低公共祖先节点
    public static TreeNode findLowestAncestor(TreeNode head, TreeNode node1, TreeNode node2){
        Map<TreeNode, TreeNode> map = new HashMap<>();
        map.put(head, head);
        process(head, map);

        Set<TreeNode> set = new HashSet<>();
        TreeNode cur = node1;
        set.add(head);
        while (cur != map.get(cur)) {
            set.add(cur);
            cur = map.get(cur);
        }

        if (set.contains(node2)) {
            return node2;
        }

        cur = node2;
        while (cur != map.get(cur)) {
            if (set.contains(cur)) {
                return cur;
            }
            cur = map.get(cur);
        }

        return null;
    }

    public static void process(TreeNode head, Map<TreeNode, TreeNode> map) {
        if (head == null) {
            return;
        }
        map.put(head.left, head);
        map.put(head.right, head);
        process(head.left, map);
        process(head.right, map);
    }
}
