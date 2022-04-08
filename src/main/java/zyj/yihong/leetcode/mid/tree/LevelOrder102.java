package zyj.yihong.leetcode.mid.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 */
public class LevelOrder102 {
    /**
     * 广度优先搜索，比图的广度优先搜索简单一点，因为不会存在重复的情况
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root==null){
            return resultList;
        }
        Queue<TreeNode> queue =  new ArrayDeque<>();
        queue.offer(root);
        while (queue.size()>0){
            int curLevelCount = queue.size();
            List<Integer> curLevelList = new ArrayList<>();
            for (int i = 0; i < curLevelCount; i++) {
                TreeNode poll = queue.poll();
                curLevelList.add(poll.val);
                if (poll.left!=null){
                    queue.offer(poll.left);
                }
                if (poll.right!=null){
                    queue.offer(poll.right);
                }
            }
            resultList.add(curLevelList);
        }
        return resultList;
    }



    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public static void main(String[] args) {
        System.out.println(2%4);
    }
}
