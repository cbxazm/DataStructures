package com.cbx.recursion;

public class MIGong {
    public static void main(String[] args) {
        //创建一个迷宫 二维数组
        int[][] map=new int[8][7];
        //使用1表示墙
        //上下全置为1
        for (int i = 0; i <7; i++) {
            map[0][i]=1;
            map[7][i]=1;
        }
        //左右全置为1 
        for (int i = 0; i <8; i++) {
            map[i][0]=1;
            map[i][6]=1;
        }
        //设置挡板 也是1表示(不能走的地方)
        map[3][1]=1;
        map[3][2]=1;
        System.out.println("地图的情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        //找路后
        System.out.println("找路后的情况");
        boolean b = setWay(map, 1, 1);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
    //使用递归回溯来给小球找路
    /**
     *
     * @param map 表示地图
     * @param i 从哪个位置开始找
     * @param j(i,j)表示从哪个地方出发
     * 小球能到map[6][5]说明，通路能找到
     * 0没有走过  1表示墙 不能走 ，2表示通路可以走 3表示已经走过（但是走不通）
     * 定义策略下==》右==》上==》左 走不通再回溯
     * @return
     */
    public static boolean setWay(int[][] map,int i,int j){
          if (map[6][5]==2){
              //表示通路已经找到 ok
              return true;
          }else{
               if (map[i][j]==0){
                   //这个点还没有走过
                   map[i][j]=2;//假定该点可以走
                   if (setWay(map,i+1,j)){
                       //向下走
                       return true;
                   }else if(setWay(map,i,j+1)){
                       //向右
                       return true;
                   }else if (setWay(map,i-1,j)){
                       //向上
                       return true;
                   }else if (setWay(map,i,j-1)){
                       //向左走
                      return true;
                   }else {
                       //说明走不通
                       map[i][j]=3;
                       return false;
                   }
               }else {
                   //如果map[i][j]!=0 ,可能是1,2,3(2，3都可以认为之前走过,就不走了)
                   return false;
               }
          }
    }
}
