package zyj.yihong.leetcode.mid.tree;

import zyj.yihong.leetcode.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 515. 在每个树行中找最大值
 */
public class LargestValues515 {
    public List<Integer> largestValues(TreeNode root) {
        // 广度优先搜索
        List<Integer> ans = new ArrayList<>();
        if (root==null){
            return ans;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            int curLevelValue = queue.peek().val;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.val>curLevelValue){
                    curLevelValue = poll.val;
                }

                if (poll.left!=null){
                    queue.add(poll.left);
                }

                if (poll.right!=null){
                    queue.add(poll.right);
                }
            }
            ans.add(curLevelValue);
        }
        return ans;
    }
}
