package zyj.yihong.leetcode.mid.tree;

/**
 * 208. 实现 Trie (前缀树)
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 * <p>
 * 请你实现 Trie 类：
 * <p>
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Trie {
    // 定义字典树的数据结构，子节点，为26位字母;
    private Trie[] son;

    // 如果是true,表示字典树中存在当前存在的字符
    private boolean isMaxDepth;

    public Trie() {
        son = new Trie[26];
        isMaxDepth = false;
    }

    public void insert(String word) {
        // 获取根节点
        Trie curNode = this;

        // 遍历插入char,插入树的第i层
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            Trie trie = curNode.son[index];
            if (trie==null){
                curNode.son[index] = new Trie();
            }
            curNode = curNode.son[index];
        }
        curNode.isMaxDepth = true;

    }

    public boolean search(String word) {
        Trie trie = queryLastNode(word);
        if (trie!=null&& trie.isMaxDepth){
            return true;
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        Trie trie = queryLastNode(prefix);
        return trie!=null;
    }

    // 查询某个字符串
    private Trie queryLastNode(String s){
        // 获取根节点作为当前节点
        Trie curNode = this;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            // 当前不存在的情况直接返回空
            if (curNode.son[index]==null){
                return null;
            }
            curNode = curNode.son[index];
        }

        return curNode;
    }

    public static void main(String[] args) {
//        ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
//[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");
    }
}
