package zyj.yihong.leetcode.mid.backtrack;

/**
 * 79. 单词搜索
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Exist79 {
    private int[][] direct = {{-1,0},{1,0},{0,-1},{0,1}};
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] used = new boolean[m][n];

        // 依次遍历每一个格子作为第一个起始字母
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = backtrack(board, used, i, j, word, 0);
                if (flag){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board,boolean[][] used,int i,int j,String word,int curIndex){
        // 当前的值不相等直接返回
        if (board[i][j]!=word.charAt(curIndex)){
            return false;
        }
        // 当前值相等，如果是最后一位则返回结果
        if (curIndex==word.length()-1){
            return true;
        }

        // 标记当前值已经被访问过
        used[i][j] = true;
        // 相等且此时没有达到长度的时，相四周递归的找下一位
        for (int[] curDirect : direct) {
            int nextI = i+curDirect[0];
            int nextJ = j+curDirect[1];

            if ((nextI>=0&&nextI< board.length&&nextJ>=0&&nextJ<board[0].length)&&!used[nextI][nextJ]){
                boolean backtrack = backtrack(board, used, nextI, nextJ, word, curIndex + 1);
                if (backtrack){
                    used[i][j] = false;
                    return true;
                }
            }

        }
        used[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        String word = "AAB";
        Exist79 exist79 = new Exist79();
        boolean exist = exist79.exist(board, word);
        System.out.println(exist);
    }
}
