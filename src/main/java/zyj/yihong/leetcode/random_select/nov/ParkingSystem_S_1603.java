package zyj.yihong.leetcode.random_select.nov;

public class ParkingSystem_S_1603 {

    int[] parkingInfo = new int[6];

    public ParkingSystem_S_1603(int big, int medium, int small) {
        parkingInfo[0] = big;
        parkingInfo[1] = medium;
        parkingInfo[2] = small;
    }

    public boolean addCar(int carType) {
        int realType = carType - 1;
        if (parkingInfo[realType]>parkingInfo[realType+3]){
            parkingInfo[realType+3]++;
            return true;
        }
        return false;
    }
}
