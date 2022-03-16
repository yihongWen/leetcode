package zyj.yihong.leetcode.hard.link;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 432. 全 O(1) 的数据结构
 * 请你设计一个用于存储字符串计数的数据结构，并能够返回计数最小和最大的字符串。
 * <p>
 * 实现 AllOne 类：
 * <p>
 * AllOne() 初始化数据结构的对象。
 * inc(String key) 字符串 key 的计数增加 1 。如果数据结构中尚不存在 key ，那么插入计数为 1 的 key 。
 * dec(String key) 字符串 key 的计数减少 1 。如果 key 的计数在减少后为 0 ，那么需要将这个 key 从数据结构中删除。测试用例保证：在减少计数前，key 存在于数据结构中。
 * getMaxKey() 返回任意一个计数最大的字符串。如果没有元素存在，返回一个空字符串 "" 。
 * getMinKey() 返回任意一个计数最小的字符串。如果没有元素存在，返回一个空字符串 "" 。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-oone-data-structure
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class AllOne432 {

    private Node root;
    private Map<String, Node> nodeMap;

    /**
     * 使用Map+双向链表
     * 使用map可以快速找到某个字符对应的Node,双向链表适合对count进行加减操作（更换位置）
     */
    public AllOne432() {
        root = new Node("", 0);
        root.pre = root;
        root.next = root;
        nodeMap = new HashMap<>();
    }

    public void inc(String key) {
        // 判断map中是否存在
        Node node = nodeMap.get(key);
        if (node == null) {
            // 不存在，且链表为空,直接在最前面添加的情况
            if (root.next == root || root.next.count > 1) {
                Node addNode = new Node(key, 1);
                addNode.next = root.next;
                addNode.pre = root;
                root.next.pre = addNode;
                root.next = addNode;
                nodeMap.put(key, addNode);
            } else if (root.next.count == 1) {
                // 已经存在count相同的node,往当前node中add string
                root.next.stringSet.add(key);
                nodeMap.put(key, root.next);
            }
        } else {
            // node存在的情况：如果当前node的下一个节点count 是当前node的+1,则将当前node中的key移到下一个节点
            // 且判断当前节点是否只有一个key,如果只有一个则删除，如果下一个节点不是当前node+1,则新加一个node
            if (node.next == root || node.next.count > node.count + 1) {
                if (node.stringSet.size() == 1) {
                    node.count++;
                } else {
                    node.stringSet.remove(key);
                    Node addNode = new Node(key, node.count + 1);
                    addNode.next = node.next;
                    addNode.pre = node;
                    node.next.pre = addNode;
                    node.next = addNode;
                    nodeMap.put(key, addNode);
                }
            } else if (node.next.count == node.count + 1) {
                node.stringSet.remove(key);
                node.next.stringSet.add(key);
                nodeMap.put(key, node.next);
                if (node.stringSet.size() == 0) {
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                    node.pre = null;
                    node.next = null;
                }
            }
        }
    }

    public void dec(String key) {
        // 题目确保每次执行都存在找到key
        Node node = nodeMap.get(key);
        if (node.count == 1) {
            nodeMap.remove(key);
        } else {
            if (node.pre == root || node.pre.count + 1 < node.count) {
                // 需要新增一个count-1的node
                Node addNode = new Node(key, node.count - 1);
                addNode.pre = node.pre;
                addNode.next = node.pre.next;
                addNode.pre.next = addNode;
                addNode.next.pre = addNode;
                nodeMap.put(key, addNode);
            } else {
                node.pre.stringSet.add(key);
                nodeMap.put(key, node.pre);
            }
        }

        node.stringSet.remove(key);
        if(node.stringSet.size()==0){
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
}

    public String getMaxKey() {
        // 返回最后一个结果
        return root.pre != null ? root.pre.stringSet.iterator().next() : "";
    }

    public String getMinKey() {
        return root.next != null ? root.next.stringSet.iterator().next() : "";
    }

static class Node {
    public Node(String key, int count) {
        stringSet = new HashSet<>();
        stringSet.add(key);
        this.count = count;
    }

    public Node pre;
    public Node next;
    public Set<String> stringSet;
    public int count;
}


    public static void main(String[] args) {
        AllOne432 allOne432 = new AllOne432();
//["AllOne","inc","inc","inc","inc","inc","dec","dec","getMaxKey","getMinKey"]
//[[],["a"],["b"],["b"],["b"],["b"],["b"],["b"],[],[]]
        allOne432.inc("a");
        allOne432.inc("b");
        allOne432.inc("b");
        allOne432.inc("b");
        allOne432.inc("b");

        allOne432.dec("b");
        allOne432.dec("b");

        String maxKey = allOne432.getMaxKey();
        String minKey = allOne432.getMinKey();
        System.out.println(maxKey);
        System.out.println(minKey);

    }


}

