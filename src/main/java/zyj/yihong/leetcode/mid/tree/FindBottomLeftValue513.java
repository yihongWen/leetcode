package zyj.yihong.leetcode.mid.tree;

import zyj.yihong.leetcode.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 513. 找树左下角的值
 */
public class FindBottomLeftValue513 {

    public int findBottomLeftValue(TreeNode root) {
        // 广度优先搜索
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        TreeNode ansNode = root;
        while (!queue.isEmpty()){
            ansNode = queue.poll();
            if (ansNode.right!=null){
                queue.add(ansNode.right);
            }

            if (ansNode.left!=null){
                queue.add(ansNode.left);
            }
        }

        return ansNode.val;
    }
}
