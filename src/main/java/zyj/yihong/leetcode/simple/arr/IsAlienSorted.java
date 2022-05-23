package zyj.yihong.leetcode.simple.arr;

/**
 * 953. 验证外星语词典
 */
public class IsAlienSorted {
    public boolean isAlienSorted(String[] words, String order) {
        // 初始化order(用数组的方式代替map)
        byte[] orderArr = new byte[26];
        for (byte i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            orderArr[c-'a'] = i;
        }

        for (int i = 0; i < words.length-1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];
            int minLength = s1.length()-s2.length()>0?s2.length():s1.length();
            boolean flag = false;
            for (int j = 0; j < minLength; j++) {
                // 比较两个字符中每个字母值的顺序
                char c1 = s1.charAt(j);
                char c2 = s2.charAt(j);
                if (orderArr[c1-'a']>orderArr[c2-'a']){
                    return false;
                }else if (orderArr[c1-'a']<orderArr[c2-'a']){
                    flag = true;
                    break;
                }
            }

            // 如果长度不一样,并且在最小长度的值都是完全匹配的情况下
            if (!flag&&s1.length()>s2.length()){
                return false;
            }
        }
        return true;
    }
}
