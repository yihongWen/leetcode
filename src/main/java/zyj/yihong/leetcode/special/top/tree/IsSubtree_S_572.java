package zyj.yihong.leetcode.special.top.tree;

import zyj.yihong.leetcode.utils.TreeNode;

/**
 * 572. 另一棵树的子树
 * 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/subtree-of-another-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsSubtree_S_572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // dfs暴力搜索：
        // 1、遍历root中的每一个节点，能否跟subRoot匹配
        // 2、如果匹配判断左右节点是否匹配
        if (root == null && subRoot == null) {
            return true;
        }
        return dfs(root, subRoot);
    }

    private boolean dfs(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }

        boolean b = judgeDfs(root, subRoot);
        if (b) {
            return true;
        }

        if (root.left != null) {
            boolean leftJudge = dfs(root.left, subRoot);
            if (leftJudge) {
                return true;
            }
        }
        if (root.right != null) {
            return dfs(root.right, subRoot);
        }
        return false;
    }


    private boolean judgeDfs(TreeNode root, TreeNode subRoot) {
        if ((root==null&&subRoot==null)){
            return true;
        }
        if (root.val != subRoot.val) {
            return false;
        }
        if ((subRoot.left == null && root.left != null)||(subRoot.left!=null&&root.left==null)) {
            return false;
        }

        if (subRoot.right == null && root.right != null||(subRoot.right!=null&&root.right==null)) {
            return false;
        }

        if (subRoot.left != null && root.left!=null) {
            boolean b = judgeDfs(root.left, subRoot.left);
            if (!b) {
                return false;
            }
        }

        if (subRoot.right != null && root.right!=null) {
            boolean b = judgeDfs(root.right, subRoot.right);
            return b;
        }
        return true;
    }

    public static void main(String[] args) {
        IsSubtree_S_572 isSubtree_s_572 = new IsSubtree_S_572();
        TreeNode treeNode1  = new TreeNode(3);
        TreeNode treeNode2  = new TreeNode(4);
        TreeNode treeNode3  = new TreeNode(5);
        TreeNode treeNode4  = new TreeNode(1);
        TreeNode treeNode5  = new TreeNode(2);

        treeNode1.left = treeNode2;
        treeNode1.right =treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;


        TreeNode treeNode6  = new TreeNode(4);
        TreeNode treeNode7  = new TreeNode(1);
        TreeNode treeNode8  = new TreeNode(2);
        TreeNode treeNode9  = new TreeNode(1);
        treeNode6.left = treeNode7;
        treeNode6.right = treeNode8;
        treeNode7.left = treeNode9;

        boolean subtree = isSubtree_s_572.isSubtree(treeNode1, treeNode6);
        System.out.println(subtree);

    }
}
