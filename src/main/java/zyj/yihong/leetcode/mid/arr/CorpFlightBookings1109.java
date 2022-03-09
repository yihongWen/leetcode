package zyj.yihong.leetcode.mid.arr;

/**
 * 1109. 航班预订统计
 * 这里有 n 个航班，它们分别从 1 到 n 进行编号。
 * <p>
 * 有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi] 意味着在从 firsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。
 * <p>
 * 请你返回一个长度为 n 的数组 answer，里面的元素是每个航班预定的座位总数。
 */
public class CorpFlightBookings1109 {

    /**
     * 差分数组+前缀和
     *
     * @param bookings
     * @param n
     * @return
     */
    public static int[] corpFlightBookings(int[][] bookings, int n) {
        // 定义差分数组
        int[] diff = new int[n];

        for (int[] booking : bookings) {
            int left = booking[0];
            int right = booking[1];
            int size = booking[2];

            diff[left - 1] += size;
            if (right != n) {
                diff[right] -= size;
            }
        }


        for (int i = 1; i < n; i++) {
            diff[i] = diff[i] + diff[i - 1];
        }

        return diff;
    }

    public static void main(String[] args) {

        int[][] bookings = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int n = 5;
        int[] ints = corpFlightBookings(bookings, n);
        System.out.println(ints);
    }
}
