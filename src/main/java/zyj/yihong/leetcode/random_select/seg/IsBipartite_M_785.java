package zyj.yihong.leetcode.random_select.seg;

// 785. 判断二分图
public class IsBipartite_M_785 {
    boolean flag = true;
    Boolean[] colour;
    public boolean isBipartite(int[][] graph) {
        colour = new Boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            // 判断是否处理过
            if (colour[i]==null) {
                dfs(i, true, graph);
            }
        }

        return flag;
    }

    private boolean dfs(int node,Boolean red,int[][]graph){
        if (colour[node]!=null&&colour[node]!=red){
            flag = false;
            return false;
        }

        if (colour[node]==red){
            return true;
        }

        colour[node] = red;

        for (int nextNode : graph[node]) {
            boolean curAns = dfs(nextNode, !red, graph);
            if (!curAns){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
//        [[1,3],[0,2],[1,3],[0,2]]
        int[][] graph = {{1,3},{0,2},{1,3},{0,2}};
        IsBipartite_M_785 isBipartite_m_785 = new IsBipartite_M_785();
        boolean bipartite = isBipartite_m_785.isBipartite(graph);
        System.out.println(bipartite);
    }
}
