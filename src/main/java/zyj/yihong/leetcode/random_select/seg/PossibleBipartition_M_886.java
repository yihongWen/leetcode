package zyj.yihong.leetcode.random_select.seg;

import java.util.*;

// 886. 可能的二分法
public class PossibleBipartition_M_886 {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] flag = new int[n];
        Arrays.fill(flag,-1);

        // 邻接链表
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < dislikes.length; i++) {
            graph.get(dislikes[i][0]-1).add(dislikes[i][1]-1);
            graph.get(dislikes[i][1]-1).add(dislikes[i][0]-1);
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (flag[i]==-1){
                queue.add(new int[]{i,0});
                flag[i] = 0;
                while (queue.size()!=0){
                    int[] info = queue.poll();
                    int node = info[0];
                    int colour = info[1];
                    for (Integer conNode : graph.get(node)) {
                        if (flag[conNode]==colour){
                            return false;
                        }else if (flag[conNode]==-1){
                            queue.add(new int[]{conNode,colour^1});
                            flag[conNode] = colour^1;
                        }
                    }
                }
            }
        }

        return true;
    }
}
