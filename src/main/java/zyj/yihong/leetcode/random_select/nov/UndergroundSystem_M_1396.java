package zyj.yihong.leetcode.random_select.nov;

import java.util.HashMap;
import java.util.Map;

public class UndergroundSystem_M_1396 {

    Map<String,Object[]> startEndMap = new HashMap<>();
    Map<Integer,Object[]> entryMap = new HashMap<>();
    public UndergroundSystem_M_1396() {

    }

    public void checkIn(int id, String stationName, int t) {
        Object[] objects = new Object[]{stationName,t};
        entryMap.put(id,objects);
    }

    public void checkOut(int id, String stationName, int t) {
        Object[] objects = entryMap.get(id);
        String entryName=(String) objects[0];
        Integer entryTime = (Integer) objects[1];
        String key = entryName+"_"+stationName;
        Object[] startEndInfo = startEndMap.get(key);
        int spentTime = t - entryTime;
        if (startEndInfo==null){
            int count =1;
            Object[] info = new Object[]{spentTime,count};
            startEndMap.put(key,info);
            return;
        }

        int curAllTime = (int) startEndInfo[0];
        curAllTime+=spentTime;
        startEndInfo[0] = curAllTime;

        int curCount = (int)startEndInfo[1];
        curCount++;
        startEndInfo[1] = curCount;
        startEndMap.put(key,startEndInfo);

    }

    public double getAverageTime(String startStation, String endStation) {
        Object[] objects = startEndMap.get(startStation + "_" + endStation);
        return (double)((int)objects[0])/(int)objects[1];
    }

}
