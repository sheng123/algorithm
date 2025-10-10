package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// 拓扑排序是针对​​有向无环图​​的一种排序算法，它能将图中的所有节点排成一个线性序列，使得对于任何一条有向边 u→v，在这个序列中 u都出现在 v之前
public class TopologySort {
    public static List<Node> sortedTopology(Graph graph){
        // 1.找到第一批入度为0的点，当作初始节点
        // 2.擦除入度为0的点，以及该点的影响，与该点相连的点，入度减1
        Map<Node, Integer> inMap = new HashMap<>();
        Queue<Node> zeroInQueue = new LinkedList<>();
        for(Node node : graph.nodes.values()) {
            inMap.put(node, node.in);
            if (node.in == 0) {
                zeroInQueue.add(node);
            }
        }

        List<Node> result = new ArrayList<>();
        while (!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();
            result.add(cur);
            for(Node next : cur.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0) {
                    zeroInQueue.add(next);
                }
            }
        }

        return result;
    }
}
