package zyj.yihong.leetcode.special.top.tree;

import zyj.yihong.leetcode.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * addOneRow
 * 623. 在二叉树中增加一行
 */
public class AddOneRow_M_623 {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        // 处理特殊情况：depth = 1
        if (depth==1){
            TreeNode insertNode = new TreeNode(val);
            insertNode.left = root;
            return insertNode;
        }
        // 使用深度优先搜索：
        dfs(root,val,1,depth);
        return root;
    }

    private void dfs(TreeNode curNode,int insertVal,int curDepth,int insertDepth){
        // 递归条件结束：curDepth = insertDepth-1
        if (curDepth==insertDepth-1){
            TreeNode insertLeftNode = new TreeNode(insertVal);
            TreeNode insertRightNode = new TreeNode(insertVal);
            TreeNode originLeftNode = curNode.left;
            TreeNode originRightNode = curNode.right;
            curNode.left = insertLeftNode;
            insertLeftNode.left =originLeftNode;
            curNode.right = insertRightNode;
            insertRightNode.right = originRightNode;
        }

        if (curNode.left!=null) {
            dfs(curNode.left, insertVal, curDepth + 1, insertDepth);
        }

        if (curNode.right!=null) {
            dfs(curNode.right, insertVal, curDepth + 1, insertDepth);
        }
    }



    public TreeNode addOneRowByBfs(TreeNode root, int val, int depth) {
        // 处理特殊情况：depth = 1
        if (depth==1){
            TreeNode insertNode = new TreeNode(val);
            insertNode.left = root;
            return insertNode;
        }

        // 使用广度优先搜索的方式：
        Queue<TreeNode> queue =new LinkedList<>();
        queue.add(root);
        int curDepth = 1;

        // 寻找待插入的level
        while (curDepth!=depth-1){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left!=null){
                    queue.add(poll.left);
                }
                if (poll.right!=null){
                    queue.add(poll.right);
                }
            }
            curDepth++;
        }

        // 对该层的每一个数据进行处理
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            TreeNode curNode = queue.poll();
            TreeNode insertLeftNode = new TreeNode(val);
            TreeNode insertRightNode = new TreeNode(val);
            TreeNode originLeftNode = curNode.left;
            TreeNode originRightNode = curNode.right;
            curNode.left = insertLeftNode;
            insertLeftNode.left =originLeftNode;
            curNode.right = insertRightNode;
            insertRightNode.right = originRightNode;
        }

        return root;
    }
}
