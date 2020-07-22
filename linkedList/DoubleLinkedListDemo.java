package com.cbx.linkedList;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleLinkedList list=new DoubleLinkedList();
        HeroNode2 hero1=new HeroNode2(1,"aa","aaa");
        HeroNode2 hero2=new HeroNode2(2,"bb","bbb");
        HeroNode2 hero3=new HeroNode2(3,"cc","ccc");
        HeroNode2 hero4=new HeroNode2(4,"dd","ddd");
//        list.add(hero1);
//        list.add(hero2);
//        list.add(hero3);
//        list.add(hero4);
        list.addByOrder(hero4);
        list.addByOrder(hero3);
        list.addByOrder(hero1);
        list.addByOrder(hero2);
        list.list();
//        list.delete(4);
//        list.list();
    }

}
class DoubleLinkedList{
//   初始化头结点
    private HeroNode2 head=new HeroNode2(0,"","");

    public HeroNode2 getHead() {
        return head;
    }
    /**
     * 显示链表的操作
     */
    public void list(){
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
//        需要一个辅助节点来遍历
        HeroNode2 temp=head.next;
        while (true){
            if (temp==null){
//                遍历到了最后
                break;
            }
//            输出节点信息
            System.out.println(temp);
            temp=temp.next;
        }
    }

    /**
     * 插入节点
     * @param heroNode
     */
    public void add(HeroNode2 heroNode){
//         头结点不能动，需要一个辅助节点
        HeroNode2 temp=head;
        while(true){
            if (temp.next==null){
                break;
            }
            temp=temp.next;
        }
//          退出while循环，保证temp指向了链表的最后
        temp.next=heroNode;
        heroNode.pre=temp;

    }
    /**
     * 修改节点
     */
    public void update(HeroNode2 newHeroNode){
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp=head.next;
        boolean flag=false; //表示是否找到该节点
        while (true){
            if (temp==null){
                break;//链表已经遍历结束
            }
            if (temp.no==newHeroNode.no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag){
            temp.name=newHeroNode.name;
            temp.nickname=newHeroNode.nickname;
        }else {
            System.out.println("没有找到该节点");
        }

    }
    /**
     * 删除节点
     */

    public void delete(int no){
        HeroNode2 temp=head;
        while(true){
            if(temp==null){
                System.out.println("没有该节点");
                return;
            }
            if(temp.no==no){
//                如果是最后一个节点会有问题了
                temp.pre.next=temp.next;
                if(temp.next!=null){
                    temp.next.pre=temp.pre;
                }
                return;
            }
            temp=temp.next;
        }
    }
    /**
     * 根据编号来插入节点
     */
    public void addByOrder(HeroNode2 heroNode) {
        HeroNode2 temp=head;
       while(true){
           if (temp.next==null){
               temp.next=heroNode;
               heroNode.pre=temp;
               return;
           }
           if(temp.next.no>heroNode.no){
//               插入节点
               heroNode.next=temp.next;
               temp.next.pre=heroNode;
               temp.next=heroNode;
               heroNode.pre=temp;
               return;
           }
           temp=temp.next;
       }
    }

}
/**
 * 定义节点
 */
class HeroNode2{
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;
    public HeroNode2 pre;
    public HeroNode2(int no,String name,String nickname){
        this.no=no;
        this.name=name;
        this.nickname=nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
