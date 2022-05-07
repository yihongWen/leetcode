package zyj.yihong.leetcode.mid.graph;

import java.util.*;

/**
 * 433. 最小基因变化
 * 基因序列可以表示为一条由 8 个字符组成的字符串，其中每个字符都是 'A'、'C'、'G' 和 'T' 之一。
 *
 * 假设我们需要调查从基因序列 start 变为 end 所发生的基因变化。一次基因变化就意味着这个基因序列中的一个字符发生了变化。
 *
 * 例如，"AACCGGTT" --> "AACCGGTA" 就是一次基因变化。
 * 另有一个基因库 bank 记录了所有有效的基因变化，只有基因库中的基因才是有效的基因序列。
 *
 * 给你两个基因序列 start 和 end ，以及一个基因库 bank ，请你找出并返回能够使 start 变化为 end 所需的最少变化次数。如果无法完成此基因变化，返回 -1 。
 *
 * 注意：起始基因序列 start 默认是有效的，但是它并不一定会出现在基因库中。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-genetic-mutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinMutation433 {
    public int minMutation(String start, String end, String[] bank) {
        // 使用广度优先搜索：
        // 特殊情况判断，如果start直接等于end
        if (start.equals(end)){
            return 0;
        }

        // 为了方便判断，定义set
        Set<String> startTranMidSet = new HashSet<>();
        Set<String> bankSet = new HashSet<>(bank.length);
        char[] geneSign = {'A','C','G','T'};
        bankSet.addAll(Arrays.asList(bank));


        // 如果start不等与end，并且end不在bank中，直接返回-1
        if (!bankSet.contains(end)){
            return -1;
        }

        // 搜索
        int step = 1;
        Queue<String> queue =  new LinkedList<>();
        queue.add(start);
        startTranMidSet.add(start);

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curGene = queue.poll();
                for (int j = 0; j < curGene.length(); j++) {
                    for (int k = 0; k < 4; k++) {
                        // 生成新的基因序列
                        if (curGene.charAt(j)!=geneSign[k]){
                            StringBuilder nextGene = new StringBuilder(curGene);
                            nextGene.setCharAt(j,geneSign[k]);
                            String nextGeneString = nextGene.toString();

                            if (nextGeneString.equals(end)){
                                return step;
                            }

                            // 判断生成的gene，是否已经搜索过，是否在bank里
                            if (!startTranMidSet.contains(nextGeneString))
                                if (bankSet.contains(nextGeneString)) {
                                    queue.add(nextGeneString);
                                    startTranMidSet.add(nextGeneString);
                                }
                        }

                    }
                }
            }
            step++;
        }

        return -1;
    }
}
