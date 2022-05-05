package zyj.yihong.leetcode.simple.arr;

/**
 * 387. 字符串中的第一个唯一字符
 *
 */
public class FirstUniqChar387 {
    public int firstUniqChar(String s) {
        byte[] reArr = new byte[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (reArr[index]<2){
                reArr[index]++;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (reArr[index]==1){
                return index;
            }
        }

        return -1;
    }
}
