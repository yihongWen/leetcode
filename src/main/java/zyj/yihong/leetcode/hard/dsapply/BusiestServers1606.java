package zyj.yihong.leetcode.hard.dsapply;

import java.util.*;

/**
 * 1606. 找到处理最多请求的服务器
 * 你有 k 个服务器，编号为 0 到 k-1 ，它们可以同时处理多个请求组。每个服务器有无穷的计算能力但是 不能同时处理超过一个请求 。请求分配到服务器的规则如下：
 *
 * 第 i （序号从 0 开始）个请求到达。
 * 如果所有服务器都已被占据，那么该请求被舍弃（完全不处理）。
 * 如果第 (i % k) 个服务器空闲，那么对应服务器会处理该请求。
 * 否则，将请求安排给下一个空闲的服务器（服务器构成一个环，必要的话可能从第 0 个服务器开始继续找下一个空闲的服务器）。比方说，如果第 i 个服务器在忙，那么会查看第 (i+1) 个服务器，第 (i+2) 个服务器等等。
 * 给你一个 严格递增 的正整数数组 arrival ，表示第 i 个任务的到达时间，和另一个数组 load ，其中 load[i] 表示第 i 个请求的工作量（也就是服务器完成它所需要的时间）。你的任务是找到 最繁忙的服务器 。最繁忙定义为一个服务器处理的请求数是所有服务器里最多的。
 *
 * 请你返回包含所有 最繁忙服务器 序号的列表，你可以以任意顺序返回这个列表。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-servers-that-handled-most-number-of-requests
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class BusiestServers1606 {

    public static List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        // 定义数据结构
        int[] request = new int[k];

        // 当前可访问的节点
        TreeSet<Integer> availableNode = new TreeSet<>();

        // 当前在执行任务的节点
        PriorityQueue<int[]> priorityQueue= new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        // 初始化可访问的节点
        for (int i = 0; i < k; i++) {
            availableNode.add(i);
        }

        //遍历计算每个arrival的任务
        for (int i = 0; i < arrival.length; i++) {
            int curArrival = arrival[i];
            int loadTime = load[i];
            // 将当前时间点已经计算完的task，添加到available
            while (!priorityQueue.isEmpty()){
                if (curArrival>=priorityQueue.peek()[1]) {
                    availableNode.add(priorityQueue.poll()[0]);
                    continue;
                }
                break;
            }

            // 找到当前最适合的节点
            if (availableNode.size()==0){
                continue;
            }
            Integer curNode;
            // 找到等于或大于
            curNode = availableNode.ceiling(i % k);
            if (curNode==null){
                curNode = availableNode.first();
            }

            request[curNode]++;
            // 将当前节点添加到执行任务队列中
            priorityQueue.add(new int[]{curNode,curArrival+loadTime});
            availableNode.remove(curNode);
        }

        // 找到最大值
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < request.length; i++) {
            if (request[i]>max){
                max = request[i];
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < request.length; i++) {
            if (request[i]==max){
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
       int k = 2;
       int[] arrival = {1,2,3}; int[] load = {1000000000,1,1000000000};
        List<Integer> integerList = busiestServers(k, arrival, load);
        System.out.println(integerList);
    }
}
