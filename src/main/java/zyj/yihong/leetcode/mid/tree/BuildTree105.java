package zyj.yihong.leetcode.mid.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BuildTree105 {

    private Map<Integer,Integer> map = new HashMap<>();

    /**
     * 明确：先序跟中序可以唯一确定一颗二叉树
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 通过先序的第一个找到当前（子树）的跟节点。
        // 中序遍历中子树的根节点对子树的左右拆分
        // 递归的进行构造

        // 提前构造每个子树根节点所在的位置，用于快速判断子树两边的个数
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        TreeNode root = dfs(preorder, inorder, 0, inorder.length - 1, 0, inorder.length - 1);
        return root;
    }


    public TreeNode dfs(int[] preorder,int[] inorder,int preLeft,int preRight,int inLeft,int inRight){
        // 递归的结束条件
        if (preLeft>preRight){
            return null;
        }

        // 从先序遍历中取出根节点,并找出所在中序遍历的位置
        int curRootValue = preorder[preLeft];
        Integer rootIndexInorder = map.get(curRootValue);

        // 构造根节点
        TreeNode curRoot = new TreeNode(curRootValue);

        // 构造左子树
        int leftSize = rootIndexInorder - inLeft;
        TreeNode leftTree = dfs(preorder, inorder, preLeft + 1, preLeft + leftSize, inLeft, rootIndexInorder - 1);

        // 构造右子树
        TreeNode rightTree = dfs(preorder, inorder, preLeft + 1+leftSize, preRight, rootIndexInorder+1,  inRight);

        curRoot.left = leftTree;
        curRoot.right = rightTree;

        return curRoot;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
