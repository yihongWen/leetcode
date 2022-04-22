package zyj.yihong.leetcode.mid.graph;


import zyj.yihong.leetcode.utils.TreeNode;

/**
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class LowestCommonAncestor236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果root不是为null，那么一定存在公共祖先
        if (root == null) {
            return null;
        }

        // 如果当前根节点是p,q的其中一个，那么根节点就是最近公共祖先
        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        // 深度搜索
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 左右都不为空，返回当节点
        if (left != null && right != null) {
            return root;
        }else if (left==null&& right==null){
            return null;
        }else if (left!=null){
            return left;
        }
        return right;
    }
}
