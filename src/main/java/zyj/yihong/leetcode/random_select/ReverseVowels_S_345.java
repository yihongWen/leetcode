package zyj.yihong.leetcode.random_select;

import java.util.HashSet;
import java.util.Set;

/**
 * 345. 反转字符串中的元音字母
 *
 */
public class ReverseVowels_S_345 {
    public String reverseVowels(String s) {
        int i = 0;
        int j = s.length()-1;
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        char[] chars = s.toCharArray();


        while (i<j){
            char c = chars[i];
            if (set.contains(c)||set.contains(Character.toLowerCase(c))){
                while (i<j){
                    char c1 = chars[j];
                    if (set.contains(c1)||set.contains(Character.toLowerCase(c1))){
                        chars[i] = c1;
                        chars[j] = c;
                        j--;
                        break;
                    }
                    j--;
                }
            }
            i++;
        }

        return new String(chars);
    }
}
