package zyj.yihong.leetcode.simple.tree;

public class MergeTrees617 {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode dfs = dfs(root1, root2);
        return dfs;
    }

    private TreeNode dfs(TreeNode node1,TreeNode node2){
        if (node1==null && node2==null){
            return null;
        }

        TreeNode node3 = new TreeNode();
        if (node1!=null&& node2!=null){
            node3.val = node1.val + node2.val;
        }else if (node1 == null){
            node3.val = node2.val;;
        }else {
            node3.val = node1.val;
        }
        TreeNode left = dfs(node1==null?null:node1.left, node2==null?null:node2.left);
        TreeNode right = dfs(node1==null?null:node1.right, node2==null?null:node2.right);
        node3.left = left;
        node3.right = right;
        return node3;
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
