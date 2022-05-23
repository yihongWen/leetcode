package zyj.yihong.leetcode.mid.tree;

/**
 * 211. 添加与搜索单词 - 数据结构设计
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 *
 * 实现词典类 WordDictionary ：
 *
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
 *
 */
class WordDictionary211 {
    private Trie root;
    public WordDictionary211() {
        root = new Trie();
    }

    public void addWord(String word) {
        root.insert(word);
    }

    public boolean search(String word) {
        // 由于给定的单词可能出现. 代表任意字符，所以遇到时，需要分别对下一次所有的取值一次进行遍历
        Trie curNode = root;
        return dfs(word,0,curNode);

    }

    public boolean dfs(String word,int index,Trie curNode){
        // 遍历完字符中所有的字母，则返回当前节点是否为叶子节点
        if (word.length()==index){
            return curNode.isLeaf;
        }

        char c = word.charAt(index);
        int nodeIndex = c - 'a';
        if (Character.isLetter(c)){
            if (curNode.getChildren()[nodeIndex]!=null){
                 if (dfs(word,index+1,curNode.getChildren()[nodeIndex])){
                     return true;
                 }
            }
            return false;
        }else {
            for (int i = 0; i < 26; i++) {
                if (curNode.getChildren()[i]!=null){
                     if (dfs(word,index+1,curNode.getChildren()[i])){
                         return true;
                     }
                }
            }
            return false;
        }
    }

    class Trie{
        // 子节点
        private Trie[] children;

        //当前节点是否是叶子节点
        private boolean isLeaf;

        public Trie() {
            this.children = new Trie[26];
            this.isLeaf = false;
        }

        // 往字典树中插入word
        public void insert(String word){
            Trie curNode = this;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i)-'a';
                if (curNode.children[index]!=null){
                    curNode = curNode.children[index];
                    continue;
                }
                curNode.children[index] = new Trie();
                curNode = curNode.children[index];
            }

            // 处理完，将单词的最后一个字母对应的节点设置为叶子节点
            curNode.isLeaf = true;
        }

        public Trie[] getChildren() {
            return children;
        }

        public boolean isLeaf() {
            return isLeaf;
        }
    }

}
