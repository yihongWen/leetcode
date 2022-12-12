package zyj.yihong.leetcode.random_select.dec;

// 1812. 判断国际象棋棋盘中一个格子的颜色
public class SquareIsWhite_S_1812 {
    public boolean squareIsWhite(String coordinates) {
        int alp = coordinates.charAt(0)-'a';
        int no = coordinates.charAt(1)-'0';
        if (((alp&1)==0 && (no&1)!=0) || (((alp&1)!=0) && (no&1)==0)){
            return false;
        }
        return true;
    }
}
