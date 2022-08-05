package zyj.yihong.leetcode.random_select;

// 520. 检测大写字母
public class DetectCapitalUse_S_520 {
    public boolean detectCapitalUse(String word) {
        // 长度为1
        if (word.length() == 1) {
            return Character.isAlphabetic(word.charAt(0));
        }

        // 如果首字母是小写
        char c = word.charAt(0);
        if (Character.isLowerCase(c)) {
            for (int i = 1; i < word.length(); i++) {
                if (Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
            }
            return true;
        }

        // 首字母是大写，第二是小写
        char c1 = word.charAt(1);
        if (Character.isLowerCase(c1)) {
            for (int i = 2; i < word.length(); i++) {
                if (Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
            }
            return true;
        }

        // 全是大写的情况
        for (int i = 2; i < word.length(); i++) {
            if (Character.isLowerCase(word.charAt(i))) {
                return false;
            }
        }
        return true;

    }

}
