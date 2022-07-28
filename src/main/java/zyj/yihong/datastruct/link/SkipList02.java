package zyj.yihong.datastruct.link;

import java.util.Random;

/**
 * 链表的简单实现：参考https://leetcode.cn/problems/design-skiplist/solution/by-ac_oier-38rd/
 */
public class SkipList02 {
    //  参考https://leetcode.cn/problems/design-skiplist/solution/by-ac_oier-38rd/
    // 为了数据分布保证在log(n)查询，根据数据量来定义level
    int level = 10;
    Random random = new Random();
    Node head = new Node(-1);

    // 查询每一层比当前值t小的值（最大的）
    Node[] findLessEveryNode(int t) {
        Node[] nodes = new Node[level];
        Node cur = head;
        for (int i = level - 1; i >= 0; i--) {
            while (cur.nodeLevelNextNodeArr[i] != null && cur.nodeLevelNextNodeArr[i].val < t) {
                cur = cur.nodeLevelNextNodeArr[i];
            }
            nodes[i] = cur;
        }
        return nodes;
    }

    public boolean search(int t) {
        // 查询出每一层中比t小的值
        Node[] everyLevelLessNode = findLessEveryNode(t);
        // 判断最底层的next是否为t
        return everyLevelLessNode[0].nodeLevelNextNodeArr[0] != null && everyLevelLessNode[0].nodeLevelNextNodeArr[0].val == t;
    }

    public void add(int t) {
        Node[] everyLevelLessNode = findLessEveryNode(t);
        Node node = new Node(t);

        // 从0层开始往上添加，每往上添加一层的概率为1/2
        for (int i = 0; i < level; i++) {
            // 处理每层的node指向
            node.nodeLevelNextNodeArr[i] = everyLevelLessNode[i].nodeLevelNextNodeArr[i];
            everyLevelLessNode[i].nodeLevelNextNodeArr[i] = node;
            if (random.nextInt(2) == 0)
                break;
        }
    }

    public boolean erase(int t) {
        Node[] everyLevelLessNode = findLessEveryNode(t);
        Node node = everyLevelLessNode[0].nodeLevelNextNodeArr[0];
        // 判断t是否存在
        if (node == null || node.val != t)
            return false;

        // 删除每一层存在t
        for (int i = 0; i < level && everyLevelLessNode[i].nodeLevelNextNodeArr[i] == node; i++) {
            everyLevelLessNode[i].nodeLevelNextNodeArr[i] = everyLevelLessNode[i].nodeLevelNextNodeArr[i].nodeLevelNextNodeArr[i];
        }
        return true;
    }


    class Node {
        // 当前节点的值
        int val;

        // 当前节点每一次对应的next节点（当前节点在某一层可能为空）
        Node[] nodeLevelNextNodeArr = new Node[level];

        Node(int val) {
            this.val = val;
        }
    }


}
