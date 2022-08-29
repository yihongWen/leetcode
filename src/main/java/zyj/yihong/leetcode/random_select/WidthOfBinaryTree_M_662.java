package zyj.yihong.leetcode.random_select;

import zyj.yihong.leetcode.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class WidthOfBinaryTree_M_662 {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    public int widthOfBinaryTree(TreeNode root) {
        return dfs(root,1,1);
    }

    private int dfs(TreeNode root,int level,int i) {
        if (root == null) {
            return 0;
        }
        map.putIfAbsent(level, i);

        int curLength = i - map.get(level) + 1;
        int leftLength = dfs(root.left, level + 1, i * 2);
        int rightLength = dfs(root.right, level + 1, i * 2 + 1);
        return Math.max(Math.max(rightLength,leftLength),curLength);

    }
}
