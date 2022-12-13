package zyj.yihong.leetcode.random_select.dec;

import zyj.yihong.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

// 951. 翻转等价二叉树
public class FlipEquiv_M_951 {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1==root2){
            return true;
        }
        if ((root1==null&&root2!=null) || (root1!=null&&root2==null) || root1.val!=root2.val){
            return false;
        }

        // 当前节点相同时，可以进行翻转或者不翻转
        return (flipEquiv(root1.left,root2.left)&&flipEquiv(root1.right,root2.right)) || (flipEquiv(root1.left,root2.right)&&flipEquiv(root1.right,root2.left));
    }


    public boolean flipEquiv2(TreeNode root1, TreeNode root2) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        dfs(root1,arr1);
        dfs(root2,arr2);
        return arr1.equals(arr2);
    }


    private void dfs(TreeNode root, List<Integer> arr){
        if (root!=null){
            arr.add(root.val);
            int left = root.left == null ? -1 : root.left.val;
            int right = root.right == null ? -1 : root.right.val;
            // 将大的值统一一个方向
            if (left>right){
                dfs(root.right,arr);
                dfs(root.left,arr);
            }else {
                dfs(root.left,arr);
                dfs(root.right,arr);
            }
            // 处理完子节点后添加分割
            arr.add(null);
        }
    }
}
