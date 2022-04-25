package zyj.yihong.leetcode.mid.tree;

import zyj.yihong.leetcode.utils.TreeNode;

/**
 * 538. 把二叉搜索树转换为累加树
 */
public class ConvertBST538 {
    private int sum  = 0;
    public TreeNode convertBST(TreeNode root) {
        // 逆中序遍历
        if (root!=null){
            convertBST(root.right);
            sum+= root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}
