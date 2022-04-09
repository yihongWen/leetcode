package zyj.yihong.leetcode.hard;

/**
 * 780. 到达终点
 * 给定四个整数 sx , sy ，tx 和 ty，如果通过一系列的转换可以从起点 (sx, sy) 到达终点 (tx, ty)，则返回 true，否则返回 false。
 *
 * 从点 (x, y) 可以转换到 (x, x+y)  或者 (x+y, y)。
 */
public class ReachingPoints780 {
    public static boolean reachingPoints(int sx, int sy, int tx, int ty) {
        // 倒推计算出tx,ty其中一个值已经不能再继续小，也就是跟起始值持平
        while (tx>sx&&ty>sy){
            if (tx>ty){
                tx = tx % ty;
                continue;
            }
            ty = ty%tx;
        }

        if (tx<sx || ty<sy){
            return false;
        }

        if (tx==sx&&ty==sy){
            return true;
        }

        if (tx==sx&& (ty-sy)%tx==0){
            return true;
        }

        return ty == sy && (tx - sx) % ty == 0;
    }

    public static void main(String[] args) {
        boolean b = reachingPoints(3, 7, 3, 4);
        System.out.println(b);
    }
}
