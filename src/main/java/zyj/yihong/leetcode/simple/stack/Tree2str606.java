package zyj.yihong.leetcode.simple.stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 606. 根据二叉树创建字符串
 * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 * <p>
 * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-string-from-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Tree2str606 {

    /**
     * 使用递归的方式
     *
     * @param root
     * @return
     */
    public static String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        } else if (root.left == null && root.right == null) {
            return String.valueOf(root.val);
        } else if (root.right == null) {
            return root.val + "(" + tree2str(root.left) + ")";
        } else {
            return root.val + "(" + tree2str(root.left) + ")" +
                    "(" + tree2str(root.right) + ")";
        }
    }

    /**
     * 使用迭代的方式
     *
     * @param root
     * @return
     */
    public static String tree2str2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> existSet = new HashSet<>();
        StringBuilder stringBuilder =  new StringBuilder();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode peek = stack.peek();
            boolean contains = existSet.contains(peek);
            existSet.add(peek);
            // 如果访问过
            if (contains){
                if (peek!=root) {
                    stringBuilder.append(")");
                }
                stack.pop();
            }else{
               if (peek!=root){
                   stringBuilder.append("(");
               }
               stringBuilder.append(peek.val);

               if (peek.left==null && peek.right!=null){
                   stringBuilder.append("()");
               }

               if (peek.right!=null){
                   stack.push(peek.right);
               }

               if (peek.left!=null){
                   stack.push(peek.left);
               }
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        String s = tree2str(treeNode1);
        System.out.println(s);

    }


    static class TreeNode {
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
