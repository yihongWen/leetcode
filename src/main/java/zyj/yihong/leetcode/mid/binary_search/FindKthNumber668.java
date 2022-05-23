package zyj.yihong.leetcode.mid.binary_search;

/**
 * 668. 乘法表中第k小的数
 * 几乎每一个人都用 乘法表。但是你能在乘法表中快速找到第k小的数字吗？
 *
 * 给定高度m 、宽度n 的一张 m * n的乘法表，以及正整数k，你需要返回表中第k 小的数字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/kth-smallest-number-in-multiplication-table
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindKthNumber668 {
    public static int findKthNumber(int m, int n, int k) {
        // 二分查找
        int left = 1;
        int right = m*n;
        while (left<right){
            int mid = (right-left)/2+left;
            // 判断每一行小于mid的总数
            int count = 0;
            count+= (mid/n)*n;
            for (int i = (mid/n)+1; i <= m ; i++) {
                count+=mid/i;
            }

            // 根据mid的值处理left、right
            if (count<k){
                left = mid+1;
            }else {
                // mid可能不存在表中，所以==的情况也是处理有边界，靠左边界来逼近
                right = mid;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        System.out.println(5*5);
        int kthNumber = findKthNumber2(5, 5, 22);
        System.out.println(kthNumber);
    }

    public static int findKthNumber2(int m, int n, int k) {
        int left = 1, right = m * n;
        while (left < right) {
            int x = left + (right - left) / 2;
            int count = x / n * n;
            for (int i = x / n + 1; i <= m; ++i) {
                count += x / i;
            }
            if (count >= k) {
                right = x;
            } else {
                left = x + 1;
            }
        }
        return left;
    }


}
