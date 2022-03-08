package zyj.yihong.leetcode.simple.brain;

import java.util.Arrays;

/**
 * 2055. 蜡烛之间的盘子
 * 给你一个长桌子，桌子上盘子和蜡烛排成一列。给你一个下标从 0 开始的字符串 s ，它只包含字符 '*' 和 '|' ，其中 '*' 表示一个 盘子 ，'|' 表示一支 蜡烛 。
 *
 * 同时给你一个下标从 0 开始的二维整数数组 queries ，其中 queries[i] = [lefti, righti] 表示 子字符串 s[lefti...righti] （包含左右端点的字符）。
 * 对于每个查询，你需要找到 子字符串中 在 两支蜡烛之间 的盘子的 数目 。如果一个盘子在 子字符串中 左边和右边 都 至少有一支蜡烛，那么这个盘子满足在 两支蜡烛之间 。
 *
 * 比方说，s = "||**||**|*" ，查询 [3, 8] ，表示的是子字符串 "*||**|" 。子字符串中在两支蜡烛之间的盘子数目为 2 ，子字符串中右边两个盘子在它们左边和右边 都 至少有一支蜡烛
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plates-between-candles
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class PlatesBetweenCandles2055 {
    /**
     * 预处理+前缀和
     * @param s
     * @param queries
     * @return
     */
    public static int[] platesBetweenCandles(String s, int[][] queries) {
        int[] preNumSum = new int[s.length()];
        int temp = 0;
        // 计算盘子的前缀和
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='*'){
                temp = temp+1;
            }
            preNumSum[i] = temp;
        }

        int[] leftCandle = new int[s.length()];
        int[] rightCandle = new int[s.length()];
        temp = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='|'){
                temp = i;
            }
            leftCandle[i] = temp;
        }

        temp = -1;

        for (int i = s.length()-1; i >=0 ; i--) {
            if (s.charAt(i)=='|'){
                temp = i;
            }
            rightCandle[i] = temp;
        }


        // 计算结果：
        int[] retValueArr = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int left = query[0];
            int right = query[1];
            int x = rightCandle[left];
            int y = leftCandle[right];

            if (x>=y ||x==-1 || y==-1){
                retValueArr[i] = 0;
                continue;
            }
            retValueArr[i] = preNumSum[y]-preNumSum[x];
        }
        return retValueArr;
    }

    public static void main(String[] args) {
        String s = "||*";
        int[][]queries = {{2,2}};
        int[] ints = platesBetweenCandles(s, queries);
        System.out.println(Arrays.toString(ints));
    }
}
