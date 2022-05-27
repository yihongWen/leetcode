package zyj.yihong.leetcode.mid.arr;

/**
 * 面试题 17.11. 单词距离
 * 有个内含单词的超大文本文件，给定任意两个不同的单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-closest-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindClosest_M17_11 {
    public int findClosest(String[] words, String word1, String word2) {
        int word1Index = -1;
        int word2Index = -1;
        int bestAns = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.equals(word1)){
                word1Index = i;
            }else if (word.equals(word2)){
                word2Index = i;
            }

            // 判断当前距离
            if (word1Index>=0&&word2Index>=0){
                bestAns = Math.min(bestAns,Math.abs(word1Index-word2Index));
            }
        }

        return bestAns;
    }
}
