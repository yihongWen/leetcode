package zyj.yihong.leetcode.simple.arr;

/**
 * 289. 生命游戏
 * 根据 百度百科 ， 生命游戏 ，简称为 生命 ，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
 * <p>
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态： 1 即为 活细胞 （live），或 0 即为 死细胞 （dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 * <p>
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。给你 m x n 网格面板 board 的当前状态，返回下一个状态。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/game-of-life
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GameOfLife289 {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 计算当前节点的周围活着的个数
                int aroundLiveCount = 0;
                for (int i1 = i - 1; i1 <= i + 1; i1++) {
                    for (int j1 = j - 1; j1 <= j + 1; j1++) {
                        if (i1 == i && j1 == j) {
                            continue;
                        }

                        // 判断边界是否符合
                        if (i1 < 0 || i1 >= m || j1 < 0 || j1 >= n) {
                            continue;
                        }

                        if (Math.abs(board[i1][j1]) == 1) {
                            aroundLiveCount++;
                        }
                    }
                }
                // 判断该点的状态
                if (board[i][j]==1&&aroundLiveCount<2){
                    board[i][j] = -1;
                }else if (board[i][j]==1&&aroundLiveCount>3){
                    board[i][j] = -1;
                }else if (board[i][j]==0&&aroundLiveCount==3){
                    board[i][j] = 2;
                }
            }
        }

        // 恢复
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j]==-1){
                    board[i][j] = 0;
                }else if (board[i][j]==2){
                    board[i][j] = 1;
                }
            }
        }
    }
}
