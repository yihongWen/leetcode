package zyj.yihong.datastruct.vector;

import java.util.Arrays;

/**
 * 线性表 为了简单实现，只考虑Integer类型
 *
 * @author yihong
 */
public class VectorStruct {
    private Integer[] vectorArr;


    /**
     * 初始化线性表
     *
     * @param initArr 给定要初始的内容
     */
    public VectorStruct(Integer[] initArr) {
        if (initArr != null) {
            this.vectorArr = new Integer[initArr.length];
            System.arraycopy(initArr, 0, this.vectorArr, 0, initArr.length);
        } else {
            this.vectorArr = new Integer[0];
        }
    }


    public VectorStruct() {
        this.vectorArr = new Integer[0];
    }

    /**
     * 获取线性表的大小
     *
     * @return
     */
    public int getVectorSize() {
        return vectorArr.length;
    }

    /**
     * 往线性表中加入元素
     *
     * @param data  插入线性表的数据
     * @param index 插入的位置
     */
    public void add(Integer data, int index) {
        if (index < 0 || index > vectorArr.length) {
            throw new RuntimeException("插入的index不正确");
        }

        // 对数组进行扩容
        this.vectorArr = Arrays.copyOf(this.vectorArr, this.vectorArr.length + 1);
        if (index == this.vectorArr.length - 1) {
            this.vectorArr[index] = data;
            return;
        }

        for (int i = this.vectorArr.length - 2; i >= 0; i--) {
            this.vectorArr[i + 1] = this.vectorArr[i];
            if (i == index) {
                this.vectorArr[i] = data;
                return;
            }
        }
    }

    public Integer get(int index) {
        if (index >= this.vectorArr.length || index < 0) {
            throw new RuntimeException("给定下标不合法...");
        }
        return this.vectorArr[index];
    }

    public void delete(int index) {
        // 删除指定index的元素
        if (index >= this.vectorArr.length || index < 0) {
            throw new RuntimeException("给定下标不合法...");
        }

        for (int i = index + 1; i < this.vectorArr.length; i++) {
            this.vectorArr[i - 1] = this.vectorArr[i];
        }

        // 压缩删除出来的空位
        this.vectorArr = Arrays.copyOf(this.vectorArr, this.vectorArr.length - 1);
    }

    /**
     * 排序线性表
     *
     * @param asc 是否升序
     */
    public void sort(boolean asc) {
        Arrays.sort(this.vectorArr, (a, b) -> {
            if (a > b) {
                if (asc) {
                    return 1;
                } else {
                    return -1;
                }
            } else if (a.equals(b)) {
                return 0;
            } else {
                if (asc) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
    }


    @Override
    public String toString() {
        return Arrays.toString(vectorArr);
    }
}
