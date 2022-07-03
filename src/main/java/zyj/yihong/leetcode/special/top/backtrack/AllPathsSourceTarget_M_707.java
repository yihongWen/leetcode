package zyj.yihong.leetcode.special.top.backtrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 797. 所有可能的路径
 * 使用深度优先搜索（遇到当前节点，则对当前节点的联通节点依次处理）
 * 由于题目条件约束，并不会形成环，所以不需要对访问过的数据进行标记
 *
 * 对于路径信息，使用栈或者双端队列都可以来保存
 */
public class AllPathsSourceTarget_M_707 {
    private List<List<Integer>> ans = new ArrayList<>();
    private ArrayDeque<Integer> pathDeque = new ArrayDeque<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        pathDeque.add(0);
        backtrack(graph,0);
        return ans;
    }

    private void backtrack(int[][]graph,int curNum){
        //结束条件，当前的数值为n-1时，数据链路是通的
        if (curNum==graph.length-1){
            // 保存结果
            ans.add(new ArrayList<>(pathDeque));
        }

        int[] curPath = graph[curNum];
        for (int nextNode : curPath) {
            pathDeque.add(nextNode);
            backtrack(graph,nextNode);
            pathDeque.removeLast();
        }
    }
}
