package zyj.yihong.datastruct.link;

import lombok.Data;

import java.util.Random;

/**
 * 跳表的实现
 */
public class MySkipList {

    private ListNode maxLevelListNode = new ListNode(1);
    private Random random = new Random();


    private void addLevelListNode(int curMaxLevel){
        ListNode listNode = new ListNode(curMaxLevel + 1);
        listNode.head.down = maxLevelListNode.head;
        listNode.tail.down = maxLevelListNode.tail;
        maxLevelListNode.head.up = listNode.head;
        maxLevelListNode.tail.up = listNode.tail;
        maxLevelListNode = listNode;
    }

    // 搜索某个值
    private Node search(int sValue,boolean pre){
        Node cur = maxLevelListNode.getHead();
        // 每层遍历
        for (int level = maxLevelListNode.level; level >0 ; level--) {

            while (cur.right.value!=maxLevelListNode.tail.value&&cur.right.value<=sValue){
                cur = cur.right;
            }

            if (cur.down!=null){
                cur=cur.down;
            }
        }
        if (pre){
            return cur;
        }

        return cur.value==sValue?cur:null;
    }

    private void insert(int value){
        Node search = search(value,true);
        if (search.value==value){
            return;
        }

        // 处理指针指向
        Node addNode = new Node(value);
        addNode.left = search;
        addNode.right = search.right;
        search.right = addNode;
        addNode.right.left = addNode;

        // 判断当前节点是否需要往上层添加
        int curLevel = 1;
        int i = random.nextInt() & 1;
        System.out.println("value:"+value);
        while (i==0){
            System.out.println("i:"+i);
            i = random.nextInt() & 1;
            if (curLevel>= maxLevelListNode.getLevel()){
                this.addLevelListNode(this.maxLevelListNode.getLevel());
            }

            // 判断当前层的up是否存在，不存在则往左边移动
            while (search.up==null&&search.value!=Integer.MIN_VALUE){
                search = search.left;
            }

            search = search.up;

            // 处理上一层
            Node upLevelAddNode = new Node(value);
            upLevelAddNode.left= search;
            upLevelAddNode.right = search.right;
            search.right = upLevelAddNode;
            upLevelAddNode.right.left = upLevelAddNode;
            upLevelAddNode.down = addNode;
            addNode.up = upLevelAddNode;

            addNode = upLevelAddNode;
            curLevel++;
        }
    }


    private void delete(int value){
        Node search = this.search(value, false);
        if (search==null){
            System.out.println("删除value不存在："+value);
            return;
        }
        while (search!=null){
            search.left.right = search.right;
            search.right.left = search.left;
            search = search.up;
        }
    }


    // 跳表的每个节点的结构
    @Data
    static class Node{
        private Node left;
        private Node right;
        private Node up;
        private Node down;
        private int value;

        public Node(int value) {
            this.value = value;
        }
    }


    // 跳表的每一层结构
    @Data
    static class ListNode{
        private Node head;
        private Node tail;
        private int level;

        public ListNode(int level) {
            this.level = level;
            head = new Node(Integer.MIN_VALUE);
            tail = new Node(Integer.MAX_VALUE);
            head.right = tail;
            tail.left = head;
        }
    }


    public static void main(String[] args) {
        MySkipList mySkipList = new MySkipList();
        mySkipList.insert(10);
        mySkipList.insert(9);
        mySkipList.insert(18);
        mySkipList.insert(37);
        Node search = mySkipList.search(8, false);
        System.out.println(search==null?null:search.value);
        Node search1 = mySkipList.search(18, false);
        System.out.println(search1==null?null:search1.value);
        mySkipList.delete(10);
        mySkipList.delete(18);

        Node search2 = mySkipList.search(18, false);
        System.out.println(search2==null?null:search2.value);
    }
}
