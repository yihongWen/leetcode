package zyj.yihong.leetcode.random_select.seg;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// 1636. 按照频率将数组升序排序
public class FrequencySort_S_1613 {
    public int[] frequencySort(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        Integer[] copyNums = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            copyNums[i] = nums[i];
        }

        Arrays.sort(copyNums,(o1,o2)->{
            Integer num1 = map.get(o1);
            Integer num2 = map.get(o2);

            if (Objects.equals(num1, num2)){
                return o2-o1;
            }

            return num1-num2;

        });

        return Arrays.stream(copyNums).mapToInt(Integer::valueOf).toArray();
    }
}
