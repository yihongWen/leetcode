package zyj.yihong.leetcode.mid.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 210. 课程表 II
 * 现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
 *
 * 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
 * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindOrder210 {
    // 定义二维数组表示图
    List<List<Integer>> graphInfo = new ArrayList<>();

    // 定义结果数组
    int[] result;
    int resultIndex;

    // 定义当前课程的访问状态（未学习0，正在学习1、学习完成2）
    int[] state;

    // 定义当前的是否存在环的状态
    boolean curCircle = false;


    // 使用深度优先搜索
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 初始化图、结果集
        result = new int[numCourses];
        state = new int[numCourses];
        resultIndex = numCourses-1;
        for (int i = 0; i < numCourses; i++) {
            graphInfo.add(i,new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int v = prerequisite[1];
            int u = prerequisite[0];
            graphInfo.get(v).add(u);
        }

        for (int i = 0; i < numCourses && !curCircle; i++) {
            // 如果当前i没有访问过
            if (state[i]==0) {
                dfs(i);
            }
        }

        return curCircle? new int[0]:result;

    }

    // 遍历当前节点
    private void dfs(int i){
        // 当前节点标记正在访问
        state[i] = 1;
        List<Integer> nodeList = graphInfo.get(i);
        for (Integer node : nodeList) {
            if (state[node]==1){
                curCircle=true;
                return ;
            }

            if (state[node]==0){
                dfs(node);
                // 递归返回到上一层，如果已经形成环直接返回
                if (curCircle){
                    return;
                }
            }
        }

        state[i] = 2;
        result[resultIndex] = i;
        resultIndex--;

    }
}
