package zyj.yihong.algorithm;

public class Prim {
    // ----------------------------图的表示方式------------------------
    private int vertexSize;// 顶点的数量
    private int[] vertexs;// 顶点对应的数组
    private int[][] matrix;// 邻接矩阵
    private static final int MAX_WEIGHT = 1000;// 代表顶点之间不连通
    private boolean[] isVisited; // 顶点是否已经被访问

    public Prim(int vertexSize) {
        this.vertexSize = vertexSize;
        this.matrix = new int[vertexSize][vertexSize];
        this.vertexs = new int[vertexSize];
        for (int i = 0; i < vertexSize; i++) {
            vertexs[i] = i;
        }

        isVisited = new boolean[vertexSize];
    }
    // ----------------------------图的表示方式------------------------

    // 最小生成树----普里姆算法
    public void prim() {
        // 假设最先取出顶点0,并遍历出它与其他所有顶点的距离----正好就是图中邻接矩阵的第一行
        int[] distance = matrix[0];

        int sum = 0; // 总距离

        System.out.print("查找到点的顺序:0");

        // 控制向树中添加点的次数
        // 因为默认取出了一个点加入到了最小生成树中,则还需要再确定另外n-1个点的加入顺序
        for (int i = 1; i < vertexSize; i++) {
            // 假设初始最小值如下:
            int min = MAX_WEIGHT;
            int minId = 0;

            // 遍历距离数组找出该数组中除了距离为0(说明该点已经加入到了最小生成树中)和距离为无穷大的
            // 所有顶点中距离最小的那个----说明这个点是与已经确定的所有点可以连通,而且值最小
            for (int j = 1; j < vertexSize; j++) {
                if (distance[j] > 0 && distance[j] < MAX_WEIGHT && distance[j] < min) {
                    min = distance[j];
                    minId = j;
                }
            }

            // 将minId标定为已经确定的点
            distance[minId] = 0;

            System.out.print("--->" + minId);
            // 计算总距离
            sum += min;

            // 遍历minId点的所有邻接点,找到已确定点到其他未知点之间更小的距离
            for (int k = 0; k<vertexSize; k++) {
                if (distance[k] > 0 && distance[k] > matrix[minId][k]) {
                    distance[k] = matrix[minId][k];
                }
            }
        }
        System.out.println();
        System.out.println("最小生成树的总距离为:" + sum);

    }
    // 最小生成树----普里姆算法

    public static void main(String[] args) {
        Prim graph = new Prim(9);
        int[] v0 = { 0, 10, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 11, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT };
        int[] v1 = { 10, 0, 18, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 16, MAX_WEIGHT, 12 };
        int[] v2 = { MAX_WEIGHT, MAX_WEIGHT, 0, 22, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 8 };
        int[] v3 = { MAX_WEIGHT, MAX_WEIGHT, 22, 0, 20, MAX_WEIGHT, 24, 16, 21 };
        int[] v4 = { MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 20, 0, 26, MAX_WEIGHT, 7, MAX_WEIGHT };
        int[] v5 = { 11, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 26, 0, 17, MAX_WEIGHT, MAX_WEIGHT };
        int[] v6 = { MAX_WEIGHT, 16, MAX_WEIGHT, 24, MAX_WEIGHT, 17, 0, 19, MAX_WEIGHT };
        int[] v7 = { MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 16, 7, MAX_WEIGHT, 19, 0, MAX_WEIGHT };
        int[] v8 = { MAX_WEIGHT, 12, 8, 21, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 0 };

        graph.matrix[0] = v0;
        graph.matrix[1] = v1;
        graph.matrix[2] = v2;
        graph.matrix[3] = v3;
        graph.matrix[4] = v4;
        graph.matrix[5] = v5;
        graph.matrix[6] = v6;
        graph.matrix[7] = v7;
        graph.matrix[8] = v8;

        //test
        graph.prim();

    }
}
