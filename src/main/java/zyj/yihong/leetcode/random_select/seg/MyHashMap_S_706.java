package zyj.yihong.leetcode.random_select.seg;

import java.util.LinkedList;
import java.util.List;


// 706. 设计哈希映射
public class MyHashMap_S_706 {
    private int size = 100;
    private List<Node>[] v;
    public MyHashMap_S_706() {
        v= new List[size];
        for (int i = 0; i < size; i++) {
            v[i] = new LinkedList<>();
        }
    }

    public void put(int key, int value) {
        int index = getIndex(key);
        List<Node> curVList = v[index];
        Node handleNode = new Node();
        handleNode.key = key;
        handleNode.value = value;
        for (Node node : curVList) {
            if (handleNode.equals(node)){
                node.value = value;
                return;
            }
        }
        curVList.add(handleNode);

    }

    public int get(int key) {
        int index = getIndex(key);
        List<Node> curVList = v[index];
        Node handleNode = new Node();
        handleNode.key = key;
        for (Node node : curVList) {
            if (handleNode.equals(node)){
                return node.value;
            }
        }
        return -1;
    }

    public void remove(int key) {
        int index = getIndex(key);
        List<Node> curVList = v[index];
        Node handleNode = new Node();
        handleNode.key = key;
        curVList.remove(handleNode);
    }

    private int getIndex(int num){
        return num%size;
    }

    public static class Node{
        public int key;
        public int value;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            return key == node.key;
        }

        @Override
        public int hashCode() {
            return key;
        }
    }
}
