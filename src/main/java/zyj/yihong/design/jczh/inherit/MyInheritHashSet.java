package zyj.yihong.design.jczh.inherit;

import java.util.Collection;
import java.util.HashSet;

/**
 * 统计往hashSet添了元素
 * 使用继承的方式实现
 * @author yihong
 * @param <E>
 */
public class MyInheritHashSet<E> extends HashSet<E> {

    private volatile int count = 0;

    @Override
    public boolean add(E e) {
        count++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        count = count+c.size();
        return super.addAll(c);
    }

    public boolean myAddAll(Collection<? extends E> c) {
        boolean modified = false;
        for (E e : c) {
            if (add(e)) {
                modified = true;
            }
        }
        return modified;
    }

    public int getCount(){
        return count;
    }
}
