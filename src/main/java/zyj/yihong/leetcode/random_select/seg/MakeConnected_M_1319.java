package zyj.yihong.leetcode.random_select.seg;

import java.util.Arrays;

// 1319. 连通网络的操作次数
public class MakeConnected_M_1319 {

    public static int makeConnected(int n, int[][] connections) {
        // connections中没有重复的链接,只要边的个数满足n-1即可
        if (connections.length<n-1){
            return -1;
        }

        // 定义并查集
        FindUnion findUnion = new FindUnion(n);

        // 并查集连接（对于union操作每次合并都会较少setCount）
        for (int[] connection : connections) {
            findUnion.union(connection[0],connection[1]);
        }

        // n个离散的大点只需要n-1个边链接
        return findUnion.setCount-1;

    }


    static class FindUnion{
        int nodeSize;
        int[] rank;
        int[] parent;
        int setCount;

        public FindUnion(int nodeSize) {
            this.nodeSize = nodeSize;
            this.setCount = nodeSize;
            rank = new int[nodeSize];
            parent = new int[nodeSize];
            Arrays.fill(rank,1);
            for (int i = 0; i < nodeSize; i++) {
                parent[i] = i;
            }
        }


        private void union(int start,int end){
            int ps = find(start);
            int pe = find(end);
            if (ps==pe){
                return;
            }
            if (rank[ps]>rank[pe]){
                int temp = ps;
                ps = pe;
                pe = temp;
            }

            parent[ps] = pe;
            if (rank[ps]==rank[pe]){
                rank[pe]++;
            }
            setCount--;
        }

        private int find(int x){
            int curIndex = x;
            while (parent[curIndex]!=curIndex){
                parent[x] = parent[parent[x]];
                curIndex = parent[x];
            }
            return curIndex;
        }
    }

    public static void main(String[] args) {
        int n = 4; int[][] connections = {{0,1},{0,2},{1,2}};
        int i = makeConnected(n, connections);
        System.out.println(i);
    }
}
