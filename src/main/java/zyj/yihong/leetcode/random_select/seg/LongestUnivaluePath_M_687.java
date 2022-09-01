package zyj.yihong.leetcode.random_select.seg;


import zyj.yihong.leetcode.utils.TreeNode;

// 687. 最长同值路径
public class LongestUnivaluePath_M_687 {
    private int ans = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root){

        // 结束条件1
        if (root==null){
            return 0;
        }

        // 计算当前节点的左右子树
        int leftCount = dfs(root.left);
        int rightCount = dfs(root.right);
        int leftTemp = 0;
        int rightTemp = 0;
        if (root.left!=null&&root.val==root.left.val){
            leftTemp= leftCount+1;
        }

        if (root.right!=null&&root.val==root.right.val){
            rightTemp= rightCount+1;
        }

        // 判断当前节点为根节点的子树的最大值是否超过历史
        // 如果两侧相等则两个temp存在数据，如果单测相等则只有单侧存在数据
        ans = Math.max(ans,leftTemp+rightTemp);


        // 递归结束条件，计算完成当前子树的长度
        return Math.max(rightTemp,leftTemp);
    }
}
