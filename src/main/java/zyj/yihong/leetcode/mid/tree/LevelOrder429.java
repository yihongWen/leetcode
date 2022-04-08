package zyj.yihong.leetcode.mid.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 429. N 叉树的层序遍历
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 * <p>
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 */
public class LevelOrder429 {

    public List<List<Integer>> levelOrder(Node root) {
        // 使用广度优先搜索
        List<List<Integer>> ans = new ArrayList<>();

        if (root==null){
            return ans;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> cur = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                cur.add(poll.val);
                for (Node child : poll.children) {
                    queue.add(child);
                }
            }
            ans.add(cur);
        }
        return ans;
    }


    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
}
