package zyj.yihong.leetcode.random_select.seg;

// 717. 1 比特与 2 比特字符
public class IsOneBitCharacter_S_717 {
    public boolean isOneBitCharacter(int[] bits) {
        int index = 0;
        for (; index < bits.length-1;) {
            if (bits[index]==0){
                index++;
                continue;
            }
            index+=2;
        }

        return index==bits.length-1;

    }
}
