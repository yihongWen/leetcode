package zyj.yihong.leetcode.special.top.recursion;

import zyj.yihong.leetcode.utils.TreeNode;

/**
 * 450. 删除二叉搜索树中的节点
 */
public class DeleteNode_M_450 {
    // 使用递归的方式删除
    public TreeNode deleteNode(TreeNode root, int key) {
        // root为空表示：此二叉树中不存在该key
        if (root==null){
            return null;
        }

        // 往左查找对应的key
        if (root.val>key){
            root.left = deleteNode(root.left,key);
            return root;
        }

        // 往右查找对应的key
        if (root.val<key){
            root.right = deleteNode(root.right,key);
            return root;
        }

        //找到需要删除的key
        // 判断待删除节点存在的子树情况

        // 直接删除
        if (root.left == null && root.right == null) {
            return null;
        }

        // 左子树为空、右子树存在
        if (root.left == null) {
            return root.right;
        }

        // 右子树为空，左子树存在
        if (root.right == null) {
            return root.left;
        }

        // 找出后继节点
        TreeNode successorNode = root.right;
        while (successorNode.left != null) {
            successorNode = successorNode.left;
        }

        // 将后继节点的删除（删除当前位置的引用关系,将后节点的右子树，提升置其父节点的左子树中
        root.right = deleteNode(root.right, successorNode.val);

        // 将后继节点提升到删除节点的位置
        successorNode.left = root.left;
        successorNode.right = root.right;
        return successorNode;

    }
}
