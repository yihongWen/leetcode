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
        for (int i = 1; i < nodeSize; i++) {
            ans.clear();
            int index=0;                    // prim最小树的索引，即prims数组的索引
            int[] prims  = new int[nodeSize];  // prim最小树的结果数组
            int[][] weights = new int[nodeSize][2];   // 顶点间边的权值


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

    public static void main(String[] args) {
        int inf = -1;
//        int[][] matrix = {
//                {0,inf,inf,6,inf},
//                {5,0,2,inf,inf},
//                {inf,inf,0,inf,2},
//                {inf,inf,inf,0,inf},
//                {1,inf,inf,3,0}
//        };

        int[][] matrix = {
                {0,2,6,4},
                {inf,0,3,inf},
                {7,inf,0,1},
                {5,inf,12,0},
        };
        Graph graph = new Graph(matrix);
//        List<EdgeData> kruskal = graph.kruskal();
//        int weight = 0;
//        for (EdgeData edgeData : kruskal) {
//            weight+=edgeData.value;
//            System.out.println("start:"+edgeData.start+"->"+"end:"+edgeData.end);
//        }
//        System.out.println(weight);
//        List<EdgeData> prim = graph.prim();

        int[][] ans = new int[graph.nodeSize][graph.nodeSize];

        int[][] path = new int[graph.nodeSize][graph.nodeSize];
        graph.floyd(ans,path);
        System.out.println();


    }
}
