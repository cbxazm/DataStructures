package com.cbx.linkedList;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
       SingleLinkedList list=new SingleLinkedList();
       list.addByOrder(new HeroNode(1,"宋江","及时雨"));
        list.addByOrder(new HeroNode(3,"吴用","智多星"));
       list.addByOrder(new HeroNode(2,"卢俊义","玉麒麟"));
        HeroNode head = list.getHead();
//        SingleLinkedList.reverse(head);
//        SingleLinkedList.reverse2(head);
        SingleLinkedList.reversePrint(head);
//        list.delete(3);
//       list.delete(2);
//       list.delete(1);
//        System.out.println(head);
//        System.out.println(SingleLinkedList.getLength(head));
//        System.out.println(SingleLinkedList.findLastIndexNode(head,2));

//       list.list();
    }
}
/**
 * 定义链表
 */
class SingleLinkedList{
//    初始化一个头结点 ，不允许操作
    private HeroNode head=new HeroNode(0,"","");
//返回头结点
    public HeroNode getHead() {
        return head;
    }

    /**
 *   不考虑编号的操作
 *   插入节点
  */

     public void add(HeroNode heroNode){
//         头结点不能动，需要一个辅助节点
         HeroNode temp=head;
          while(true){
              if (temp.next==null){
                  break;
              }
              temp=temp.next;
          }
//          退出while循环，保证temp指向了链表的最后
         temp.next=heroNode;

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
        HeroNode temp=head.next;
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
     * 根据编号来插入节点
     */
    public void addByOrder(HeroNode heroNode){
         HeroNode temp=head;
//         如果节点编号已经存在，不能添加
        boolean flag=false; //表示不存在
        while (true){
            if (temp.next==null){
//                已经到达尾部
                break;
            }
            if(temp.next.no>heroNode.no){
                heroNode.next=temp.next;
                temp.next=heroNode;
                break;
            }else if(temp.next.no==heroNode.no){
//                说明添加的编号已经存在
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag){
            System.out.println("插入的英雄编号"+heroNode.no+"已经存在");

        }else {
            temp.next=heroNode;
        }
    }
    /**
     * 修改节点
     */
    public void update(HeroNode newHeroNode){
       if (head.next==null){
           System.out.println("链表为空");
           return;
       }
       HeroNode temp=head.next;
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
        HeroNode temp=head;
        while(true){
             if(temp.next==null){
                 System.out.println("没有该节点");
                 return;
             }
             if(temp.next.no==no){
                 temp.next=temp.next.next;
                 return;
             }
             temp=temp.next;
        }
    }
    /**
     * 获取单链表节点的个数
     */
    public static int getLength(HeroNode head){
//        头结点不算
        if (head.next==null){
            return 0;
        }
        int length=0;
        HeroNode current=head.next;
        while (current!=null){
           length++;
           current=current.next;
        }
        return length;
    }
    /**
     * 新浪面试题
     * 查询单链表的倒数第k个节点
     * 遍历(size-k)后，就可以得到
     */
    public static HeroNode findLastIndexNode(HeroNode head,int index){
        if (head.next==null){
            return null;
        }
        int size=getLength(head);
        if(index<=0||index>size){
            return null;
        }
        HeroNode temp=head.next;
        for (int i=0;i<size-index;i++){
             temp=temp.next;
        }
        return temp;

    }
    /**
     * 单链表的反转(Tecent)
     * 腾讯面试题
     */
    public static void reverse(HeroNode head){
            if(head.next==null){
                System.out.println("链表为空");
                return ;
            }
            if (head.next.next==null){
                System.out.println("只有一个节点无需反转");
                return;
            }
            HeroNode temp=head.next;
            while(temp.next!=null){
               temp=temp.next;
            }
//            找到尾节点
           HeroNode last=temp;
            while(head.next!=last){
                HeroNode p=head.next;
                head.next=p.next;
                p.next=last.next;
                last.next=p;
            }
    }
    /**
     * 反转 方式2 借助一个新的链表
     */
    public static void reverse2(HeroNode head){
        if(head.next==null){
            System.out.println("链表为空");
            return ;
        }
        if (head.next.next==null){
            System.out.println("只有一个节点无需反转");
            return;
        }
        HeroNode newNode=new HeroNode(0,"","");
        HeroNode temp=head.next;
        HeroNode p=null;
        while(temp!=null){
//            头插法插入
            p=temp.next;
                 temp.next=newNode.next;
                 newNode.next=temp;
                 temp=p;
        }
        head.next=newNode.next;
    }
    /**
     * 逆序打印栈
     * 利用栈
     */
    public static void reversePrint(HeroNode head){
         if(head.next==null){
             //空链表
             return;
         }
        Stack<HeroNode> stack=new Stack<>();
         HeroNode cur=head.next;
         while (cur!=null){
             stack.push(cur);
             cur=cur.next;
         }
         while (!stack.isEmpty()){
             System.out.println(stack.pop());
         }
    }

}


/**
 * 定义节点
 */
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;
    public HeroNode(int no,String name,String nickname){
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
