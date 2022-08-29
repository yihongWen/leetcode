package zyj.yihong.leetcode.random_select.aug;

import zyj.yihong.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 637. 二叉树的层平均值
public class AverageOfLevels_S_637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        // 广度
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (queue.size()!=0){
            int size = queue.size();
            double curSum = 0d;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                curSum+=poll.val;
                if (poll.left!=null){
                    queue.add(poll.left);
                }

                if (poll.right!=null){
                    queue.add(poll.right);
                }
            }
            ans.add(curSum/size);
        }

        return ans;
    }
}
