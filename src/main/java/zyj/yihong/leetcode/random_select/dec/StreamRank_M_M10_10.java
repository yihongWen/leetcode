package zyj.yihong.leetcode.random_select.dec;

// x <= 50000
//track 和 getRankOfNumber 方法的调用次数均不超过 2000 次
public class StreamRank_M_M10_10 {
    // 调用次数2000次远小于x的范围，但是暂时没有很好的离散化方案（因为track是每次调用的，不是一次给定所有数据
    // 使用树状数组，假设x>=0 x<=50000
    private FenwickTree fenwickTree;

    public StreamRank_M_M10_10() {
        fenwickTree = new FenwickTree(50000);
    }

    public void track(int x) {
        fenwickTree.add(x, 1);
    }

    public int getRankOfNumber(int x) {
        return fenwickTree.query(x);
    }


    // 包含0时的特殊处理
    public static class FenwickTree {
        private int[] arr;

        public FenwickTree(int size) {
            this.arr = new int[size + 1];
        }

        private int lowbit(int x) {
            return x & (-x);
        }

        public int query(int index) {
            int ans = 0;
            ans += arr[index];
            if (index == 0) {
                return ans;
            }
            int curIndex = index;
            while (curIndex > 0) {
                curIndex = curIndex - lowbit(curIndex);
                ans += arr[curIndex];
            }
            return ans;
        }

        public void add(int index, int v) {
            arr[index] += v;
            int curIndex = index;
            if (index == 0) {
                return;
            }
            while (true) {
                curIndex = curIndex + lowbit(curIndex);
                if (curIndex < arr.length) {
                    arr[curIndex] += v;
                    continue;
                }
                break;
            }
        }
    }

    public static void main(String[] args) {
//        [0,0,0,null,1,null,null,0,null,null,3,3,null,3,7,3,3,null,null,null]
//        [0,0,0,null,1,null,null,0,null,null,2,2,null,2,6,2,2,null,null,null]
        String[] opt = {"getRankOfNumber", "getRankOfNumber", "getRankOfNumber", "track", "getRankOfNumber", "track", "track", "getRankOfNumber", "track", "track", "getRankOfNumber", "getRankOfNumber", "track", "getRankOfNumber", "getRankOfNumber", "getRankOfNumber", "getRankOfNumber", "track", "track", "track"};
        int[][] arr = {{8}, {6}, {8}, {6}, {7}, {1}, {8}, {0}, {0}, {7}, {2}, {2}, {6}, {5}, {8}, {1}, {4}, {7}, {6}, {1}};
        StreamRank_M_M10_10 streamRank_m_m10_10 = new StreamRank_M_M10_10();
        for (int i = 0; i < opt.length; i++) {
            String s = opt[i];
            if (s.equals("getRankOfNumber")) {
                int rankOfNumber = streamRank_m_m10_10.getRankOfNumber(arr[i][0]);
                System.out.println(rankOfNumber);
            } else if (s.equals("track")) {
                streamRank_m_m10_10.track(arr[i][0]);
            }
        }
    }




}
