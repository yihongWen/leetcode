package zyj.yihong.leetcode.mid.dsapply;

import java.util.*;

/**
 * 380. O(1) 时间插入、删除和获取随机元素
 */
public class RandomizedSet380 {
    private List<Integer> numList;
    private Map<Integer,Integer> indexNumMap;
    private Random random;

    public RandomizedSet380() {
        numList = new ArrayList<>();
        indexNumMap = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (indexNumMap.containsKey(val)){
            return false;
        }

        numList.add(val);
        indexNumMap.put(val,numList.size()-1);
        return true;
    }

    public boolean remove(int val) {
        if (!indexNumMap.containsKey(val)){
            return false;
        }

        Integer index = indexNumMap.get(val);
        // swap lastIndex
        Integer lastNum = numList.get(numList.size() - 1);
        numList.set(index,lastNum);
        indexNumMap.put(lastNum,index);


        numList.remove(numList.size()-1);
        indexNumMap.remove(val);
        return true;
    }

    public int getRandom() {
        int size = numList.size();
        int index = random.nextInt(size);
        return numList.get(index);
    }

    public static void main(String[] args) {
        RandomizedSet380 randomizedSet380 = new RandomizedSet380();
        randomizedSet380.insert(1);
        randomizedSet380.remove(2);
        randomizedSet380.insert(2);
        int random = randomizedSet380.getRandom();
        randomizedSet380.remove(1);
        randomizedSet380.insert(2);
        int random1 = randomizedSet380.getRandom();
        System.out.println();
//        输入
//["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
//[[], [1], [2], [2], [], [1], [2], []]

    }
}
