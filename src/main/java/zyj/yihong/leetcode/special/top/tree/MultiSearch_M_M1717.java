package zyj.yihong.leetcode.special.top.tree;

import java.util.*;

/**
 * 面试题 17.17. 多次搜索
 * 参考实现：https://leetcode.cn/problems/multi-search-lcci/solution/mian-shi-ti-1717-duo-ci-sou-suo-python-j-61is/
 * 细节点：
 *      1、前缀树end特殊处理，存储字符串
 *      2、将smalles中保存至树中
 *      3、遍历每一个起始index到big.length，在trie搜索
 *
 */
public class MultiSearch_M_M1717 {
    public int[][] multiSearch(String big, String[] smalls) {
        MultiSearchInnerTrie trie = new MultiSearchInnerTrie();
        trie.addWords(smalls);
        //map保存： smalls中的值存在与 big index start的起始数组
        Map<String,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < big.length(); i++) {
            String curSubBig = big.substring(i);
            List<String> searchList = trie.search(curSubBig);
            for (String small : searchList) {
                List<Integer> smallStartIndexList = map.get(small)==null?new ArrayList<>():map.get(small);
                smallStartIndexList.add(i);
                map.put(small,smallStartIndexList);
            }
        }

        int[][] ans = new int[smalls.length][];
        for (int i = 0; i < smalls.length; i++) {
            String small = smalls[i];
            List<Integer> curSmallAns = map.get(small);
            if (curSmallAns==null||curSmallAns.size()==0){
                ans[i] = new int[0];
            }else {
                ans[i] = new int[curSmallAns.size()];
                for (int i1 = 0; i1 < curSmallAns.size(); i1++) {
                    ans[i][i1] = curSmallAns.get(i1);
                }
            }
        }
        return ans;
    }

    static class MultiSearchInnerTrie{
        public String end;
        public MultiSearchInnerTrie[] sonTrie;

        public MultiSearchInnerTrie() {
            sonTrie = new MultiSearchInnerTrie[26];
        }

        public void addWords(String[] words){
            for (String word : words) {
                MultiSearchInnerTrie curNode = this;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (curNode.sonTrie[c-'a']==null){
                        curNode.sonTrie[c-'a'] = new MultiSearchInnerTrie();
                    }
                    curNode = curNode.sonTrie[c-'a'];
                }
                curNode.end = word;
            }
        }

        // 查找字典树中存在多个字是属于key中
        public List<String> search(String key){
            MultiSearchInnerTrie curNode = this;
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                if (curNode.sonTrie[c-'a']!=null){
                    curNode = curNode.sonTrie[c-'a'];
                    if (curNode.end!=null){
                        ans.add(curNode.end);
                    }
                    continue;
                }
                break;
            }
            return ans;
        }
    }
}
