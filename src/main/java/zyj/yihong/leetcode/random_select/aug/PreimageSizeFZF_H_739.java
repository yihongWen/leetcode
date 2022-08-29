package zyj.yihong.leetcode.random_select.aug;

// 793. 阶乘函数后 K 个零
//  f(x) 是 x! 末尾是 0 的数量。回想一下 x! = 1 * 2 * 3 * ... * x，且 0! = 1 。
//
//例如， f(3) = 0 ，因为 3! = 6 的末尾没有 0 ；而 f(11) = 2 ，因为 11!= 39916800 末端有 2 个 0 。
//给定 k，找出返回能满足 f(x) = k 的非负整数 x 的数量。
//
//来源：力扣（LeetCode）
//链接：https://leetcode.cn/problems/preimage-size-of-factorial-zeroes-function
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class PreimageSizeFZF_H_739 {
    public int preimageSizeFZF(int k) {
        // 找到个数为k+1的数字x  以及个数为k的y, 结果则为 x-y（结果一定是等于5的）
        if (k==0){
            return 5;
        }

        return binarySearch(k+1)-binarySearch(k);

    }

    private int binarySearch(int k){
        int left = 0;

        int right = 5*k;
        while (left<right){
            int mid = left+((right-left)>>1);
            int zeroCount = getZeroCount(mid);
            if (zeroCount<k){
                left = mid+1;
            }else {
                right = mid;
            }
        }
        return left;
    }

    private int getZeroCount(int x){
        int ans = 0;
        while (x>=5){
            ans+=x/5;
            x=x/5;
        }
        return ans;
    }

    public static void main(String[] args) {
        PreimageSizeFZF_H_739 preimageSizeFZF_h_739 = new PreimageSizeFZF_H_739();
        int i = preimageSizeFZF_h_739.preimageSizeFZF(5);
        System.out.println(i);
    }


}
