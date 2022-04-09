package zyj.yihong.leetcode.mid.bisection;

/**
 * 29. 两数相除
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Divide29 {
    public int divide(int dividend, int divisor) {
        // 考虑边界条件
        if (divisor == 0) {
            return 0;
        }

        if (divisor == Integer.MIN_VALUE) {
            if (dividend == Integer.MIN_VALUE) {
                return 1;
            }
            return 0;
        }

        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1)
                return Integer.MAX_VALUE;

            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
        }

        // 将两个数都处理为负数
        boolean flag = false;
        if (dividend > 0) {
            dividend = -dividend;
            flag = true;
        }

        if (divisor > 0) {
            divisor = -divisor;
            flag = !flag;
        }
        // 使用二分法计算出结果
        int left = 1;
        int right = Integer.MAX_VALUE;
        while (left <= right) {
            // 计算中间节点
            int mid = (right - left) / 2 + left;
            if (checkCurAns(dividend, divisor, mid)) {
                if (mid == Integer.MAX_VALUE) {
                    left = mid;
                    break;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        int ans = left == Integer.MAX_VALUE ? left : left - 1;
        return flag ? -ans : ans;
    }

    /**
     * @param dividend 被除数 （负数）
     * @param divisor  除数 （负数）
     * @param cur      （正数）
     * @return
     */
    private boolean checkCurAns(int dividend, int divisor, int cur) {
        // 判断当前结果是否满足
        // divisor * cur>= dividend &&  divisor * cur+1< dividend

        // 使用快速加法实现乘法
        int curSum = 0;
        int addNum = divisor;
        while (cur != 0) {
            // cur%2==1, 贡献+1
            if ((cur & 1) == 1) {
                if (curSum < dividend - addNum) {
                    return false;
                }
                curSum += addNum;
            }

            if (cur != 1) {
                if (addNum < dividend - addNum) {
                    return false;
                }
                addNum += addNum;
            }

            cur = cur >> 1;
        }
        return true;
    }
}
