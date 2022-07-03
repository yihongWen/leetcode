package zyj.yihong.leetcode.mid.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * <p>
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 */
public class Flatten114 {
    public void flatten(TreeNode root) {
        List<TreeNode> saveNodeList = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();

        TreeNode cur = root;
        while (cur != null || nodeStack.size() != 0) {

            while (cur != null) {
                saveNodeList.add(cur);
                nodeStack.push(cur);
                cur = cur.left;
            }

            if (nodeStack.size()!=0){
                cur = nodeStack.pop();
                cur = cur.right;
            }
        }

        // 构造链表
        root = saveNodeList.get(0);
        root.left = null;
        cur = root;
        for (int i = 1; i < saveNodeList.size(); i++) {
            TreeNode treeNode = saveNodeList.get(i);
            treeNode.left = null;
            cur.right = treeNode;
            cur = cur.right;
        }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
