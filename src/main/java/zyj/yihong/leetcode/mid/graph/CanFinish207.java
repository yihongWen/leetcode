package zyj.yihong.leetcode.mid.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 207. 课程表
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * <p>
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanFinish207 {
    /**
     * 使用广度优先搜索
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 构建有向图（u-v）：学完了u就可以学习v
        List<List<Integer>> graphInfo = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graphInfo.add(i, new ArrayList<>());
        }

        // 初始化图、以及定义学习课程i，还需要直接学习的课程数目
        int[] preNum = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            int u = prerequisite[1];
            int v = prerequisite[0];
            graphInfo.get(u).add(v);
            preNum[v]++;
        }

        // 定义当前能够完成的课程数目
        int curLearnCount = 0;
        // 定义队列表示当前的课程处于可以学习的状态，也就是pre[i]==0
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (preNum[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            // 当前可以进行学习的课程u
            Integer u = queue.poll();
            curLearnCount++;
            // 依赖与u的课程
            List<Integer> judgeCanLearn = graphInfo.get(u);
            for (int i = 0; i < judgeCanLearn.size(); i++) {
                Integer curCourse = judgeCanLearn.get(i);
                preNum[curCourse]--;
                if (preNum[curCourse] == 0) {
                    queue.offer(curCourse);
                }
            }
        }

        return curLearnCount==numCourses;
    }

    public static void main(String[] args) {

    }
}
