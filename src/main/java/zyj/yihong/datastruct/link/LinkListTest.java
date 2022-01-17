package zyj.yihong.datastruct.link;

/**
 * 测试
 * @author yihong
 */
public class LinkListTest {
    public static void main(String[] args) {
        int[] testArr = {1,2,3,4,5};

        LinkList linkList = new LinkList(testArr);
        linkList.printf();
        linkList.add(6,3);
        linkList.printf();
        linkList.remove(0);
        linkList.printf();
        linkList.remove(3);
        linkList.printf();

    }
}
