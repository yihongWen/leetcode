package zyj.yihong.leetcode.random_select.seg;

// 657. 机器人能否返回原点
public class JudgeCircle_S_657 {
    public boolean judgeCircle(String moves) {
        int row = 0;
        int col = 0;
        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            if (c=='R'){
                row++;
            }else if (c=='L'){
                row--;
            }else if (c=='U'){
                col++;
            }else if (c=='D'){
                col--;
            }
        }

        return row==0&&col==0;
    }
}
