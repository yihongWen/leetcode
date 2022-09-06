package zyj.yihong.leetcode.random_select.seg;

import java.util.Arrays;

// 709. 转换成小写字母
public class ToLowerCase_S_709 {
    public String toLowerCase(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar>='A'&&aChar<='Z') {
                chars[i] = (char) (((int) chars[i]) | 32);
            }
        }

        return String.valueOf(chars);
    }
}
