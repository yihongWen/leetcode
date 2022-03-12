package zyj.yihong.leetcode.simple.stack;

import java.util.*;

/**
 * 590. N 叉树的后序遍历
 */
public class Postorder590 {
    public List<Integer> postorder(Node root) {

        List<Integer> retValue = new ArrayList<>();
        //定义栈、以及Set保存是否该节点已经访问过

        Stack<Node> stack = new Stack<>();
        Set<Node> handledSet = new HashSet<>();

        stack.push(root);

        while (!stack.isEmpty()){
            Node peek = stack.peek();

            if (!handledSet.contains(peek) && peek.children.size()!=0){
                for (int i = peek.children.size() - 1; i >= 0; i--) {
                    stack.push(peek.children.get(i));
                }
                handledSet.add(peek);
            }else {
                stack.pop();
                retValue.add(peek.val);
            }
        }

        return retValue;
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
