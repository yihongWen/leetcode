package zyj.yihong.leetcode.simple.sliding;

/**
 * 202. 快乐数
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」 定义为：
 *
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/happy-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsHappy202 {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = next(n);

        while (fast!=1 && slow!=fast){
            slow = next(slow);
            fast = next(next(fast));
        }

        return fast==1;

    }

    private int next(int n){
        int cal = n;
        int sum = 0;
        while (cal!=0){
            int i = cal % 10;
            sum += i*i;
            cal = cal/10;
        }
        return sum;
    }


}
