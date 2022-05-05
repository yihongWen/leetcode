package zyj.yihong.leetcode.mid.graph;

/**
 * 剑指 Offer 12. 矩阵中的路径
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Exist_J12 {
    private char[][] data;
    private String word;
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {

        // 初始化数据
        this.data = board;
        this.word = word;
        visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int k) {
        // 边界，退出条件
        if (i < 0 || i >= data.length || j < 0 || j >= data[0].length || k >= word.length() || visited[i][j]) {
            return false;
        }

        // 不匹配、或者匹配并且是最后一个字符
        if (data[i][j] != word.charAt(k)) {
            return false;
        }

        if (k == word.length() - 1) {
            return true;
        }

        // 标记
        visited[i][j] = true;

        // 往下一个词迭代
        boolean flag;
        flag = dfs(i + 1, j, k + 1);
        if (flag) {
            visited[i][j] = false;
            return true;
        }
        flag = dfs(i - 1, j, k + 1);
        if (flag) {
            visited[i][j] = false;
            return true;
        }
        flag = dfs(i, j + 1, k + 1);
        if (flag) {
            visited[i][j] = false;
            return true;
        }
        flag = dfs(i, j - 1, k + 1);
        visited[i][j] = false;
        return flag;
    }

    public int[] printNumbers(int n) {
        int ans = 9;
        int i = 1;
        while (i<n){
            ans = ans*10+9;
            i++;
        }
        int[] ret = new int[ans];
        for (int j = 1; j <= ans; j++) {
            ret[j-1] = j;
        }
        return ret;
    }
}
