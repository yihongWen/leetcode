package zyj.yihong.leetcode.simple.tree;

import zyj.yihong.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 501. 二叉搜索树中的众数
 */
public class FindMode501 {

    private int curNodeVal;
    private int curCount;
    private int maxCount;
    private List<Integer> ans = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        // 使用Morris 中序遍历
        TreeNode cur = root;
        while (cur!=null){
            // 如果左子树为空,处理当前节点后，其右子树为下一个节点
            if (cur.left==null){
                handleNode(cur.val);
                cur=cur.right;
                continue;
            }

            // 如果左子树不为空，那么找到当前节点的前驱节点，使得前驱节点的的next指向当前节点
            // 如果已经处理过，则置空引用，处理当前节点，处理后指向当前节点的右节点
            TreeNode pre = cur.left;
            while (pre.right!=null&&pre.right!=cur){
                pre = pre.right;
            }

            // 判断是否处理过
            if (pre.right==null){
                pre.right = cur;
                cur = cur.left;
            }else {
                pre.right = null;
                handleNode(cur.val);
                cur = cur.right;
            }
        }

        // 处理结果
        int[] intArrAns = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            intArrAns[i] = ans.get(i);
        }
        return intArrAns;
    }

    // 处理每一个节点
    private void handleNode(int val) {
        // 如果当前节点是否是前一个节点
        if (val == curNodeVal) {
            curCount++;
        } else {
            curCount = 1;
            curNodeVal = val;
        }

        // 节点的数量关系
        if (curCount==maxCount){
            ans.add(curNodeVal);
        }else if (curCount>maxCount){
            maxCount = curCount;
            ans.clear();
            ans.add(curNodeVal);
        }
    }
}
