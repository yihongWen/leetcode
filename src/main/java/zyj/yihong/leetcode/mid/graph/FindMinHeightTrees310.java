package zyj.yihong.leetcode.mid.graph;

import java.util.*;

/**
 * 310. 最小高度树
 * 树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。
 * <p>
 * 给你一棵包含 n 个节点的树，标记为 0 到 n - 1 。给定数字 n 和一个有 n - 1 条无向边的 edges 列表（每一个边都是一对标签），其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条无向边。
 * <p>
 * 可选择树中任何一个节点作为根。当选择节点 x 作为根节点时，设结果树的高度为 h 。在所有可能的树中，具有最小高度的树（即，min(h)）被称为 最小高度树 。
 * <p>
 * 请你找到所有的 最小高度树 并按 任意顺序 返回它们的根节点标签列表。
 * <p>
 * 树的 高度 是指根节点和叶子节点之间最长向下路径上边的数量。
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-height-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMinHeightTrees310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();

        // 构图
        List<Integer>[] graphInfo = new List[n];
        for (int i = 0; i < graphInfo.length; i++) {
            graphInfo[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graphInfo[edge[0]].add(edge[1]);
            graphInfo[edge[1]].add(edge[0]);
        }

        // 定义逆向指针数组,初始化都为根
        int[] parent = new int[n];

        // 选择任意一个节点找到距离当前节点最深节点
        int maxDeep1 = findMaxDeep(0, parent, graphInfo);
        Arrays.fill(parent, -1);
        int maxDeep2 = findMaxDeep(maxDeep1, parent, graphInfo);


        // 找出两个点的距离长度dis，如果dis为偶数 则两个值，奇数为一个
        List<Integer> passValueInMaxLength = new ArrayList<>();
        parent[maxDeep1] = -1;
        while (parent[maxDeep2] != -1) {
            passValueInMaxLength.add(maxDeep2);
            maxDeep2 = parent[maxDeep2];
        }
        passValueInMaxLength.add(maxDeep2);

        if (passValueInMaxLength.size() % 2 == 0) {
            ans.add(passValueInMaxLength.get(passValueInMaxLength.size() / 2 - 1));
        }
        ans.add(passValueInMaxLength.get(passValueInMaxLength.size() / 2));
        return ans;

    }

    private int findMaxDeep(int value, int[] parent, List<Integer>[] graphInfo) {
        // 广度优先搜索，找出最大长度
        // 定义queue、visited
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[parent.length];
        queue.add(value);
        int maxLengthValue = value;

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            maxLengthValue = poll;
            List<Integer> curNextList = graphInfo[poll];
            for (Integer next : curNextList) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[poll] = true;
                    parent[next] = poll;
                }
            }
        }
        return maxLengthValue;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] edge = {{1, 0}, {1, 2}, {1, 3}};
        FindMinHeightTrees310 findMinHeightTrees310 = new FindMinHeightTrees310();
        List<Integer> minHeightTrees = findMinHeightTrees310.findMinHeightTrees(n, edge);
        System.out.println(minHeightTrees);
    }
}
