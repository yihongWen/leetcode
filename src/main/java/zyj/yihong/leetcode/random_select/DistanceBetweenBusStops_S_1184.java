package zyj.yihong.leetcode.random_select;

public class DistanceBetweenBusStops_S_1184 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start>destination){
            int temp = start;
            start = destination;
            destination = temp;
        }

        int tempDis1 = 0;
        for (int i = start; i < destination; i++) {
            tempDis1+=distance[i];
        }

        int tempDis2 = 0;
        for (int i = start; i!=destination;) {
            int index = (i - 1 + distance.length) % distance.length;
            tempDis2+=distance[index];
            i = index;
        }

        return Math.min(tempDis1,tempDis2);

    }
}
