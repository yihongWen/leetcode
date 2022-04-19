package zyj.yihong.leetcode.mid.graph;

import zyj.yihong.leetcode.utils.Node;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 */
public class Connect116 {
    public Node connect(Node root) {
        if (root==null){
            return null;
        }
        // 遍历每一层
        Node curLevelLeftNode = root;
        while (curLevelLeftNode.left!=null){
            Node curLevelNode = curLevelLeftNode;
            // 处理当前层的每个Node的指向
            while (curLevelNode!=null) {
                curLevelNode.left.next = curLevelNode.right;
                if (curLevelNode.next != null) {
                    curLevelNode.right.next = curLevelNode.next.left;
                }
                curLevelNode = curLevelNode.next;
            }
            curLevelLeftNode = curLevelLeftNode.left;
        }
        return root;
    }
}
