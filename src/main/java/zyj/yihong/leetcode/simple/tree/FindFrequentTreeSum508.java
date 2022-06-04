package zyj.yihong.leetcode.simple.tree;

import zyj.yihong.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 508. 出现次数最多的子树元素和
 */
public class FindFrequentTreeSum508 {
    private int maxCount;
    private Map<Integer,Integer> sonTreeSumCountMap = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : sonTreeSumCountMap.entrySet()) {
            Integer v = entry.getValue();
            if (v==maxCount){
                Integer k = entry.getKey();
                ans.add(k);
            }
        }
        int[] intArrAns = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            intArrAns[i] = ans.get(i);
        }
        return intArrAns;
    }

    private int dfs(TreeNode root){
        if (root==null){
            return 0;
        }

        int val = root.val;
        int leftValue = dfs(root.left);
        int rightValue = dfs(root.right);
        int sum = val+leftValue+rightValue;

        int count = sonTreeSumCountMap.getOrDefault(sum, 0)+1;
        if (count>maxCount){
            maxCount = count;
        }
        sonTreeSumCountMap.put(sum,count);
        return sum;
    }

}
