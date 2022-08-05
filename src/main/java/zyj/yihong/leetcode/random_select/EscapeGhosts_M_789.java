package zyj.yihong.leetcode.random_select;

// 789. 逃脱阻碍者
// 曼哈顿距离
public class EscapeGhosts_M_789 {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int gamerTargetDistance = Math.abs(target[0])+Math.abs(target[1]);
        for (int[] ghost : ghosts) {
            int ghostDistance = Math.abs(target[0] - ghost[0]) + Math.abs(target[1] - ghost[1]);
            if (ghostDistance<=gamerTargetDistance){
                return false;
            }
        }
        return true;
    }
}
