package zyj.yihong.datastruct.link;

import java.util.*;

public class Skiplist {


    // 定义头尾节点、链表的当前的最大level、size
    public Node head, tail;
    public int size, maxLevel;
    private final Random random =new Random();

    // 初始化
    public Skiplist() {
        Node head = new Node(0, -1);
        Node end = new Node(0, 1);
        head.right = end;
        end.left = head;
        this.head = head;
        this.tail = end;
        this.maxLevel = 1;
        this.size = 0;
    }

    // 添加层级
    public void addLevel() {
        Node curLevelHead = new Node(0, -1);
        Node curLevelEnd = new Node(0, 1);

        curLevelHead.down = head;
        curLevelHead.right = curLevelEnd;
        curLevelEnd.down = tail;
        curLevelEnd.left = curLevelHead;
        head.up = curLevelHead;
        tail.up = curLevelEnd;

        head = curLevelHead;
        tail = curLevelEnd;
        maxLevel++;
    }


    public Node searchLessAndEqual(int key) {
        Node x = this.head;
        for (int y = this.maxLevel; y > 0; y--) {
            while (x.right.mark != 1 && x.right.value <= key) {
                x = x.right;
            }
            if (x.down != null) {
                x = x.down;
                continue;
            }
            break;
        }
        return x;
    }


    public void insert(int value) {

        Node newEntry = new Node(value);
        Node current = searchLessAndEqual(value);
        int stackHeight;


        newEntry.left = current;
        newEntry.right = current.right;
        current.right = newEntry;
        newEntry.right.left = newEntry;

        stackHeight = 1;
        while ((random.nextInt() % 2) == 1) {

            // 如果超过当前最大层，则添加新的一层
            if (stackHeight >= this.maxLevel) {
                this.addLevel();
            }

            // 查询上一层的左侧节点，也就是当前的插入节点的所在层的左节点
            while (current.up == null) {
                current = current.left;
            }

            // 进入到上一层
            current = current.up;

            // 在进入的当前层添加节点
            Node levelUp = new Node(value);
            levelUp.left = current;
            levelUp.right = current.right;
            current.right.left = levelUp;
            current.right = levelUp;

            // 设置插入节点的上下关系
            levelUp.down = newEntry;
            newEntry.up = levelUp;

            newEntry = levelUp;

            stackHeight++;
        }

        // Update logic markers
        this.size++;

        // 是否突破了最大的层次
        if (stackHeight > this.maxLevel) {
            this.maxLevel = stackHeight;
        }
    }


    public boolean delete(int key) {
        Node current = searchLessAndEqual(key);
        if ( current.mark == -1 || current.value != key){
            return false;
        }

        if (current.value == key) {
            while (current != null) {
                current.left.right = current.right;
                current.right.left = current.left;
                current = current.up;
            }
            this.size--;
        }

        return true;
    }


    public boolean search(int target) {
        Node node = searchLessAndEqual(target);
        return node.mark != -1 && node.value == target;
    }

    public void add(int num) {
        insert(num);
    }

    public boolean erase(int num) {
        return  delete(num);
    }


    public static class Node {

        public long value;
        public Node left;
        public Node right;
        public Node up;
        public Node down;
        // -1 head  1 end 0
        public int mark;

        public Node(long value, int mark) {
            this.left = null;
            this.right = null;
            this.up = null;
            this.down = null;
            this.value = value;
            this.mark = mark;
        }

        public Node(long value) {
            this.left = null;
            this.right = null;
            this.up = null;
            this.down = null;
            this.value = value;
            this.mark = 0;
        }
    }


    public static void main(String[] args) {
        Skiplist skiplist = new Skiplist();
        Random random1 = new Random();
        Set<Integer> set = new HashSet<>();
        List<Boolean> ans = new ArrayList<>();
        List<Boolean> skipAns = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int value = random1.nextInt(30);
            int opt = random1.nextInt(30);

            if (opt<10){
                boolean search = skiplist.search(value);
            }else if (opt>=10&&opt<20){
                skiplist.add(value);
            }else {
                boolean erase = skiplist.erase(value);
            }
        }
    }
}
