package zyj.yihong.leetcode.random_select;

/**
 * 419. 甲板上的战舰
 */
public class CountBattleships_M_419 {
    public int countBattleships(char[][] board) {
        // 当发现一个X时，将起点为X的战舰设置成.  ans++
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]=='.'){
                    continue;
                }
                board[i][j] = '.';
                for (int k = i+1; k <board.length ; k++) {
                    if (board[k][j]=='X'){
                        board[k][j]='.';
                        continue;
                    }
                    break;
                }

                for (int k = j+1; k <board[0].length ; k++) {
                    if (board[i][k]=='X'){
                        board[i][k]='.';
                        continue;
                    }
                    break;
                }

                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        char[][] arr  = {{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};
        CountBattleships_M_419 countBattleships_m_419 = new CountBattleships_M_419();
        int i = countBattleships_m_419.countBattleships(arr);
        System.out.println(i);
    }
}
