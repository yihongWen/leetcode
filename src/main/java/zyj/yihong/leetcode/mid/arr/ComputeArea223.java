package zyj.yihong.leetcode.mid.arr;

public class ComputeArea223 {
    public static int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int s2 = (bx2 - bx1) * (by2 - by1);
        int s1 = (ax2 - ax1) * (ay2 - ay1);

        // 处理重叠部分右侧选择最小，左侧原则最大
        int overXLength = Math.min(bx2,ax2)-Math.max(ax1,bx1);
        int overYLength = Math.min(by2,ay2)-Math.max(ay1,by1);
        if (overYLength<0||overXLength<0){
            return s1+s2;
        }
        return s1+s2-overXLength*overYLength;
    }

    public static void main(String[] args) {

        int i = computeArea(-2, -2, 2, 2, -1, -1, 1, 1);
        System.out.println(i);
    }
}
