package zyj.yihong.leetcode.mid.tree;

/**
 * 98. 验证二叉搜索树
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 有效 二叉搜索树定义如下：
 * <p>
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsValidBST98 {
    public static boolean isValidBST(TreeNode root) {
        return checkByRecursion(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    /**
     * 校验当前节点是否满足二叉树的性质
     * @param curNode
     * @param min
     * @param max
     * @return
     */
    public static boolean checkByRecursion(TreeNode curNode,Long min,Long max){
        if (curNode==null){
            return true;
        }

        if (curNode.val>min && curNode.val<max){
            return checkByRecursion(curNode.left,min,(long) curNode.val)
            &&checkByRecursion(curNode.right,(long)curNode.val,max);
        }

        return false;
    }

    public static void main(String[] args) {
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode7 = new TreeNode(7);

        treeNode5.left = treeNode4;
        treeNode5.right = treeNode6;
        treeNode6.left = treeNode3;
        treeNode6.right = treeNode7;

        boolean validBST = isValidBST(treeNode5);
        System.out.println(validBST);

    }



    public static class TreeNode {
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
