package zyj.yihong.leetcode.mid.tree;

import zyj.yihong.leetcode.utils.TreeNode;

/**
 *  后继者
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 *
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 */
public class InorderSuccessor0406 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // 首先判断p是否存在右节点
        TreeNode ans = null;
        if(p.right!=null){
            ans = p.right;
            while (ans.left!=null){
                ans = ans.left;
            }
            return ans;
        }

        TreeNode curNode = root;
        while (curNode!=null){
            if (curNode.val>p.val){
                ans = curNode;
                curNode = curNode.left;
            }else {
                curNode = curNode.right;
            }
        }

        return ans;
    }
}
