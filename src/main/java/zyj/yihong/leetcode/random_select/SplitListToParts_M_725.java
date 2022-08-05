package zyj.yihong.leetcode.random_select;

import zyj.yihong.leetcode.utils.ListNode;

import java.util.List;

/**
 * 725. 分隔链表
 */
public class SplitListToParts_M_725 {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        // 遍历链表计算出链表的长度
        ListNode curNode = head;
        int size = 0;
        while (curNode!=null){
            size++;
            curNode = curNode.next;
        }
        int everyCount = size/k;
        int m = size%k;

        curNode = head;
        for (int i = 0; i < k; i++) {
            int curCount = everyCount+ (i<m?1:0);
            ans[i] = curNode;
            while (curCount>0){
                if (curCount==1){
                    ListNode next = curNode.next;
                    curNode.next=null;
                    curNode = next;
                }else {
                    curNode = curNode.next;
                }
                curCount--;
            }
        }
        return ans;
    }
}
