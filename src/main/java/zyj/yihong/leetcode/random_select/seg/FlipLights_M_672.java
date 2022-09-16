package zyj.yihong.leetcode.random_select.seg;


// 672. 灯泡开关 Ⅱ
public class FlipLights_M_672 {
    public int flipLights(int n, int presses) {
        // 根据分析只需要判断n(0-3)，已经p(1-3的情况)
        if (presses==0){
            return 1;
        }
        if (n==1){
            return 2;
        }

        if (n==2){
            return presses>1?4:3;
        }

        if (presses==1){
            return 4;
        }

        if (presses==2){
            return 7;
        }

        return 8;
    }
}
