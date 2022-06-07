package zyj.yihong.leetcode.special.top.bit;

/**
 * 面试题 01.01. 判定字符是否唯一
 * 字符串为a-z
 */
public class IsUnique_S_m0101 {

    // 1、将整数的每一位代表字符所处的index
    // 2、是否出现过将所在的index（判断、设置为1(位移、与、或运算)
    public boolean isUnique(String astr) {
        int mark = 0;
        for (int i = 0; i < astr.length(); i++) {
            char c = astr.charAt(i);
            int index = c-'a';
            if (((1<<index)&mark)!=0){
                return false;
            }
            mark = mark|1<<index;
        }
        return true;
    }
}
