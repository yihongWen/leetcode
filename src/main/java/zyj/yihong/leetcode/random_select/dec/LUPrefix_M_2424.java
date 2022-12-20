package zyj.yihong.leetcode.random_select.dec;

public class LUPrefix_M_2424 {
    //（单点更新、区间查询） 使用树状数组+逼近的方式处理
    private FrewickTree frewickTree;
    int n;
    public LUPrefix_M_2424(int n) {
        this.frewickTree = new FrewickTree(n);
        this.n = n;
    }

    public void upload(int video) {
        frewickTree.add(video,1);
    }

    public int longest() {
        int right = n;
        int left = 1;
        while (left<=right){
            int mid = left+(right-left)/2;
            int num = frewickTree.query(mid);
            if (num==mid){
                left = mid+1;
            }else if (num<mid){
                right = mid-1;
            }
        }

        return right;
    }

    // 树状数组
    public static class FrewickTree{
        int[] frewickArr;

        public FrewickTree(int size) {
            frewickArr = new int[size+1];
        }

        private void add(int index,int value){
            frewickArr[index]+=value;
            int curIndex = index;
            while (curIndex<frewickArr.length){
                curIndex+=lowbit(curIndex);
                if (curIndex< frewickArr.length){
                    frewickArr[curIndex]+=value;
                }
            }
        }

        private int query(int index){
            int ans = 0;
            ans+= frewickArr[index];
            int curIndex = index;
            while (curIndex>0){
                curIndex-=lowbit(curIndex);
                ans+=frewickArr[curIndex];
            }
            return ans;
        }

        private int lowbit(int x){
            return x&-x;
        }
    }

    public static void main(String[] args) {
        LUPrefix_M_2424 luPrefix_m_2424 = null;
        String[] optArr = {"LUPrefix","upload","longest","upload","longest","upload","longest"};
        int[][] numArr =  {{4},{3},{},{1},{},{2},{}};
        for (int i = 0; i < optArr.length; i++) {
            String s = optArr[i];
            if (s.equals("LUPrefix")){
                luPrefix_m_2424 = new LUPrefix_M_2424(numArr[i][0]);
            }else if (s.equals("upload")){
                luPrefix_m_2424.upload(numArr[i][0]);
            }else if (s.equals("longest")){
                int longest = luPrefix_m_2424.longest();
                System.out.println(longest);
            }
        }

        System.out.println("-------end---------");
    }
}
