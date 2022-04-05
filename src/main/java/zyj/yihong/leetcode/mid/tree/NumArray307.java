package zyj.yihong.leetcode.mid.tree;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import sun.jvm.hotspot.utilities.Assert;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 307. 区域和检索 - 数组可修改
 * 给你一个数组 nums ，请你完成两类查询。
 *
 * 其中一类查询要求 更新 数组 nums 下标对应的值
 * 另一类查询要求返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 ，其中 left <= right
 * 实现 NumArray 类：
 *
 * NumArray(int[] nums) 用整数数组 nums 初始化对象
 * void update(int index, int val) 将 nums[index] 的值 更新 为 val
 * int sumRange(int left, int right) 返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 （即，nums[left] + nums[left + 1], ..., nums[right]）
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-mutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@State(Scope.Benchmark)
public class NumArray307 {

    public int[] sumTree;
    public int arrSize;
    public int[] arr;
    @Param({"1","10000"})
    private int left;
    @Param({"1000000"})
    private int right;

    public NumArray307() {
    }

    /**
     * 初始化线段树
     */
    @Setup
    public void NumArrayInit() {
        int[] nums = new int[1000001];
        Random random = new Random();
        for (int i = 0; i < 1000001; i++) {
            nums[i] = random.nextInt(100);
        }
        arr = nums;
        sumTree = new int[nums.length*4];
        arrSize = nums.length;

        // 构建线段树:计算每个点代表的区间和
        init(nums,0,0, arrSize-1);
    }

    public void init(int[] nums,int curIndex,int start,int end){
        // 如果start = end，则不可拆分
        if (start==end){
            sumTree[curIndex] = nums[start];
            return;
        }
        // 计算中间节点
        int mid = (start + end) / 2;
        init(nums,curIndex*2+1,start,mid);
        init(nums,curIndex*2+2,mid+1,end);
        sumTree[curIndex] = sumTree[curIndex*2+1]+sumTree[curIndex*2+2];
    }

    public void update(int index, int val) {
        // 更新一个值，会导致包含index的区间值发生变化
        updateSum(index,val,0,0,arrSize-1);
    }

    public void updateSum(int updateIndex,int updateValue,int curIndex,int start,int end){
        // 遍历到当前最小节点
        if (start==end){
            sumTree[curIndex] = updateValue;
            return;
        }

        // 计算中间
        int mid = (start + end) / 2;

        // 遍历子节点
        if (updateIndex<=mid){
            updateSum(updateIndex,updateValue,curIndex*2+1,start,mid);
        }else {
            updateSum(updateIndex,updateValue,curIndex*2+2,mid+1,end);
        }

        // 遍历子节点完成，计算当前节点
        sumTree[curIndex] = sumTree[curIndex*2+1]+sumTree[curIndex*2+2];
    }

    @Benchmark
    @BenchmarkMode({Mode.AverageTime,Mode.Throughput})
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Warmup(iterations = 5)
    public int sumRange() {
        return calSum(left, right, 0, 0, arrSize - 1);
    }


    public int calSum(int left,int right,int curIndex,int start,int end){
        // 如果当前left-right == start-end,直接返回结果
        if (left==start&&right==end) {
            return sumTree[curIndex];
        }

        // 计算中节点
        int mid = (start + end) / 2;
        // 判断是处于左侧、右侧，还是处于两侧之间
        if (mid>=right){
            return calSum(left,right,curIndex*2+1,start,mid);
        }else if (left>mid){
            return calSum(left,right,curIndex*2+2,mid+1,end);
        }else {
            return calSum(left,mid,curIndex*2+1,start,mid)+
                    calSum(mid+1,right,curIndex*2+2,mid+1,end);
        }
    }

    @Benchmark
    @BenchmarkMode({Mode.AverageTime,Mode.Throughput})
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Warmup(iterations = 5)
    public int cal(){
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum+= arr[i];
        }
        return sum;
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(NumArray307.class.getSimpleName())
                .forks(1)
                .resultFormat(ResultFormatType.JSON)
                .result("tree_or_liner.json")
                .build();

        new Runner(opt).run();
    }
}