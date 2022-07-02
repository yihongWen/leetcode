package zyj.yihong.leetcode.special.top.tree;

/**
 * 字典树的实现：
 */
public class Trie {
    public Trie[] sonTrie;
    public boolean isEnd;
    public Trie() {
        sonTrie = new Trie[26];
        isEnd = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie curNode = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curNode.sonTrie[c-'a']==null){
                curNode.sonTrie[c-'a'] = new Trie();
            }
            curNode = curNode.sonTrie[c-'a'];
        }
        curNode.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie curNode = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curNode.sonTrie[c-'a']!=null){
                curNode = curNode.sonTrie[c-'a'];
                continue;
            }
            return false;
        }
        return curNode.isEnd;

    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie curNode = this;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (curNode.sonTrie[c-'a']!=null){
                curNode = curNode.sonTrie[c-'a'];
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
//        ["Trie","insert","insert","insert","insert","insert","insert",
//        "search","search","search","search","search","search","search","search","search","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith"]
//[[],["app"],["apple"],["beer"],["add"],["jam"],["rental"],
// ["apps"],["app"],["ad"],["applepie"],["rest"],["jan"],["rent"],["beer"],["jam"],["apps"],["app"],["ad"],["applepie"],["rest"],["jan"],["rent"],["beer"],["jam"]]

        trie.insert("app");
        trie.insert("apple");
        trie.insert("beer");
        trie.insert("add");
        trie.insert("jam");
        trie.insert("rental");
//        [null,null,null,null,null,null,null,false,false,false,false,false,false,false,true,true,false,false,true,false,false,false,true,true,true]
//        [null,null,null,null,null,null,null,false,true,false,false,false,false,false,true,true,false,true,true,false,false,false,true,true,true]
        trie.search("apps");
        System.out.println(trie.search("app"));
//        trie.search("ad");
//        trie.search("applepie");
//        trie.search("rest");
//        trie.search("jan");
//        trie.search("rent");
//        trie.search("beer");
//        trie.search("jam");



    }
}
