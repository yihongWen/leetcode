package zyj.yihong.leetcode.random_select.seg;

import java.util.Random;

public class Rand10_M_470 extends SolBase {
    public int rand10() {
        while (true){
            int col = rand7();
            int row = rand7();
            int num = (row-1)*7+col;
            if (num<=40){
                return (num-1)%10+1;
            }
            col = (num-1)%10+1;
            row = rand7();
            num = (row-1)*7+col;

            if (num<=60){
                return (num-1)%10+1;
            }

            col = (num-1)%10+1;
            row = rand7();
            num = (row-1)*7+col;

            if (num<=20){
                return (num-1)%10+1;
            }
        }
    }

    public static void main(String[] args) {
        Rand10_M_470 rand10_m_470 = new Rand10_M_470();
        for (int i = 0; i < 7; i++) {
            int i1 = rand10_m_470.rand10();
            System.out.println(i1);
        }
    }
}


class SolBase{
    public int rand7() {
        return new Random().nextInt(7)+1;
    }
}
