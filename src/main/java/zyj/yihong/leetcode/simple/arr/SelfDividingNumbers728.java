package zyj.yihong.leetcode.simple.arr;

import java.util.ArrayList;
import java.util.List;

/**
 * 728. 自除数
 * 自除数 是指可以被它包含的每一位数整除的数。
 *
 * 例如，128 是一个 自除数 ，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 * 自除数 不允许包含 0 。
 *
 * 给定两个整数 left 和 right ，返回一个列表，列表的元素是范围 [left, right] 内所有的 自除数 。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/self-dividing-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SelfDividingNumbers728 {
    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for (int i = left; i <=right ; i++) {
            int cur = i;
            boolean check = true;
            while (cur!=0){
                int i1 = cur % 10;
                cur = cur/10;
                if (i1==0 || i%i1!=0){
                    check = false;
                    break;
                }
            }
            if (check){
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int left = 1;int right = 22;
        List<Integer> ans = selfDividingNumbers(left, right);
        System.out.println(ans);
    }

}
