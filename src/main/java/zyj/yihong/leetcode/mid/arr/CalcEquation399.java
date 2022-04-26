package zyj.yihong.leetcode.mid.arr;

import java.util.*;

/**
 * 399. 除法求值
 * 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
 *
 * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
 *
 * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替代这个答案。
 *
 * 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。

 */
public class CalcEquation399 {
    int[] parent;
    double[] weight;
    Map<String,Integer> sIndexMap;
    int count = 0;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 初始化相关的数据结构
        int size = equations.size();
        parent = new int[size*2];
        weight = new double [size*2];
        for (int i = 0; i < size*2; i++) {
            parent[i] = i;
            weight[i] = 1.0d;
        }

        sIndexMap = new HashMap<>(size*2);
        // 建立关系，并的过程
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String d1 = equation.get(0);
            String d2 = equation.get(1);
            if (!sIndexMap.containsKey(d1)){
                sIndexMap.put(d1,count);
                count++;
            }

            if (!sIndexMap.containsKey(d2)){
                sIndexMap.put(d2,count);
                count++;
            }


            // 建立关系
            union(sIndexMap.get(d1),sIndexMap.get(d2),values[i]);
        }

        // 查询关系
        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String d1 = query.get(0);
            String d2 = query.get(1);

            if (!sIndexMap.containsKey(d1) || !sIndexMap.containsKey(d2)){
                ans[i] = -1.0D;
                continue;
            }
            ans[i] = queryAns(sIndexMap.get(d1),sIndexMap.get(d2));
        }
        return ans;
    }

    private void union(int d1,int d2,double v){
        int p1 = find(d1);
        int p2 = find(d2);
        if (p1==p2){
            return;
        }
        parent[p1] = p2;
        weight[p1] = weight[d2] * v / weight[d1];
    }

    private double queryAns(int d1,int d2){
        int root1 = find(d1);
        int root2 = find(d2);
        if (root1==root2){
            return weight[d1]/weight[d2];
        }else {
            return -1.0d;
        }
    }

    private int find(int index){
        // 压缩
        int curIndex = index;
        while (parent[curIndex]!=curIndex){
            curIndex = index;
            int p = parent[curIndex];
            parent[index] = parent[parent[index]];
            weight[index] *= weight[p];
            curIndex = parent[index];
        }
        return curIndex;
    }

    public static void main(String[] args) {
        List<List<String>> arr1 = new ArrayList<>();
        arr1.add(Arrays.asList("x1","x2"));
        arr1.add(Arrays.asList("x2","x3"));
        arr1.add(Arrays.asList("x3","x4"));
        arr1.add(Arrays.asList("x4","x5"));
        double[] arr = {3.0d,4.0d,5.0d,6.0d};

        List<List<String>> arr2 = new ArrayList<>();
        arr2.add(Arrays.asList("x1","x5"));
        arr2.add(Arrays.asList("x5","x2"));
        arr2.add(Arrays.asList("x2","x4"));
        arr2.add(Arrays.asList("x2","x2"));
        arr2.add(Arrays.asList("x2","x9"));
        arr2.add(Arrays.asList("x9","x9"));

        CalcEquation399 calcEquation399 = new CalcEquation399();
        double[] doubles = calcEquation399.calcEquation(arr1, arr, arr2);
        System.out.println(Arrays.toString(doubles));
    }

//    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
//        int equationsSize = equations.size();
//
//        UnionFind unionFind = new UnionFind(2 * equationsSize);
//        // 第 1 步：预处理，将变量的值与 id 进行映射，使得并查集的底层使用数组实现，方便编码
//        Map<String, Integer> hashMap = new HashMap<>(2 * equationsSize);
//        int id = 0;
//        for (int i = 0; i < equationsSize; i++) {
//            List<String> equation = equations.get(i);
//            String var1 = equation.get(0);
//            String var2 = equation.get(1);
//
//            if (!hashMap.containsKey(var1)) {
//                hashMap.put(var1, id);
//                id++;
//            }
//            if (!hashMap.containsKey(var2)) {
//                hashMap.put(var2, id);
//                id++;
//            }
//            unionFind.union(hashMap.get(var1), hashMap.get(var2), values[i]);
//        }
//
//        // 第 2 步：做查询
//        int queriesSize = queries.size();
//        double[] res = new double[queriesSize];
//        for (int i = 0; i < queriesSize; i++) {
//            String var1 = queries.get(i).get(0);
//            String var2 = queries.get(i).get(1);
//
//            Integer id1 = hashMap.get(var1);
//            Integer id2 = hashMap.get(var2);
//
//            if (id1 == null || id2 == null) {
//                res[i] = -1.0d;
//            } else {
//                res[i] = unionFind.isConnected(id1, id2);
//            }
//        }
//        return res;
//    }
//
//    private class UnionFind {
//
//        private int[] parent;
//
//        /**
//         * 指向的父结点的权值
//         */
//        private double[] weight;
//
//
//        public UnionFind(int n) {
//            this.parent = new int[n];
//            this.weight = new double[n];
//            for (int i = 0; i < n; i++) {
//                parent[i] = i;
//                weight[i] = 1.0d;
//            }
//        }
//
//        public void union(int x, int y, double value) {
//            int rootX = find(x);
//            int rootY = find(y);
//            if (rootX == rootY) {
//                return;
//            }
//
//            parent[rootX] = rootY;
//            // 关系式的推导请见「参考代码」下方的示意图
//            weight[rootX] = weight[y] * value / weight[x];
//        }
//
//        /**
//         * 路径压缩
//         *
//         * @param x
//         * @return 根结点的 id
//         */
//        public int find(int x) {
//            if (x != parent[x]) {
//                int origin = parent[x];
//                parent[x] = find(parent[x]);
//                weight[x] *= weight[origin];
//            }
//            return parent[x];
//        }
//
//        public double isConnected(int x, int y) {
//            int rootX = find(x);
//            int rootY = find(y);
//            if (rootX == rootY) {
//                return weight[x] / weight[y];
//            } else {
//                return -1.0d;
//            }
//        }
//    }


}
