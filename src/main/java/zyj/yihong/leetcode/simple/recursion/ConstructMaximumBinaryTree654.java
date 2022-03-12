package zyj.yihong.leetcode.simple.recursion;

/**
 * 654. 最大二叉树
 * 给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
 *
 * 创建一个根节点，其值为 nums 中的最大值。
 * 递归地在最大值 左边 的 子数组前缀上 构建左子树。
 * 递归地在最大值 右边 的 子数组后缀上 构建右子树。
 * 返回 nums 构建的 最大二叉树 。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ConstructMaximumBinaryTree654 {
    /**
     * 递归
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums,0, nums.length);
    }

    public TreeNode construct(int[] nums,int indexLeft,int indexRight){

        if (indexLeft==indexRight){
            return null;
        }
        int indexOfMaxValue = getIndexOfMaxValue(nums, indexLeft, indexRight);
        TreeNode treeNode = new TreeNode(nums[indexOfMaxValue]);
        TreeNode leftMaxNode = construct(nums, indexLeft, indexOfMaxValue);
        TreeNode rightMaxNode = construct(nums, indexOfMaxValue + 1, indexRight);
        treeNode.left = leftMaxNode;
        treeNode.right = rightMaxNode;

        return treeNode;
    }


    private int getIndexOfMaxValue(int[] nums,int indexLeft,int indexRight){
        int maxIndex = indexLeft;
        for (int i = indexLeft+1; i < indexRight; i++) {
            if (nums[i]>nums[maxIndex]){
                maxIndex = i;
            }
        }
        return maxIndex;
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
