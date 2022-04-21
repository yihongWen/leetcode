package zyj.yihong.leetcode.simple.arr;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 824. 山羊拉丁文
 */
public class ToGoatLatin824 {
    public static String toGoatLatin(String sentence) {
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        String[] split = sentence.split(" ");
        StringBuilder ans = new StringBuilder();
        StringBuilder appendA = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            if (set.contains(Character.toLowerCase(s.charAt(0)))){
                ans.append(s);
            }else {
                ans.append(s.substring(1));
                ans.append(s.charAt(0));
            }
            ans.append("ma");
            appendA.append('a');
            ans.append(appendA);
            ans.append(" ");
        }
        ans.deleteCharAt(ans.length()-1);
        return ans.toString();
    }

    public static void main(String[] args) {
        String sentence = "I speak Goat Latin";
        String s = toGoatLatin(sentence);
        System.out.println(s);
    }
}
