package zyj.yihong.leetcode.mid.dp;

/**
 * 688. 骑士在棋盘上的概率*
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/knight-probability-in-chessboard
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class KnightProbability688 {
    public double knightProbability(int n, int k, int row, int column) {
        //定义八个方向的坐标
        int[][] direct = {{-2,1},{-2,-1},{-1,-2},{-1,2},{1,-2},{1,2},{2,-1},{2,1}};

        // 定义dp:当前第i步,起始点为row、column，在棋盘上的概率
        double[][] preDp = new double[n][n];

        for (int curStep = 0; curStep <= k ; curStep++) {
            double[][] dp = new double[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (curStep==0){
                        dp[i][j] = 1;
                    }else {
                        // 遍历当前的8个方向
                        for (int[] curDirect : direct) {
                            int nextStepI = i+curDirect[0];
                            int nextstepJ = j + curDirect[1];

                            // 判断是否在棋盘上
                            if (nextStepI>=0&&nextStepI<n&&nextstepJ>=0&&nextstepJ<n){
                                dp[i][j]+=preDp[nextStepI][nextstepJ]/8;
                            }
                        }
                    }
                }
            }
            preDp = dp;
        }
        return preDp[row][column];
    }
}
