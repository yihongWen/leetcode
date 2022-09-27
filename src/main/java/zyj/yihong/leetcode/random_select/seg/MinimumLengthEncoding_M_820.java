package zyj.yihong.leetcode.random_select.seg;

import java.util.HashMap;
import java.util.Map;

// 820. 单词的压缩编码
public class MinimumLengthEncoding_M_820 {
    private Map<TrieNode, Integer> map = new HashMap<>();

    public int minimumLengthEncoding(String[] words) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            TrieNode cur = root;
            String word = words[i];
            for (int r = word.length() - 1; r >= 0; r--) {
                cur = cur.addNode(word.charAt(r));
            }
            map.put(cur,i);
        }

        int ans = 0;
        for (Map.Entry<TrieNode, Integer> node : map.entrySet()) {
            TrieNode key = node.getKey();
            if (key.count==0){
                ans+=words[node.getValue()].length()+1;
            }
        }

        return ans;

    }


    static class TrieNode {
        // 字典树的子节点数组
        public TrieNode[] son;

        // 当前节点一共存在多少个子节点
        public int count;

        public TrieNode() {
            this.son = new TrieNode[26];
            this.count = 0;
        }

        public TrieNode addNode(char ch) {
            if (this.son[ch - 'a'] == null) {
                this.son[ch - 'a'] = new TrieNode();
                count++;
            }
            return this.son[ch - 'a'];
        }
    }
}
