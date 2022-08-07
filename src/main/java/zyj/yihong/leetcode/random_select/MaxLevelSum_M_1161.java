package zyj.yihong.leetcode.random_select;

import zyj.yihong.leetcode.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSum_M_1161 {
    public int maxLevelSum(TreeNode root) {
        // 广度优先搜索
        int ansLevel = 1;
        int maxSum = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int curLevel = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            int curSum = 0;
            curLevel++;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                curSum+=poll.val;
                if (poll.left!=null) {
                    queue.add(poll.left);
                }

                if (poll.right!=null) {
                    queue.add(poll.right);
                }
            }
            if (curSum>maxSum){
                maxSum = curSum;
                ansLevel = curLevel;
            }
        }

        return ansLevel;
    }
}
