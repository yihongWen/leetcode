package zyj.yihong.leetcode.special.top.tree;

import java.util.Arrays;
import java.util.List;

/**
 * 648. 单词替换
 */
public class ReplaceWords_M_648 {
    public String replaceWords(List<String> dictionary, String sentence) {
        InnerTrie trie = new InnerTrie();
        for (String root : dictionary) {
            trie.insert(root);
        }
        String[] sentenceWordArr = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String sentenceWord : sentenceWordArr) {
            InnerTrie curNode = trie;
            boolean handle = false;
            for (int i = 0; i < sentenceWord.length(); i++) {
                char c = sentenceWord.charAt(i);
                if (curNode.sonTrie[c-'a']!=null){
                    if (curNode.sonTrie[c-'a'].isEnd){
                        sb.append(sentenceWord.substring(0,i+1));
                        sb.append(" ");
                        handle = true;
                        break;
                    }
                    curNode = curNode.sonTrie[c-'a'];
                    continue;
                }
                break;
            }
            if (!handle){
                sb.append(sentenceWord);
                sb.append(" ");
            }
        }
        return sb.substring(0,sb.length()-1);

    }

    static class InnerTrie{
        public InnerTrie[] sonTrie;
        public boolean isEnd;
        public InnerTrie() {
            sonTrie = new InnerTrie[26];
            isEnd = false;
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            InnerTrie curNode = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (curNode.sonTrie[c-'a']==null){
                    curNode.sonTrie[c-'a'] = new InnerTrie();
                }
                curNode = curNode.sonTrie[c-'a'];
            }
            curNode.isEnd = true;
        }
    }

    public static void main(String[] args) {
//        dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"

//        ["a", "aa", "aaa", "aaaa"]
//"a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"
        ReplaceWords_M_648 replaceWords648 = new ReplaceWords_M_648();
        String s = replaceWords648.replaceWords(Arrays.asList("a","aa", "aaa", "aaaa"), "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa");
        System.out.println(s);
    }
}
