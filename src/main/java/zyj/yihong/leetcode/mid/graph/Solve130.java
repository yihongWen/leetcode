package zyj.yihong.leetcode.mid.graph;

/**
 * 130. 被围绕的区域
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *  
 */
public class Solve130 {
    public void solve(char[][] board) {
        // 特殊处理
        if (board==null) return;
        int n = board.length;
        if (n==1) return;
        int m = board[0].length;
        if (m==1) return;

        // 判断每一个边界元素
        for (int i = 0; i < n; i++) {
            dfsMark(board,i,0);
            dfsMark(board,i,m-1);
        }

        for (int j = 1; j < m-1; j++) {
            dfsMark(board,0,j);
            dfsMark(board,n-1,j);
        }

        // 处理标记过的元素以及"O"元素
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j]=='O'){
                    board[i][j]='X';
                }else if (board[i][j]=='N'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfsMark(char[][] board,int i,int j){
        // 边界值、等条件判断
        if (i<0||i>=board.length||j<0||j>=board[0].length||board[i][j]!='O'){
            return;
        }

        // 标记
        board[i][j] = 'N';

        // 以当前位置往四个方向继续判断
        dfsMark(board,i+1,j);
        dfsMark(board,i-1,j);
        dfsMark(board,i,j-1);
        dfsMark(board,i,j+1);

    }
}
