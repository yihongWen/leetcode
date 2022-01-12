package zyj.yihong.datastruct.vector;

public class VectorTest {
    public static void main(String[] args) {
        Integer[] test = {1,4,6,2,3};
        VectorStruct vectorStruct = new VectorStruct(test);
        System.out.println(vectorStruct.toString());
        System.out.println(vectorStruct.get(3));

        vectorStruct.add(12,0);
        System.out.println(vectorStruct.toString());
        vectorStruct.add(10,3);
        System.out.println(vectorStruct.toString());
        vectorStruct.delete(1);
        System.out.println(vectorStruct.getVectorSize());
        System.out.println(vectorStruct.toString());

        vectorStruct.sort(false);
        System.out.println(vectorStruct.toString());







    }
}
