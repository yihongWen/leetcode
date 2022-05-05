package zyj.yihong.leetcode.mid.arr;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class NestedIterator341 implements Iterator<Integer> {
    // 树状结构，所有的叶子节点，保存到List,利用list的迭代器实验
    private List<Integer> allIntegerList;
    private Iterator<Integer> iterator;

    public NestedIterator341(List<NestedInteger> nestedList) {
        allIntegerList = new ArrayList<>();
        dfs(nestedList);
        iterator = allIntegerList.iterator();
    }

    @Override
    public Integer next() {
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    private void dfs(List<NestedInteger> nestedList){
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()){
                allIntegerList.add(nestedInteger.getInteger());
            }else {
                dfs(nestedInteger.getList());
            }
        }
    }
}


interface NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}
