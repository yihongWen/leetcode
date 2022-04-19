package zyj.yihong.leetcode.simple.graph;

import zyj.yihong.leetcode.utils.TreeNode;

/**
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */
public class IsSameTree100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p, q);
    }


    boolean dfs(TreeNode p, TreeNode q) {
        // 不满足的条件
        if (p==null&&q!=null){
            return false;
        }else if (p!=null&&q==null){
            return false;
        }else if (p == null){
            return true;
        } else if (p.val!= q.val){
            return false;
        }else {
            if (!dfs(p.left,q.left)){
                return false;
            }
            if (!dfs(p.right,q.right)){
                return false;
            }
        }
        return true;
    }


}
