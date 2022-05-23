package zyj.yihong.leetcode.mid.tree;

import zyj.yihong.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199. 二叉树的右视图
 */
public class RightSideView199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans  = new ArrayList<>();

        if (root==null){
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // bfs
        while (!queue.isEmpty()){
            int size = queue.size();
            ans.add(queue.peek().val);
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.right!=null){
                    queue.add(poll.right);
                }

                if (poll.left!=null){
                    queue.add(poll.left);
                }
            }
        }
        return ans;
    }
}
