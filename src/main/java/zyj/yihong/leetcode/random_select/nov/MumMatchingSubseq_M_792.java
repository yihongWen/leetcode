package zyj.yihong.leetcode.random_select.nov;

import java.util.LinkedList;
import java.util.Queue;

// 792. 匹配子序列的单词数
public class MumMatchingSubseq_M_792 {
    public int numMatchingSubseq(String s, String[] words) {
        // 多指针。
        int ans = 0;
        Queue<Node>[] queues = new Queue[26];
        for (int i = 0; i < 26; i++) {
            queues[i] = new LinkedList<>();
        }

        for (int i = 0; i < words.length; i++) {
            int index = words[i].charAt(0) - 'a';
            Node node = new Node(i, 0);
            queues[index].offer(node);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Queue<Node> queue = queues[c - 'a'];
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                Node curNode = queue.poll();
                if (curNode.charIndexOfWord==words[curNode.wordIndex].length()-1){
                    ans++;
                    continue;
                }

                curNode.charIndexOfWord++;
                int addIndex = (words[curNode.wordIndex].charAt(curNode.charIndexOfWord)) - 'a';
                queues[addIndex].offer(curNode);
            }
        }
        return ans;
    }

    static class Node{
        public int wordIndex;
        public int charIndexOfWord;

        public Node(int wordIndex, int charIndexOfWord) {
            this.wordIndex = wordIndex;
            this.charIndexOfWord = charIndexOfWord;
        }
    }
}
