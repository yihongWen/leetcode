package zyj.yihong.leetcode.simple.other;

import java.util.*;

/**
 * 599. 两个列表的最小索引总和
 * 假设 Andy 和 Doris 想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 * <p>
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设答案总是存在。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindRestaurant599 {
    public static String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        int bestIndex = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            String s = list2[i];
            if (!map.containsKey(s)) {
                continue;
            }

            Integer list1Index = map.get(s);
            if (list1Index + i < bestIndex) {
                resultList.clear();
                resultList.add(s);
                bestIndex = list1Index+i;
            } else if (list1Index + i == bestIndex) {
                resultList.add(s);
            }
        }

        return resultList.toArray(new String[0]);

    }

    public static void main(String[] args) {
//        ["Shogun","Tapioca Express","Burger King","KFC"]
//["KFC","Shogun","Burger King"]
        String[] list1 = {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] list2 = {"KFC","Shogun","Burger King"};
        String[] restaurant = findRestaurant(list1, list2);
        System.out.println(Arrays.toString(restaurant));

    }
}
