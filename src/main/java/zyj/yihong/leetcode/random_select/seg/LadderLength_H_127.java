package zyj.yihong.leetcode.random_select.seg;

import javax.script.AbstractScriptEngine;
import java.util.*;

// 127. 单词接龙
public class LadderLength_H_127 {

    private List<List<Integer>> graph = new ArrayList<>();
    private int nodeWordId = 0;
    private Map<String,Integer> map = new HashMap<>();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 构图
        for (String word : wordList) {
            addWordToGraph(word);
        }

        // 将起始节点也加入
        addWordToGraph(beginWord);

        if (!map.containsKey(endWord)){
            return -1;
        }

        // 开始双端bfd
        // 定义访问标记
        Queue<Integer> startQueue = new LinkedList<>();
        int[] startDistance = new int[nodeWordId];
        startQueue.add(map.get(beginWord));
        Arrays.fill(startDistance,Integer.MAX_VALUE);
        startDistance[map.get(beginWord)] = 0;

        Queue<Integer> endQueue = new LinkedList<>();
        int[] endDistance = new int[nodeWordId];
        endQueue.add(map.get(endWord));
        Arrays.fill(endDistance,Integer.MAX_VALUE);
        endDistance[map.get(endWord)] = 0;

        while (endQueue.size()!=0 && startQueue.size()!=0){
            int size = endQueue.size();
            for (int i = 0; i < size; i++) {
                Integer node = endQueue.poll();
                // 在另一端是否已经处理过
                if (startDistance[node]!=Integer.MAX_VALUE){
                    return (startDistance[node]+endDistance[node])/2+1;
                }
                
                // 搜索
                for (Integer conNode : graph.get(node)) {
                    if (endDistance[conNode]==Integer.MAX_VALUE){
                        endDistance[conNode] = endDistance[node]+1;
                        endQueue.add(conNode);
                    }
                }
            }


            size = startQueue.size();
            for (int i = 0; i < size; i++) {
                Integer node = startQueue.poll();
                // 在另一端是否已经处理过
                if (endDistance[node]!=Integer.MAX_VALUE){
                    return (startDistance[node]+endDistance[node])/2+1;
                }

                // 搜索
                for (Integer conNode : graph.get(node)) {
                    if (startDistance[conNode]==Integer.MAX_VALUE){
                        startDistance[conNode] = startDistance[node]+1;
                        startQueue.add(conNode);
                    }
                }
            }
        }
        return 0;
    }

    private void addWordToGraph(String word){
        // 将当前的word添加到map中
        Integer wordId = handleWordId(word);
        char[] wordChar = word.toCharArray();

        for (int i = 0; i < word.length(); i++) {
            char temp = wordChar[i];
            wordChar[i] = '*';
            Integer conWordId = handleWordId(new String(wordChar));
            graph.get(wordId).add(conWordId);
            graph.get(conWordId).add(wordId);
            wordChar[i] = temp;
        }

    }

    private Integer handleWordId(String word){
        if (!map.containsKey(word)){
            map.put(word,nodeWordId);

            // 相当于初始化当前节点的邻接链表
            graph.add(new ArrayList<>());
            nodeWordId++;
        }
        return map.get(word);
    }

    public static void main(String[] args) {
        LadderLength_H_127 ladderLength_h_127 = new LadderLength_H_127();
        String start = "hit";
        String end = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        int ans = ladderLength_h_127.ladderLength(start, end, wordList);
        System.out.println(ans);

        Solution solution = new Solution();
        int ans1 = solution.ladderLength(start, end, wordList);
        System.out.println(ans1);

    }


    static class Solution {
        Map<String, Integer> wordId = new HashMap<String, Integer>();
        List<List<Integer>> edge = new ArrayList<List<Integer>>();
        int nodeNum = 0;

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            for (String word : wordList) {
                addEdge(word);
            }
            addEdge(beginWord);
            if (!wordId.containsKey(endWord)) {
                return 0;
            }

            int[] disBegin = new int[nodeNum];
            Arrays.fill(disBegin, Integer.MAX_VALUE);
            int beginId = wordId.get(beginWord);
            disBegin[beginId] = 0;
            Queue<Integer> queBegin = new LinkedList<Integer>();
            queBegin.offer(beginId);

            int[] disEnd = new int[nodeNum];
            Arrays.fill(disEnd, Integer.MAX_VALUE);
            int endId = wordId.get(endWord);
            disEnd[endId] = 0;
            Queue<Integer> queEnd = new LinkedList<Integer>();
            queEnd.offer(endId);

            while (!queBegin.isEmpty() && !queEnd.isEmpty()) {
                int queBeginSize = queBegin.size();
                for (int i = 0; i < queBeginSize; ++i) {
                    int nodeBegin = queBegin.poll();
                    if (disEnd[nodeBegin] != Integer.MAX_VALUE) {
                        return (disBegin[nodeBegin] + disEnd[nodeBegin]) / 2 + 1;
                    }
                    for (int it : edge.get(nodeBegin)) {
                        if (disBegin[it] == Integer.MAX_VALUE) {
                            disBegin[it] = disBegin[nodeBegin] + 1;
                            queBegin.offer(it);
                        }
                    }
                }

                int queEndSize = queEnd.size();
                for (int i = 0; i < queEndSize; ++i) {
                    int nodeEnd = queEnd.poll();
                    if (disBegin[nodeEnd] != Integer.MAX_VALUE) {
                        return (disBegin[nodeEnd] + disEnd[nodeEnd]) / 2 + 1;
                    }
                    for (int it : edge.get(nodeEnd)) {
                        if (disEnd[it] == Integer.MAX_VALUE) {
                            disEnd[it] = disEnd[nodeEnd] + 1;
                            queEnd.offer(it);
                        }
                    }
                }
            }
            return 0;
        }

        public void addEdge(String word) {
            addWord(word);
            int id1 = wordId.get(word);
            char[] array = word.toCharArray();
            int length = array.length;
            for (int i = 0; i < length; ++i) {
                char tmp = array[i];
                array[i] = '*';
                String newWord = new String(array);
                addWord(newWord);
                int id2 = wordId.get(newWord);
                edge.get(id1).add(id2);
                edge.get(id2).add(id1);
                array[i] = tmp;
            }
        }

        public void addWord(String word) {
            if (!wordId.containsKey(word)) {
                wordId.put(word, nodeNum++);
                edge.add(new ArrayList<Integer>());
            }
        }
    }

}
