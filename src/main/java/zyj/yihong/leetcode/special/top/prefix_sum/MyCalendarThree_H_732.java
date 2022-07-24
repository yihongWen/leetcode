package zyj.yihong.leetcode.special.top.prefix_sum;

public class MyCalendarThree_H_732 {

    private SegmentTree segmentTree;
        public MyCalendarThree_H_732() {
            int max = (int)1e9;
            segmentTree = new SegmentTree(max);
        }

        public int book(int start, int end) {
            segmentTree.update(segmentTree.root, start,end-1,1);
            return segmentTree.root.sectionNodeMaxValue;
        }

    public static class SegmentTree{
        // 线段树的根节点
        Node root;

        public SegmentTree(int max) {
            Node node = new Node();
            node.sectionLeft = 0;
            node.sectionRight = max;
            this.root = node;
        }

        public int query(Node curNode, int left, int right){
            // 查询的节点不再区间范围内
            if (left==curNode.sectionLeft&&right== curNode.sectionRight){
                return curNode.sectionNodeMaxValue;
            }

            // 创建子节点
            lazyCreate(curNode);

            // 处理当前节点的lazyValue
            pushDown(curNode);

            // 递归的查询
            int mid = curNode.sectionLeft + ((curNode.sectionRight - curNode.sectionLeft) >> 1);
            if (mid>=right){
                return query(curNode.leftSonNode,left,right);
            }else if (left>mid){
                return query(curNode.rightSonNode,left,right);
            }
            return Math.max(query(curNode.leftSonNode,left,mid),query(curNode.rightSonNode,mid+1,right));
        }

        // 更新
        public void update(Node curNode, int left, int right, int value){

            // 如果修该的范围包含curNode的返回时，只需要修改curNode的值，不需要往下修改其下的每一个值
            // 真正的操作只需要延迟到查询,或者更新到该下面范围是才进行修改。
            if (curNode.sectionLeft>=left&&curNode.sectionRight<=right){
                curNode.lazyValue += value;
                curNode.sectionNodeMaxValue += value;
                return;
            }

            // 创建子节点
            lazyCreate(curNode);

            // 处理当前节点的lazyValue
            pushDown(curNode);


            // 递归的更新
            int mid = curNode.sectionLeft + ((curNode.sectionRight - curNode.sectionLeft) >> 1);
            if (mid>=right){
                update(curNode.leftSonNode,left,right,value);
            }else if (left>mid){
                update(curNode.rightSonNode,left,right,value);
            }else {
                update(curNode.leftSonNode, left, mid, value);
                update(curNode.rightSonNode, mid + 1, right, value);
            }

            //计算完子节点后 更新当前节点的值
            pushUp(curNode);

        }

        private void pushDown(Node curNode){
            if (curNode.lazyValue==0){
                return;
            }

            int lazyValue = curNode.lazyValue;
            curNode.leftSonNode.lazyValue+=lazyValue;
            curNode.rightSonNode.lazyValue+=lazyValue;


            curNode.leftSonNode.sectionNodeMaxValue +=lazyValue;
            curNode.rightSonNode.sectionNodeMaxValue += lazyValue;
            curNode.lazyValue = 0;

        }

        private void pushUp(Node curNode){
            curNode.sectionNodeMaxValue = Math.max(curNode.leftSonNode.sectionNodeMaxValue ,curNode.rightSonNode.sectionNodeMaxValue);
        }

        private void lazyCreate(Node curNode){
            if (curNode.leftSonNode==null){
                Node node = new Node();
                curNode.leftSonNode = node;
                node.sectionLeft = curNode.sectionLeft;
                node.sectionRight = curNode.sectionLeft+ ((curNode.sectionRight- curNode.sectionLeft)>>1);
            }

            if (curNode.rightSonNode==null){
                Node node = new Node();
                curNode.rightSonNode = node;
                node.sectionLeft = curNode.sectionLeft+ ((curNode.sectionRight- curNode.sectionLeft)>>1)+1;
                node.sectionRight = curNode.sectionRight;
            }
        }
    }

    // 树中的每一个节点
    public static class Node{
        // 一个节点所包含的属性：区间范围、区间和、延迟更新的值、左右子节点
        int sectionLeft;
        int sectionRight;
        int sectionNodeMaxValue;
        int lazyValue;
        Node leftSonNode;
        Node rightSonNode;
    }

    public static void main(String[] args) {
//        ["MyCalendarThree","book","book","book","book","book","book"]
//[[],[10,20],[50,60],[10,40],[5,15],[5,10],[25,55]]
        MyCalendarThree_H_732 myCalendarTwo_731 = new MyCalendarThree_H_732();
        int[][] arr = {{10,20},{50,60},{10,40},{5,15},{5,10},{25,55}};
        for (int[] ints : arr) {
             int book = myCalendarTwo_731.book(ints[0], ints[1]);
            System.out.println(book);
        }

//        [null,1,1,2,3,4,2]
//        [null,1,1,2,3,3,3]
    }
}
