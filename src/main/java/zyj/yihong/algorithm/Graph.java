package zyj.yihong.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Graph {

    // 图的矩阵表示
    int[][] graphMatrix;

    // 图的节点大小
    public int nodeSize;

    public Graph(int[][] graphMatrix) {
        this.graphMatrix = graphMatrix;
        nodeSize = graphMatrix.length;
    }

    // 最小生成树：kruskal算法（加边法）
    private List<EdgeData> kruskal(){
        List<EdgeData> ans = new ArrayList<>();

        // 获取矩阵中所有的边
        List<EdgeData> allEdgeList = getAllEdge();

        // 对边的权重进行排序
        allEdgeList.sort((Comparator.comparingInt(o -> o.value)));

        // 最小生成树中每个节点的指向
        int[] pointInfoEdgeArr = new int[nodeSize];

        // 生成最小生成树（包含所有的点,n个点，n-1条边）
        for (int i = 0; i < allEdgeList.size(); i++) {
            EdgeData edgeData = allEdgeList.get(i);

            int start = edgeData.start;
            int end = edgeData.end;

            int startEndPoint = getEndPoint(pointInfoEdgeArr, start);
            int endEndPoint = getEndPoint(pointInfoEdgeArr, end);

            // 没有形成环的情况下，加入
            if (endEndPoint!=startEndPoint){
                ans.add(edgeData);
                pointInfoEdgeArr[startEndPoint] = endEndPoint;
            }

            if (ans.size()==nodeSize-1){
                return ans;
            }
        }
        return ans;
    }

    // prim算法
    private List<EdgeData> prim(){
        //遍历图中的每一个顶点
        List<EdgeData> ans = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            ans.clear();
            int index=0;
            int[] prims  = new int[nodeSize];
            int[][] weights = new int[nodeSize][2];


            // 加入当前顶点
            prims[index] = i;
            index++;

            // 计算weights
            for (int j = 0; j < nodeSize; j++) {
                weights[j][0] = graphMatrix[i][j];
                weights[j][1] = i;
            }

            // 自身的距离为0
            weights[i][0] = 0;

            boolean flag1 = true;
            // 计算当前需要加入的节点
            for (int j = 0; j < nodeSize-1; j++) {

                // 找到weight中的最小值，也就是即将要加入的点
                int min = Integer.MAX_VALUE;
                int minIndex = 0;
                boolean flag2 = false;
                for (int k = 0; k < nodeSize; k++) {
                    if (weights[k][0]!=0 && weights[k][0]!=-1&&weights[k][0]<min){
                        min = weights[k][0];
                        minIndex = k;
                        flag2 = true;
                    }
                }

                if (!flag2){
                    flag1 = false;
                    break;
                }


                // 加入结果,并且置当前的weight[minIndex]=0
                prims[index] = minIndex;
                ans.add(new EdgeData(weights[minIndex][1],minIndex,graphMatrix[weights[minIndex][1]][minIndex]));


                index++;
                weights[minIndex][0] = 0;
                weights[minIndex][1] = minIndex;


                for (int k = 0 ; k < nodeSize; k++) {
                    // 当第j个节点没有被处理，并且需要更新时才被更新。
                    if (weights[k][0] != 0 && ((weights[k][0]==-1&&graphMatrix[minIndex][k]!=-1)||(graphMatrix[minIndex][k]!=-1&&graphMatrix[minIndex][k] < weights[k][0]))) {
                        weights[k][0] = graphMatrix[minIndex][k];
                        weights[k][1] = minIndex;
                    }
                }
            }

            if (!flag1){
                continue;
            }

            System.out.println(Arrays.toString(prims));

            break;

        }
        return ans;
    }

    // floyd 基于动态规划
    private void floyd(int[][] ans,int[][] path){
        int inf = -1;
        // 基于两个点的情况初始化ans矩阵、以及path矩阵
        System.arraycopy(graphMatrix,0,ans,0,graphMatrix.length);
        for (int i = 0; i < graphMatrix.length; i++) {
            Arrays.fill(path[i],inf);
        }

        // 一次加入每一个点
        for (int k = 0; k < graphMatrix.length; k++) {
            // 计算对其他节点的影响
            for (int i = 0; i < graphMatrix.length; i++) {
                for (int j = 0; j < graphMatrix.length; j++) {
                    if (ans[i][k]!=inf&&ans[k][j]!=inf){
                        if (ans[i][j]!=inf&&ans[i][k] + ans[k][j]<ans[i][j]) {
                            ans[i][j] = ans[i][k] + ans[k][j];
                            path[i][j] = k;
                        }else if (ans[i][j]==inf) {
                            ans[i][j] = ans[i][k]+ans[k][j];
                            path[i][j] = k;
                        }
                    }
                }
            }
        }

    }


    // dijkstra 算法
    private void dijkstra(int sourceNode,int[] ans,int[] path){
        // 初始化
        boolean[] flag = new boolean[graphMatrix.length];
        flag[sourceNode] = true;
        for (int i = 0; i < graphMatrix.length; i++) {
            ans[i] = graphMatrix[sourceNode][i];
        }
        ans[sourceNode] = 0;


        int selectNode = 0;
        for (int i = 1; i < graphMatrix.length; i++) {
            int min = -1;
            for (int j = 0; j < graphMatrix.length; j++) {
                if (!flag[j]&&(min==-1 || (ans[j]!=-1 &&ans[j]<min))){
                    selectNode = j;
                    min = ans[j];
                }
            }

            // 将当前选择的进行标记
            flag[selectNode] = true;

            // 计算加入当前点引起的变化
            for (int j = 0; j < graphMatrix.length; j++) {
                if ((min!=-1&&graphMatrix[selectNode][j]!=-1) && (ans[j]==-1 || ans[j]>min+graphMatrix[selectNode][j])){
                    ans[j] = min+graphMatrix[selectNode][j];
                    path[j] = selectNode;
                }
            }
        }


    }


    // bellmanFord算法
    private boolean bellmanFord(int sourceNode,int[] ans,int[] path){
        // 获取所有的边信息
        List<EdgeData> edgeDataList = getAllEdge();
        Arrays.fill(ans,-1);
        Arrays.fill(path,-1);
        ans[sourceNode] = 0;
        path[sourceNode] = sourceNode;

        // 对边松弛n-1次
        for (int i = 0; i < graphMatrix.length - 1; i++) {

            // 处理每一条边
            for (EdgeData edgeData : edgeDataList) {
                int start = edgeData.start;
                int end = edgeData.end;
                int value = edgeData.value;
                if ((ans[start]!=-1) && ((ans[end]==-1) || ans[end]>ans[start]+value)){
                    ans[end] = ans[start]+value;
                    path[end] = start;
                }
            }
        }


        // 在执行一次是否存在负边权
        for (EdgeData edgeData : edgeDataList) {
            int start = edgeData.start;
            int end = edgeData.end;
            int value = edgeData.value;
            if ((ans[start]!=-1) && (ans[end]!=-1) && ans[end]>ans[start]+value){
                return false;
            }
        }

        return true;
    }

    // 获取某个node指向的end节点
    private int getEndPoint(int[] pointInfoEdgeArr,int nodeIndex){
        while (pointInfoEdgeArr[nodeIndex]!=0){
            nodeIndex = pointInfoEdgeArr[nodeIndex];
        }
        return nodeIndex;
    }

    // 获取图中所有的边
    private List<EdgeData> getAllEdge(){
        List<EdgeData> ans = new ArrayList<>();
        for (int i = 0; i < graphMatrix.length; i++) {
            int[] curRow = graphMatrix[i];
            for (int j = 0; j < curRow.length; j++) {
                // 两个节点是否存在连通
                if (i!=j&&graphMatrix[i][j]!=-1){
                    EdgeData edgeData = new EdgeData(i,j,graphMatrix[i][j]);
                    ans.add(edgeData);
                }
            }
        }
        return ans;
    }


    // 边的表示的结构
    static class EdgeData{
        // 边的起点、终点、以及权重
        public int start;
        public int end;
        public int value;

        public EdgeData(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }
    }

    // 并查集实现
    static class UnionFind{
        // 元数据信息，start->end 权重value
        List<EdgeData> sourceInfo;

        // 节点的个数（为了方便，也可用从所有的边信息给出）
        int size;

        int[] point;
        int[] weight;
        int[] rank;

        public UnionFind(List<EdgeData> sourceInfo,int size) {
            this.sourceInfo = sourceInfo;
            this.size = size;
            init();
        }

        private void init(){
            // 初始化将每个点指向自身，权重设置为1
            point = new int[size];
            weight = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                point[i] = i;
            }
            Arrays.fill(weight,1);
            Arrays.fill(rank,1);
        }


        private void union(){
            // 处理每一条边的两个点
            for (EdgeData edgeData : sourceInfo) {
                int start = edgeData.start;
                int end = edgeData.end;
                int value = edgeData.value;

                int f1 = find1(start);
                int f2 = find1(end);

                // 两个节点所在树的根节点为相同，那么直接返回
                if (f1==f2){
                    return;
                }

                if (rank[start]>rank[end]){
                    point[f2] = f1;
                    weight[f2] = weight[end]*value/weight[start];
                }else {
                    point[f1] = f2;
                    weight[f1] = weight[start]/weight[end] * value ;
                }
            }
        }

        // 直接一个个往上查找
        private int find1(int node){
            int curNode = node;
            while (point[curNode]!=curNode){
                curNode = node;
                int pNode = point[curNode];
                point[node] = point[point[curNode]];
                weight[node]*=point[pNode];
                curNode = point[node];
            }
            return curNode;
        }


    }

    public static void main(String[] args) {
        int inf = -1;
//        int[][] matrix = {
//                {0,2,5,inf,inf},
//                {inf,0,2,6,inf},
//                {inf,inf,0,7,1},
//                {inf,inf,2,0,4},
//                {inf,inf,inf,inf,0},
//
//        };
//        Graph graph = new Graph(matrix);
//        int[] ans = new int[graph.graphMatrix.length];
//        int[] path = new int[graph.graphMatrix.length];
//        boolean b = graph.bellmanFord(0, ans, path);
//        System.out.println(b);
//        System.out.println(Arrays.toString(ans));
//        System.out.println(Arrays.toString(path));


        int[][] matrix1 = {
                {0,inf,inf,6,inf},
                {5,0,2,inf,inf},
                {inf,inf,0,inf,2},
                {inf,inf,inf,0,inf},
                {1,inf,inf,3,0}
        };
        Graph graph1 = new Graph(matrix1);
        List<EdgeData> prim = graph1.prim();
        System.out.println(prim);

    }
}
