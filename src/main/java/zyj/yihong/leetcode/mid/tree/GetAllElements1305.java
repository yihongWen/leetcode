package zyj.yihong.leetcode.mid.tree;

import zyj.yihong.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1305. 两棵二叉搜索树中的所有元素
 */
public class GetAllElements1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> root1List = dfs(root1, new ArrayList<>());
        List<Integer> root2List = dfs(root2, new ArrayList<>());
        int i = 0,j=0;
        while (i<root1List.size()&&j<root2List.size()){
            if (root1List.get(i)<root2List.get(j)){
                ans.add(root1List.get(i));
                i++;
            }else {
                ans.add(root2List.get(j));
                j++;
            }
        }
        if (i==root1List.size()){
            for (int k = j; k < root2List.size(); k++) {
                ans.add(root2List.get(k));
            }
        }

        if (j==root2List.size()){
            for (int k = i; k <root1List.size() ; k++) {
                ans.add(root1List.get(k));
            }
        }

        return ans;
    }

    public List<Integer> dfs(TreeNode root, List<Integer> ans){
        if (root==null){
            return ans;
        }
        dfs(root.left,ans);
        ans.add(root.val);
        dfs(root.right,ans);
        return ans;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(0);
        TreeNode treeNode2 = new TreeNode(-10);
        TreeNode treeNode3 = new TreeNode(10);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        GetAllElements1305 getAllElements1305 = new GetAllElements1305();
        List<Integer> allElements = getAllElements1305.getAllElements(treeNode1, null);
        System.out.println(allElements);
    }


}
