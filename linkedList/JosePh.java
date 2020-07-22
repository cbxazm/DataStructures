package com.cbx.linkedList;

/**
 * 模拟小孩围圈报数的约瑟夫问题
 */
public class JosePh {
    public static void main(String[] args) {
        CirecleSingleLinkedList list = new CirecleSingleLinkedList();
        list.addBoy(5);
        list.showBoy();
        list.countBoy(1,2,5);


    }
}
//创建环形链表
class CirecleSingleLinkedList{
//    创建一个first节点
    private Boy first=null;
//添加节点,形成一个环形链表
    public void  addBoy(int num){
        if (num<1){
            System.out.println("传入编号不正确");
        }
        Boy curBoy=null;//辅助指针
        for (int i=1;i<=num;i++){
           Boy boy=new Boy(i);
//           第一个节点特殊
           if (i==1){
               first=boy;
               first.setNext(first);
               curBoy=first; //让curBoy指向第一个小孩
           }else {
               curBoy.setNext(boy);
               boy.setNext(first);
               curBoy=boy;//让curBoy指向该节点
           }


        }
    }
    /**
     * 遍历当前的环形链表
     */
    public void showBoy(){
        if (first==null){
            System.out.println("链表为空");
            return;
        }
        Boy curBoy=first;
        while (true){
            System.out.println(curBoy);
            if (curBoy.getNext()==first){
                 break;
            }
            curBoy=curBoy.getNext(); //后移
        }

    }
//    根据用户的输入，计算出小孩的出圈顺序
    /**
     *
     * @param startNo  表示从第几个小孩开始数数
     * @param countNum 表示数几下
     * @param nums  表示有多少小孩在圈中
     */
    public void countBoy(int startNo,int countNum,int nums){
       if (first==null||startNo<1||startNo>nums){
           System.out.println("参数有误");
           return;
       }
//       创建辅助指针helper,事先指向环形链表的最后(helper的之前一个节点)
        Boy helper=first;
       while (true){
           if (helper.getNext()==first){
               break;
           }
           helper=helper.getNext();
       }
//       报数前，先移动firstNo-1次，因为不是非要从第一个开始报数
        for (int i = 0; i < startNo - 1; i++) {
            first=first.getNext();
            helper=helper.getNext();
        }
        while (true){
            if (helper==first){
                //说明圈中只有一个人
                break;
            }
            for (int j=0;j<countNum-1;j++){
                //自身也要报数一次
                first=first.getNext();
                helper=helper.getNext();
            }
            //此时first指向的节点就是，要出圈的节点
            System.out.println("小孩"+first.getNo()+"出圈");
            first=first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后留在圈中的小孩是"+first.getNo());


    }

}
//表示节点
class Boy{
    private int no;
    private Boy next;
    public Boy(int no){
        this.no=no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}