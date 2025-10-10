package graph;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class DepthFirstSearch {
    public static void dfs(Node node) {
        Stack<Node> stack = new Stack<>();
        Set<Node> set = new HashSet<>();

        System.out.println(node.value);
        stack.push(node);
        set.add(node);

        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for(Node next : cur.nexts){
                if (!set.contains(next)) {
                    set.add(next);
                    stack.push(cur);
                    stack.push(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }
}
