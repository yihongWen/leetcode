package zyj.yihong.leetcode.simple.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 589. N 叉树的前序遍历
 * 给定一个 n 叉树的根节点  root ，返回 其节点值的 前序遍历 。
 *
 * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 *
 */
public class Preorder589 {

    /**
     * 使用栈，从右到左入栈
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        List<Integer> preorderNodeList = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur!=null){
            preorderNodeList.add(cur.val);
            List<Node> children = cur.children;
            if (children!=null && children.size()>0){
                for (int i = children.size() - 1; i >= 0; i--) {
                    stack.push(children.get(i));
                }
            }
            if (stack.size()>0) {
                cur = stack.pop();
            }else {
                cur = null;
            }
        }
        return preorderNodeList;
    }


    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
