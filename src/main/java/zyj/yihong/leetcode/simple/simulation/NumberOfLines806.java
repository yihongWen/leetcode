package zyj.yihong.leetcode.simple.simulation;

import java.util.Arrays;

/**
 * 806. 写字符串需要的行数
 * 我们要把给定的字符串 S 从左到右写到每一行上，每一行的最大宽度为100个单位，如果我们在写某个字母的时候会使这行超过了100 个单位，那么我们应该把这个字母写到下一行。我们给定了一个数组 widths ，这个数组 widths[0] 代表 'a' 需要的单位， widths[1] 代表 'b' 需要的单位，...， widths[25] 代表 'z' 需要的单位。
 *
 * 现在回答两个问题：至少多少行能放下S，以及最后一行使用的宽度是多少个单位？将你的答案作为长度为2的整数列表返回。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-lines-to-write-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumberOfLines806 {
    public static int[] numberOfLines(int[] widths, String s) {
        int line = 1;
        int lineTotal = 0;
        for (int i = 0; i < s.length(); i++) {
            int curWidth = widths[s.charAt(i) - 'a'];
            lineTotal=lineTotal+curWidth;
            if (lineTotal>100){
                line++;
                lineTotal = curWidth;
            }
        }
        return new int[]{line, lineTotal};
    }

    public static void main(String[] args) {
        int[] widths = {4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        String s = "bbbcccdddaaa";
        int[] ints = numberOfLines(widths, s);
        System.out.println(Arrays.toString(ints));
    }
}
