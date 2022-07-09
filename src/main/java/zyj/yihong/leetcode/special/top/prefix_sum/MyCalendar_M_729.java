package zyj.yihong.leetcode.special.top.prefix_sum;

/**
 * 729. 我的日程安排表 I
 * 实现一个 MyCalendar 类来存放你的日程安排。如果要添加的日程安排不会造成 重复预订 ，则可以存储这个新的日程安排。
 *
 * 为了学习线段树，此题使用线段树解决问题
 *
 * 线段树的基本结构
 * 优化：
 * 动态开点+延迟加载
 *
 */
class MyCalendar_M_729 {

    SegmentTree segmentTree;

    public MyCalendar_M_729() {
        int max = (int)1e9;
        segmentTree = new SegmentTree(100);

    }

    public boolean book(int start, int end) {
        // 查询结果：如果start--end段中的和不为0,则意味冲突
        int segSum = segmentTree.query(this.segmentTree.root, start, end-1);
        if (segSum>0){
            return false;
        }

        // 满足日程，则添加
        segmentTree.update(this.segmentTree.root,start,end-1,1);
        return true;
    }


    // 线段树：以树的方式构建（非堆）
    public static class SegmentTree{
        // 线段树的根节点
        Node root;

        public SegmentTree(int max) {
            Node node = new Node();
            node.sectionLeft = 0;
            node.sectionRight = max;
            this.root = node;
        }

        // 查找范围
        public int query(Node curNode,int left,int right){
            // 查询的节点不再区间范围内
            if (left==curNode.sectionLeft&&right== curNode.sectionRight){
                return curNode.sectionSum;
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
            return query(curNode.leftSonNode,left,mid)+query(curNode.rightSonNode,mid+1,right);
        }

        // 更新
        public void update(Node curNode,int left,int right,int value){

            // 如果修该的范围包含curNode的返回时，只需要修改curNode的值，不需要往下修改其下的每一个值
            // 真正的操作只需要延迟到查询,或者更新到该下面范围是才进行修改。
            if (curNode.sectionLeft>=left&&curNode.sectionRight<=right){
                curNode.lazyValue = value;
                curNode.sectionSum = value*(curNode.sectionRight- curNode.sectionLeft+1);
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
            //更新或者查找到某一个区间范围，处理延迟更新，也就是在需要往下递归是，将lazy值处理到下一层
            if (curNode.lazyValue==0){
                return;
            }

            int lazyValue = curNode.lazyValue;
            curNode.leftSonNode.lazyValue = lazyValue;
            curNode.rightSonNode.lazyValue = lazyValue;

            curNode.leftSonNode.sectionSum = (curNode.leftSonNode.sectionRight- curNode.leftSonNode.sectionLeft+1)*lazyValue;
            curNode.rightSonNode.sectionSum = (curNode.rightSonNode.sectionRight- curNode.rightSonNode.sectionLeft+1)*lazyValue;

            curNode.lazyValue = 0;

        }

        private void pushUp(Node curNode){
            curNode.sectionSum = curNode.leftSonNode.sectionSum+ curNode.rightSonNode.sectionSum;
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
        int sectionSum;
        int lazyValue;
        Node leftSonNode;
        Node rightSonNode;
    }


    public static void main(String[] args) {
//        ["MyCalendar","book","book","book","book","book","book","book","book","book","book"]
//[[],[47,50],[33,41],[39,45],[33,42],[25,32],[26,35],[19,25],[3,8],[8,13],[18,27]]
//输出：[null,true,true,true,false,true,false,true,true,true,false]
//预期：[null,true,true,false,false,true,false,true,true,true,false]

//        ["MyCalendar","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book"]
//[[],[23,32],[42,50],[6,14],[0,7],[21,30],[26,31],[46,50],[28,36],[0,6],[27,36],[6,11],[20,25],[32,37],[14,20],[7,16],[13,22],[39,47],[37,46],[42,50],[9,17],[49,50],[31,37],[43,49],[2,10],[3,12],[8,14],[14,21],[42,47],[43,49],[36,43]]
        int[][] arr = {{47,50},{33,41},{39,45},{33,42},{25,32},{26,35},{19,25},{3,8},{8,13},{18,27}};
        MyCalendar_M_729 myCalendar_m_729 = new MyCalendar_M_729();
        for (int[] ints : arr) {
            boolean book = myCalendar_m_729.book(ints[0], ints[1]);
            System.out.println(book);
        }
    }


}
