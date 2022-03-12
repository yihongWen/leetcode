package zyj.yihong.leetcode.simple.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 2049. 统计最高分的节点数目
 *
 * 深度优先遍历，每个点最多只可能拆成3个树
 *
 */
public class CountHighestScoreNodes2049 {
    // 定义最佳的分数、个数
    long maxScore = 0L;
    int maxScoreCount = 0;
    int length;

    // 定义每个节点存在的子节点，用于遍历
    List<Integer>[] sonNodeOfNode;

    public int countHighestScoreNodes(int[] parents) {
        // 初始化 计算每个节点的子节点
        length = parents.length;
        sonNodeOfNode = new List[length];
        for (int i = 0; i < length; i++) {
            sonNodeOfNode[i] = new ArrayList<>();
        }

        for (int i = 0; i < length; i++) {
            int parent = parents[i];

            // 根节点的父节点跳过
            if (parent!=-1){
                sonNodeOfNode[parent].add(i);
            }
        }

        dfs(0);
        return maxScoreCount;

    }


    /**
     * dfs 返回当前节点作为子树的个数
     * @param node
     * @return
     */
    public int dfs(int node) {
        long curScore = 1L;
        // 除去当前的点
        int curSize = length-1;

        // 遍历当前node的子节点
        for (Integer reNode : sonNodeOfNode[node]) {
            int sonCount = dfs(reNode);
            curScore *= sonCount;
            curSize -=sonCount;
        }

        // 如果不是根节点
        if (node!=0){
            curScore *= curSize;
        }

        // 判断当前得分是否是最佳
        if (curScore==maxScore){
            maxScoreCount++;
        }else if (curScore>maxScore){
            maxScore = curScore;
            maxScoreCount = 1;
        }

        return length-curSize;

    }

    public static void main(String[] args) {
        int[] test = {-1,2,0,2,0};
        CountHighestScoreNodes2049 countHighestScoreNodes2049 = new CountHighestScoreNodes2049();
        int highestScoreNodes = countHighestScoreNodes2049.countHighestScoreNodes(test);
        System.out.println(highestScoreNodes);
    }

}
