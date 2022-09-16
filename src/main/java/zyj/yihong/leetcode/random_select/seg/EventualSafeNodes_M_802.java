package zyj.yihong.leetcode.random_select.seg;

import java.util.ArrayList;
import java.util.List;

// 802. 找到最终的安全状态
public class EventualSafeNodes_M_802 {
    // 节点标记状态（0未访问 1、正在访问的状态（可能处于环中）2、安全节点）
    int[] state;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        state = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            dfs(i,graph);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < state.length; i++) {
            if (state[i] == 2) {
                ans.add(i);
            }
        }
        return ans;
    }

    // 判断当前节点是否为安全节点: 当前节点指向的所有节点都是安全节点时，当前节点也为安全节点
    private boolean dfs(int curNode,int[][] graph) {
        // 如果出现环的情况,以及cur节点已经被处理过
        if (state[curNode]!=0){
            return state[curNode]==2;
        }

        // 当前节点标记为1
        state[curNode] = 1;
        int[] nodeConnect = graph[curNode];
        for (int nextNode : nodeConnect) {
            if (!dfs(nextNode,graph)){
                return false;
            }
        }

        state[curNode] = 2;
        return true;
    }

    public static void main(String[] args) {
        int[][] g = {{1,2},{2,3},{5},{0},{5},{},{}};
        EventualSafeNodes_M_802 eventualSafeNodes_m_802 = new EventualSafeNodes_M_802();
        List<Integer> integers = eventualSafeNodes_m_802.eventualSafeNodes(g);
        System.out.println(integers);
    }
}
