package zyj.yihong.leetcode.random_select.seg;


import zyj.yihong.leetcode.utils.TreeNode;

// 783. 二叉搜索树节点最小距离
public class MinDiffInBST_S_783 {
    private Integer preValue = null;
    private int ans = Integer.MAX_VALUE;
    // 使用dfs进行中序遍历计算相邻节点的差值
    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root){
        if (root==null){
            return;
        }

        dfs(root.left);
        if (preValue!=null) {
            ans = Math.min(ans, root.val - preValue);
        }
        preValue = root.val;
        dfs(root.right);
    }

    public static void main(String[] args) {
//        [1,0,48,null,null,12,49]
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(48);
        TreeNode node4 = new TreeNode(12);
        TreeNode node5 = new TreeNode(49);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        MinDiffInBST_S_783 minDiffInBST_s_783 = new MinDiffInBST_S_783();
        int i = minDiffInBST_s_783.minDiffInBST(node1);
        System.out.println(i);


    }
}
