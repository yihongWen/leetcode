package zyj.yihong.leetcode.random_select.seg;

import java.util.LinkedList;
import java.util.Queue;

// 547. 省份数量
public class FindCircleNum_M_547 {
    public static int findCircleNum(int[][] isConnected) {
        int province = 0;

        Queue<Integer> queue = new LinkedList<>();

        // 遍历每一个城市
        for (int i = 0; i < isConnected.length; i++) {
            // 判断当前城市是否处理过
            if (isConnected[i][i]==0){
                continue;
            }

            queue.add(i);
            province++;
            while (!queue.isEmpty()){
                Integer curCity = queue.poll();
                isConnected[curCity][curCity] = 0;
                for (int j = 0; j < isConnected.length; j++) {
                    if (isConnected[curCity][j]==1&&isConnected[j][j]==1){
                        queue.add(j);
                        isConnected[j][j] = 0;
                    }
                }
            }
        }

        return province;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,1,0},{1,1,0},{0,0,1}};
        int circleNum = findCircleNum(arr);
        System.out.println(circleNum);
    }

}
