package zyj.yihong.leetcode.mid.queue;

import com.google.gson.Gson;
import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * 剑指 Offer 59 - II. 队列的最大值
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 *
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxQueue_J2_59 {

    private Queue<Integer> dataQueue;
    private Deque<Integer> maxValueQueue;
    public MaxQueue_J2_59() {
        dataQueue = new LinkedList<>();
        maxValueQueue = new LinkedList<>();
    }

    public int max_value() {
        return maxValueQueue.isEmpty()?-1:maxValueQueue.peekFirst();
    }

    public void push_back(int value) {
        if ((!maxValueQueue.isEmpty())&&maxValueQueue.peekLast()<value){
            maxValueQueue.pollLast();
        }

        dataQueue.offer(value);
        maxValueQueue.offerLast(value);
    }

    public int pop_front() {
        if (dataQueue.isEmpty()){
            return -1;
        }
        int poll = dataQueue.poll();
        if (poll==maxValueQueue.peekFirst()){
            maxValueQueue.pollFirst();
        }
        return poll;
    }

    public static void main(String[] args) {
        MaxQueue_J2_59 maxQueue_j2_59 = null;
        Gson gson = new Gson();
        String s = "[\"MaxQueue\",\"max_value\",\"pop_front\",\"max_value\",\"push_back\",\"max_value\",\"pop_front\",\"max_value\",\"pop_front\",\"push_back\",\"pop_front\",\"pop_front\",\"pop_front\",\"push_back\",\"pop_front\",\"max_value\",\"pop_front\",\"max_value\",\"push_back\",\"push_back\",\"max_value\",\"push_back\",\"max_value\",\"max_value\",\"max_value\",\"push_back\",\"pop_front\",\"max_value\",\"push_back\",\"max_value\",\"max_value\",\"max_value\",\"pop_front\",\"push_back\",\"push_back\",\"push_back\",\"push_back\",\"pop_front\",\"pop_front\",\"max_value\",\"pop_front\",\"pop_front\",\"max_value\",\"push_back\",\"push_back\",\"pop_front\",\"push_back\",\"push_back\",\"push_back\",\"push_back\",\"pop_front\",\"max_value\",\"push_back\",\"max_value\",\"max_value\",\"pop_front\",\"max_value\",\"max_value\",\"max_value\",\"push_back\",\"pop_front\",\"push_back\",\"pop_front\",\"max_value\",\"max_value\",\"max_value\",\"push_back\",\"pop_front\",\"push_back\",\"push_back\",\"push_back\",\"pop_front\",\"max_value\",\"pop_front\",\"max_value\",\"max_value\",\"max_value\",\"pop_front\",\"push_back\",\"pop_front\",\"push_back\",\"push_back\",\"pop_front\",\"push_back\",\"pop_front\",\"push_back\",\"pop_front\",\"pop_front\",\"push_back\",\"pop_front\",\"pop_front\",\"pop_front\",\"push_back\",\"push_back\",\"max_value\",\"push_back\",\"pop_front\",\"push_back\",\"push_back\",\"pop_front\"]";
        List<String> list = gson.fromJson(s, List.class);
        String s1 = "[[],[],[],[],[46],[],[],[],[],[868],[],[],[],[525],[],[],[],[],[123],[646],[],[229],[],[],[],[871],[],[],[285],[],[],[],[],[45],[140],[837],[545],[],[],[],[],[],[],[561],[237],[],[633],[98],[806],[717],[],[],[186],[],[],[],[],[],[],[268],[],[29],[],[],[],[],[866],[],[239],[3],[850],[],[],[],[],[],[],[],[310],[],[674],[770],[],[525],[],[425],[],[],[720],[],[],[],[373],[411],[],[831],[],[765],[701],[]]";
        List<List> list1 = gson.fromJson(s1, List.class);

        for (int i = 0; i < list.size(); i++) {
            String s2 = list.get(i);
            if (Objects.equals(s2, "MaxQueue")){
                maxQueue_j2_59 = new MaxQueue_J2_59();
                System.out.println("null");
            }else if (Objects.equals(s2, "max_value")){
                int i1 = maxQueue_j2_59.max_value();
                System.out.println(i1);
            }else if (Objects.equals(s2, "pop_front")){
                int i1 = maxQueue_j2_59.pop_front();
                System.out.println(i1);
            }else if (Objects.equals(s2, "push_back")){
                List list2 = list1.get(i);
                Object o = list2.get(0);
                double v = Double.parseDouble(o.toString());
                maxQueue_j2_59.push_back((int)v);
                System.out.println("null");
            }
        }
    }
}
