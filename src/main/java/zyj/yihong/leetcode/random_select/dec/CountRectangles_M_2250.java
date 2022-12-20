package zyj.yihong.leetcode.random_select.dec;

import java.util.*;

// 2250. 统计包含每个点的矩形数目
//1 <= rectangles.length, points.length <= 5 * 104
//rectangles[i].length == points[j].length == 2
//1 <= li, xj <= 109
//1 <= hi, yj <= 100
public class CountRectangles_M_2250 {

    // 直接暴力迭代（超出时间范围）
    public static int[] countRectangles1(int[][] rectangles, int[][] points) {
        int[] ans = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            int tmp = 0;
            int[] point = points[i];
            int x = point[0];
            int y = point[1];
            for (int[] rectangle : rectangles) {
                int rx = rectangle[0];
                int ry = rectangle[1];
                if (x <= rx && y <= ry) {
                    tmp++;
                }
            }
            ans[i] = tmp;
        }
        return ans;
    }

    // map+二分查找
    public static int[] countRectangles2(int[][] rectangles, int[][] points) {
        // 使用map cache rect的y轴数据为key，v为list:x
        // 对每个list进行排序作为二分查找
        // 初始化map
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < rectangles.length; i++) {
            int[] rectangle = rectangles[i];
            int x = rectangle[0];
            int y = rectangle[1];
            List<Integer> v = map.getOrDefault(y, new ArrayList<>());
            v.add(x);
            map.put(y, v);
        }
        map.forEach((k, v) -> {
            v.sort(Comparator.comparingInt(o -> o));
        });

        int[] ans = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            int x = point[0];
            int y = point[1];
            int tem = 0;
            for (int j = y; j <= 100; j++) {
                List<Integer> list = map.get(j);
                if (list == null || list.size() == 0) {
                    continue;
                }
                tem += bsearch(list, x);
            }
            ans[i] = tem;
        }
        return ans;
    }

    private static int bsearch(List<Integer> list, int v) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) > v) {
                right = mid;
            } else if (list.get(mid) < v) {
                left = mid + 1;
            } else {
                return list.size() - mid;
            }
        }
        return list.get(right) >= v ? list.size() - right : 0;
    }

    public static int[] countRectangles3(int[][] rectangles, int[][] points) {
        // 逆序适配树状数组

        // 将rectangle中的y作为树状数组，x逆序处理，后一个值不依赖于前一个值的计算
        FrewickTree frewickTree = new FrewickTree(100);

        // 保存每个点index信息，
        int[][] pointsPro = new int[points.length][2];
        for (int i = 0; i < points.length; i++) {
            pointsPro[i] = new int[]{points[i][0], points[i][1], i};
        }

        // 排序
        Arrays.sort(rectangles, (r1, r2) -> r2[0] - r1[0]);
        Arrays.sort(pointsPro, (p1, p2) -> p2[0] - p1[0]);

        int[] ans = new int[points.length];

        // 用于标识存在前多少个方形大于前一个point的x值，优化点
        int memPoint = 0;
        for (int i = 0; i < points.length; i++) {
            int[] pointPro = pointsPro[i];
            int x = pointPro[0];
            while (memPoint< rectangles.length && rectangles[memPoint][0]>=x){
                // 更新树状数组
                frewickTree.add(rectangles[memPoint][1],1);
                memPoint++;
            }

            // 处理完当前节点的数据，如果长方形的y>point的y，此时的数据就是当前的答案
            int curAns = memPoint - frewickTree.query(pointPro[1]-1);
            ans[pointPro[2]] = curAns;
        }
        return ans;

    }

    public static class FrewickTree {
        int[] frewickArr;

        public FrewickTree(int size) {
            frewickArr = new int[size + 1];
        }

        private void add(int index, int value) {
            frewickArr[index] += value;
            int curIndex = index;
            while (curIndex < frewickArr.length) {
                curIndex += lowbit(curIndex);
                if (curIndex < frewickArr.length) {
                    frewickArr[curIndex] += value;
                }
            }
        }

        private int query(int index) {
            int ans = 0;
            ans += frewickArr[index];
            int curIndex = index;
            while (curIndex > 0) {
                curIndex -= lowbit(curIndex);
                ans += frewickArr[curIndex];
            }
            return ans;
        }

        private int lowbit(int x) {
            return x & -x;
        }
    }


    public static void main(String[] args) {
        int[][] rec = {{1, 2}, {2, 3}, {2, 5}};
        int[][] point = {{2, 1}, {1, 4}};

        int[] ints = countRectangles3(rec, point);
        System.out.println(Arrays.toString(ints));

    }
}
