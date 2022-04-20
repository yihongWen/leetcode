package zyj.yihong.leetcode.mid.graph;

import zyj.yihong.leetcode.utils.graph.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 133. 克隆图
 */
public class CloneGraph133 {
    public Node cloneGraph(Node node) {

        Map<Node,Node> visited =  new HashMap<>();
        Node dfs = dfs(node, visited);
        return dfs;
    }

    private Node dfs(Node node,Map<Node,Node> visited){
        if (node==null){
            return null;
        }
        if (visited.containsKey(node)){
            return visited.get(node);
        }
        Node cloneRootNode = new Node(node.val,new ArrayList<>());
        visited.put(node,cloneRootNode);
        for (Node neighbor : node.neighbors) {
            visited.get(node).neighbors.add(dfs(neighbor,visited));
        }
        return cloneRootNode;
    }
}
