package zyj.yihong.leetcode.random_select;

import zyj.yihong.leetcode.utils.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 给你一个单链表，随机选择链表的一个节点，并返回相应的节点值。每个节点 被选中的概率一样 。
 * 382. 链表随机节点
 */
public class Solution_M_382 {
    private Random random;
    private List<Integer> nodeIndexValueList;
    public Solution_M_382(ListNode head) {
        random = new Random();
        ListNode cur = head;
        nodeIndexValueList = new ArrayList<>();
        while (cur!=null){
            nodeIndexValueList.add(cur.val);
            cur = cur.next;
        }
    }

    public int getRandom() {
        int index = random.nextInt(nodeIndexValueList.size());
        return nodeIndexValueList.get(index);
    }
}
