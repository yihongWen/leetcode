package zyj.yihong.leetcode.mid.graph;

import zyj.yihong.leetcode.utils.Node;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 */
public class Connect117 {
    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }

        // 定义下层起始，以及维护chain关系
        Node nextLevelStartNode;
        Node nextLevelChainNode;

        Node curStartNode = root;
        // 处理每一层
        while (curStartNode != null) {
            nextLevelStartNode = null;
            nextLevelChainNode = null;

            // 处理当前层的没一个节点，建立nextLevel的链表关系
            for (Node curNode = curStartNode; curNode != null; curNode = curNode.next) {

                if (curNode.left != null) {
                    if (nextLevelStartNode == null) {
                        nextLevelStartNode = curNode.left;
                    }
                    if (nextLevelChainNode != null) {
                        nextLevelChainNode.next = curNode.left;
                    }
                    nextLevelChainNode = curNode.left;
                }

                if (curNode.right != null) {
                    if (nextLevelStartNode == null) {
                        nextLevelStartNode = curNode.right;
                    }
                    if (nextLevelChainNode != null) {
                        nextLevelChainNode.next = curNode.right;
                    }
                    nextLevelChainNode = curNode.right;
                }
            }

            curStartNode = nextLevelStartNode;
        }

        return root;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;

        connect(node1);

    }

}
