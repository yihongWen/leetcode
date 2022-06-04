package zyj.yihong.leetcode.simple.tree;

import zyj.yihong.leetcode.utils.TreeNode;

/**
 * 530. 二叉搜索树的最小绝对差
 */
public class GetMinimumDifference530 {
    public int getMinimumDifference(TreeNode root) {
        // Morris中序遍历
        int preVal = -10000;
        int ans = Integer.MAX_VALUE;

        TreeNode curNode = root;
        while (curNode!=null){
            if (curNode.left==null){
                ans = Math.min(Math.abs(curNode.val-preVal),ans);
                preVal = curNode.val;
                curNode = curNode.right;
                continue;
            }

            // 寻找后继节点
            TreeNode preNode = curNode.left;
            while (preNode.right!=null&&preNode.right!=curNode){
                preNode = preNode.right;
            }

            if (preNode.right==null){
                preNode.right = curNode;
                curNode = curNode.left;
            }else {
                preNode.right=null;
                ans = Math.min(Math.abs(curNode.val-preVal),ans);
                preVal = curNode.val;
                curNode = curNode.right;
            }
        }
        return ans;
    }
}
