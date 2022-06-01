package zyj.yihong.leetcode.mid.tree;

import java.util.Arrays;
import java.util.Collections;

/**
 * 473. 火柴拼正方形
 * 你将得到一个整数数组 matchsticks ，其中 matchsticks[i] 是第 i 个火柴棒的长度。你要用 所有的火柴棍 拼成一个正方形。你 不能折断 任何一根火柴棒，但你可以把它们连在一起，而且每根火柴棒必须 使用一次 。
 *
 * 如果你能使这个正方形，则返回 true ，否则返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/matchsticks-to-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Makesquare473 {
    public boolean makesquare(int[] matchsticks) {
        // 统计和
        if (matchsticks.length<4){
            return false;
        }

        int sum = 0;
        for (int matchstick : matchsticks) {
            sum += matchstick;
        }

        if (sum%4!=0){
            return false;
        }

        // 从大到小排序，优化复杂度
        Arrays.sort(matchsticks);


        int[] square = new int[4];
        return dfs(matchsticks,matchsticks.length-1,square,sum/4);

    }

    private boolean dfs(int[] matchsticks,int index,int[] square,int sideLength){
        // 当index == -1,则表示全部火柴都满足
        if (-1 == index){
            return true;
        }

        // 每一个火柴可以选择放置在四条边
        for (int i = 0; i < 4; i++) {
            int curMatchLength = matchsticks[index];
            square[i]+= curMatchLength;

            if (square[i]<=sideLength&&dfs(matchsticks,index-1,square,sideLength)){
                return true;
            }
            // 不满足返回到上一层
            square[i]-=matchsticks[index];
        }
        return false;
    }

    public static void main(String[] args) {
        Makesquare473 makesquare473 = new Makesquare473();
        int[] matchsticks = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,102};
        boolean makesquare = makesquare473.makesquare(matchsticks);
        System.out.println(makesquare);
    }
}
