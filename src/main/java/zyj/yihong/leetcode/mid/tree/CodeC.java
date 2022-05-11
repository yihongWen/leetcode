package zyj.yihong.leetcode.mid.tree;

import zyj.yihong.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class CodeC {

    public String serialize(TreeNode root) {
        List<Integer> cache = new ArrayList<>();
        preSort(root,cache);
        String str = cache.toString();
        return str.substring(1, str.length() - 1);
    }

    public TreeNode deserialize(String data) {
        if (data.isEmpty()){
            return null;
        }
        String[] split = data.split(", ");
        return genNode(split,0,split.length-1);
    }

    private TreeNode genNode(String[] subData,int left,int right){
        if (subData==null||subData.length==0){
            return null;
        }
        // 此时的data 就是serialize方法生成先序遍历
        int rootVal = Integer.parseInt(subData[left]);
        TreeNode root = new TreeNode(rootVal);

        // 寻找左子树
        int rightStart = right+1;
        for (int i = left+1; i <= right; i++) {
            int curValue = Integer.parseInt(subData[i]);
            if (curValue>rootVal){
                rightStart = i;
            }
        }

        if (rightStart>left+1){
            root.left = genNode(subData,left+1,rightStart-1);
        }

        if (rightStart<=right){
            root.right = genNode(subData,rightStart,right);
        }
        return root;

    }

    private void preSort(TreeNode root, List<Integer> cache){
        if (root==null){
            return;
        }
        cache.add(root.val);
        preSort(root.left,cache);
        preSort(root.right,cache);
    }

    public static void main(String[] args) {
        CodeC codec = new CodeC();
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        String serialize = codec.serialize(treeNode1);
        System.out.println(serialize);

        TreeNode deserialize = codec.deserialize("");
        System.out.println(deserialize);

    }
}