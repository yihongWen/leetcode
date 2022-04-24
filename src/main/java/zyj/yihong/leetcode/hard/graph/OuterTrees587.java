package zyj.yihong.leetcode.hard.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 587. 安装栅栏
 * 在一个二维的花园中，有一些用 (x, y) 坐标表示的树。由于安装费用十分昂贵，你的任务是先用最短的绳子围起所有的树。只有当所有的树都被绳子包围时，花园才能围好栅栏。你需要找到正好位于栅栏边界上的树的坐标。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/erect-the-fence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OuterTrees587 {
    // Jarvis 算法
    public int[][] outerTrees(int[][] trees) {
        // 如果少于四个点，那么直接返回，三点成面
        if (trees.length <= 3) {
            return trees;
        }

        // 定义返回结果、以及被标记过的点
        List<int[]> ans = new ArrayList<>();
        boolean[] visited = new boolean[trees.length];

        // 计算出最左侧点的
        int leftNode = 0;
        for (int i = 1; i < trees.length; i++) {
            if (trees[leftNode][0] < trees[i][0]) {
                leftNode = i;
            }
        }

        // 计算每一个需要包含进来的点
        int cur = leftNode;
        while (true) {

            // 以当前点为起点p，寻找所有点q,使得pq满足所有的点r, pr在pq的左上方
            int q = (cur + 1) % trees.length;
            for (int i = 0; i < trees.length; i++) {
                if (calVectorCross(trees[cur], trees[q], trees[i]) < 0) {
                    q = i;
                }
            }

            // 如果是在同一条直线上，也需要包含进来
            for (int i = 0; i < trees.length; i++) {
                if (visited[i] || i == cur || i == q) {
                    continue;
                }
                if (calVectorCross(trees[cur], trees[q], trees[i]) == 0) {
                    visited[i] = true;
                    ans.add(trees[i]);
                }
            }
            if (!visited[q]) {
                ans.add(trees[q]);
                visited[q] = true;
            }

            cur = q;
            // 如果当前的点跟最左侧的点重合
            if (cur == leftNode) {
                break;
            }
        }
        return ans.toArray(new int[][]{});
    }

    // 计算两个向量的叉积，判断两个向量的大角度
    private int calVectorCross(int[] p, int[] q, int[] r) {
        return (q[0] - p[0]) * (r[1] - q[1]) - (q[1] - p[1]) * (r[0] - q[0]);
    }
}
