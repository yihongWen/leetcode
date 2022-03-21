package zyj.yihong.leetcode.mid.graph;

import java.util.*;

/**
 * 2039. 网络空闲的时刻
 * 给你一个有 n 个服务器的计算机网络，服务器编号为 0 到 n - 1 。同时给你一个二维整数数组 edges ，其中 edges[i] = [ui, vi] 表示服务器 ui 和 vi 之间有一条信息线路，在 一秒 内它们之间可以传输 任意 数目的信息。再给你一个长度为 n 且下标从 0 开始的整数数组 patience 。
 * <p>
 * 题目保证所有服务器都是 相通 的，也就是说一个信息从任意服务器出发，都可以通过这些信息线路直接或间接地到达任何其他服务器。
 * <p>
 * 编号为 0 的服务器是 主 服务器，其他服务器为 数据 服务器。每个数据服务器都要向主服务器发送信息，并等待回复。信息在服务器之间按 最优 线路传输，也就是说每个信息都会以 最少时间 到达主服务器。主服务器会处理 所有 新到达的信息并 立即 按照每条信息来时的路线 反方向 发送回复信息。
 * <p>
 * 在 0 秒的开始，所有数据服务器都会发送各自需要处理的信息。从第 1 秒开始，每 一秒最 开始 时，每个数据服务器都会检查它是否收到了主服务器的回复信息（包括新发出信息的回复信息）：
 * <p>
 * 如果还没收到任何回复信息，那么该服务器会周期性 重发 信息。数据服务器 i 每 patience[i] 秒都会重发一条信息，也就是说，数据服务器 i 在上一次发送信息给主服务器后的 patience[i] 秒 后 会重发一条信息给主服务器。
 * 否则，该数据服务器 不会重发 信息。
 * 当没有任何信息在线路上传输或者到达某服务器时，该计算机网络变为 空闲 状态。
 * <p>
 * 请返回计算机网络变为 空闲 状态的 最早秒数 。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/the-time-when-the-network-becomes-idle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NetworkBecomesIdle2039 {
    /**
     * 构图、广度优先搜索计算出每个节点的最小距离，然后分类讨论 dis,patience的关系
     *
     * @param edges
     * @param patience
     * @return
     */
    public static int networkBecomesIdle(int[][] edges, int[] patience) {
        int result = Integer.MIN_VALUE;
        int nodeSize = patience.length;
        List<Integer>[] graphInfo = new List[nodeSize];
        for (int i = 0; i < nodeSize; i++) {
            graphInfo[i] = new ArrayList<>();
        }

        // 遍历每个节点的连接信息:双向
        for (int[] edge : edges) {
            int i = edge[0];
            int i1 = edge[1];
            graphInfo[i].add(i1);
            graphInfo[i1].add(i);
        }

        // 广度优先搜索，计算没个节点的最小dist
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        Set<Integer> exist = new HashSet<>();
        exist.add(0);
        int minDistOfNode = 0;
        while (!queue.isEmpty()) {
            // 遍历当前距离的节点
            minDistOfNode++;
            int minDistSize = queue.size();
            for (int i = 0; i < minDistSize; i++) {
                Integer curNode = queue.poll();
                for (Integer connectOfCurNode : graphInfo[curNode]) {
                    if (exist.contains(connectOfCurNode)) {
                        continue;
                    }
                    queue.add(connectOfCurNode);

                    // 计算时间
                    int spentTime = 2 * minDistOfNode + 1 + ((2 * minDistOfNode - 1) / patience[connectOfCurNode]) * patience[connectOfCurNode];
                    result = Math.max(spentTime, result);
                    exist.add(connectOfCurNode);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[][] arr = {{3,8},{4,13},{0,7},{0,4},{1,8},{14,1},{7,2},{13,10},{9,11},{12,14},{0,6},{2,12},{11,5},{6,9},{10,3}};
        int[] patience = {0,3,2,1,5,1,5,5,3,1,2,2,2,2,1};
        System.out.println(patience.length);
        int i = networkBecomesIdle(arr, patience);
        System.out.println(i);
    }


}
