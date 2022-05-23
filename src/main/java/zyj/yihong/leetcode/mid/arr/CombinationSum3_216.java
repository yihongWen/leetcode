package zyj.yihong.leetcode.mid.arr;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 *
 * 只使用数字1到9
 * 每个数字 最多使用一次 
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSum3_216 {
    List<Integer> curAns = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        // 使用二进制位
        int bitNum = (1<<9)-1;
        for (int i = 0; i <= bitNum ; i++) {
            if (check(k,n,i)){
                ans.add(new ArrayList<>(curAns));
            }
        }
        return ans;
    }

    public boolean check(int k,int n,int curBitNum){
        curAns.clear();
        int optNum = 1;
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int opt = optNum << i;
            if ((curBitNum&opt)!=0){
                curAns.add(i+1);
                sum+=(i+1);
            }
        }

        if (curAns.size()!=k){
            return false;
        }

        if (sum!=n){
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        CombinationSum3_216 combinationSum3_216 = new CombinationSum3_216();
        List<List<Integer>> lists = combinationSum3_216.combinationSum3(3, 7);
        System.out.println(lists);
    }
}
