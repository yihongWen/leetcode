package zyj.yihong.leetcode.random_select.seg;

import java.util.Arrays;
// 748. 最短补全词
public class ShortestCompletingWord_S_748 {
    public static String shortestCompletingWord(String licensePlate, String[] words) {
        int[] comp1 = new int[26];
        int[] comp2 = new int[26];
        String ans = "";
        for (int i = 0; i < licensePlate.length(); i++) {
            char c = licensePlate.charAt(i);
            if (Character.isLetter(c)) {
                comp1[Character.toLowerCase(c) - 'a']++;
            }
        }

        for (String word : words) {
            Arrays.fill(comp2, 0);
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (Character.isLetter(c)) {
                    comp2[Character.toLowerCase(c) - 'a']++;
                }
            }

            boolean flag = false;
            for (int i = 0; i < 26; i++) {
                if (comp1[i] > comp2[i]) {
                    flag = true;
                    break;
                }
            }
            if (flag){
                continue;
            }

            if (ans.equals("") || ans.length() > word.length()) {
                ans = word;
            }


        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "1s3 PSt";
        String[] arr = {"step", "steps", "stripe", "stepple"};
        String s1 = shortestCompletingWord(s, arr);
        System.out.println(s1);


    }
}
