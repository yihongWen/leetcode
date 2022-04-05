package zyj.yihong.leetcode.mid.dp;

/**
 * 337. 打家劫舍 III
 * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
 *
 * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 *
 * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Rob337 {

    public int rob(TreeNode root) {
        int[] dfs = dfs(root);
        return Math.max(dfs[0],dfs[1]);
    }

    public int[] dfs(TreeNode root){
        if (root==null){
            return new int[]{0,0};
        }

        int[] leftInt = dfs(root.left);
        int[] rightInt = dfs(root.right);
        int[] curValue = new int[2];
        curValue[0] = root.val+leftInt[1]+rightInt[1];
        curValue[1] = Math.max(leftInt[1],leftInt[0])+Math.max(rightInt[1],rightInt[0]);
        return curValue;
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
