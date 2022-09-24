package zyj.yihong.leetcode.random_select.seg;

import java.util.Arrays;

// 781. 森林中的兔子
public class NumRabbits_M_781 {
    public int numRabbits(int[] answers) {
        int ans = 0;
        Arrays.sort(answers);
        for (int i = 0; i < answers.length; i++) {
            ans+=answers[i]+1;
            int step = answers[i];
            while (step>0 && i+1<answers.length && answers[i+1]==answers[i]){
                i++;
                step--;
            }
        }

        return ans;
    }
}
