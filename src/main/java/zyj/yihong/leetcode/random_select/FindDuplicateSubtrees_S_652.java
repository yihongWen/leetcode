package zyj.yihong.leetcode.random_select;

import zyj.yihong.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees_S_652 {
    private Map<String,Integer> treeCount = new HashMap<>();
    List<TreeNode> ans = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        // 同一个子树的序列化结果是一致
        dfs(root);
        return ans;
    }


    public String dfs(TreeNode root){
        // 如果节点为空那么直接返回
        if (root==null){
            return "&";
        }
        String s = root.val+"*"+dfs(root.left)+"*"+dfs(root.left);
        treeCount.put(s,treeCount.getOrDefault(s,0)+1);
        if (treeCount.getOrDefault(s,0)>1){
            ans.add(root);
        }
        return s;
    }


}
