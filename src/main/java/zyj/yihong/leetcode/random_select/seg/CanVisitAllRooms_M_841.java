package zyj.yihong.leetcode.random_select.seg;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 841. 钥匙和房间
public class CanVisitAllRooms_M_841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] flag = new boolean[rooms.size()];
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        queue.add(0);
        while (!queue.isEmpty()){
            Integer curRoomNum = queue.poll();
            if (flag[curRoomNum]){
                continue;
            }

            flag[curRoomNum] = true;
            count++;

            if (count==rooms.size()){
                return true;
            }
            List<Integer> roomKeyList = rooms.get(curRoomNum);
            for (Integer curKey : roomKeyList) {
                if (flag[curKey]){
                    continue;
                }

                queue.add(curKey);
            }
        }

        return false;

    }
}
