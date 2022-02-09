package zyj.yihong.design.jczh.combination;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * 使用组合的方式实现
 * @author yihong
 */
public class MyCombinationHashSet<E> implements Set<E> {

    private final Set<E> combinationSet;

    public int getCount() {
        return count;
    }

    private volatile int count = 0;

    public MyCombinationHashSet(Set<E> combinationSet) {
        this.combinationSet = combinationSet;
    }

    @Override
    public int size() {
        return combinationSet.size();
    }

    @Override
    public boolean isEmpty() {
        return combinationSet.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return combinationSet.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return combinationSet.iterator();
    }

    @Override
    public Object[] toArray() {
        return combinationSet.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return combinationSet.toArray(a);
    }

    @Override
    public boolean add(E e) {
        count++;
        return combinationSet.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return combinationSet.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return combinationSet.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        count = count+c.size();
        return combinationSet.addAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return combinationSet.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return combinationSet.retainAll(c);
    }

    @Override
    public void clear() {
        combinationSet.clear();
    }
}
