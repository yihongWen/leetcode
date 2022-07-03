package zyj.yihong.leetcode.mid.arr;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 954. 二倍数对数组
 * 给定一个长度为偶数的整数数组 arr，只有对 arr 进行重组后可以满足 “对于每个 0 <= i < len(arr) / 2，都有 arr[2 * i + 1] = 2 * arr[2 * i]” 时，返回 true；否则，返回 false。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/array-of-doubled-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class CanReorderDoubled954 {
    public static boolean canReorderDoubled(int[] arr) {
        // 问题转换：数组中每个数字x（一半的元素）都有一个与其对应的y = 2x
        // 特殊点：0、以及存在两个同样的数子、以及负数

        Map<Integer,Integer> numCountMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            numCountMap.put(arr[i],numCountMap.getOrDefault(arr[i],0)+1);
        }

        if (numCountMap.getOrDefault(0, 0) % 2 != 0){
            return false;
        }
        numCountMap.remove(0);
        List<Integer> distNum = numCountMap.keySet().stream().sorted(Comparator.comparingInt(Math::abs)).collect(Collectors.toList());

        for (int i = 0; i < distNum.size(); i++) {
            Integer num = distNum.get(i);
            if (numCountMap.getOrDefault(2*num,0)<numCountMap.get(num)){
                return false;
            }
            numCountMap.put(2*num,numCountMap.getOrDefault(2*num,0)-numCountMap.get(num));
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {4,-2,2,-4};
        boolean b = canReorderDoubled(arr);
        System.out.println(b);

    }
}
