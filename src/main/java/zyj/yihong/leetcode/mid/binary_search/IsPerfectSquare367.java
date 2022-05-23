package zyj.yihong.leetcode.mid.binary_search;

/**
 * 367. 有效的完全平方数
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 *
 * 进阶：不要 使用任何内置的库函数，如  sqrt 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/valid-perfect-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsPerfectSquare367 {
    public static boolean isPerfectSquare(int num) {
        if (num==1){
            return true;
        }

        int left = 1;
        int right = num/2;
        while (right>=left){
            int mid = (right-left)/2+left;
            long temp = (long) mid * mid;
            if (temp==num){
                return true;
            }else if (temp>num||temp<0){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        boolean perfectSquare = isPerfectSquare(2147395600);
        double sqrt = Math.sqrt(2147395600);
        System.out.println(sqrt);

    }
}
