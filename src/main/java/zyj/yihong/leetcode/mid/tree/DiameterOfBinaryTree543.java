package zyj.yihong.leetcode.mid.tree;

public class DiameterOfBinaryTree543 {
    private int maxLength = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxLength-1;
    }

    private int dfs(TreeNode curRoot){
        // 结束条件
        if (curRoot==null){
            return 0;
        }

        int leftLength = dfs(curRoot.left);
        int rightLength = dfs(curRoot.right);

        // 结果：当前子树的结果为最佳，还是选择子树其中的一边+加经过根节点
        maxLength = Math.max(leftLength + rightLength+1, maxLength);

        // 返回子树的最大深度
        return Math.max(leftLength,rightLength)+1;
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
}
