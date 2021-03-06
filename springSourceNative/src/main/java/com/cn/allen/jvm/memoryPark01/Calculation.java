package com.cn.allen.jvm.memoryPark01;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/6/22
 * @Description:
 */
public class Calculation {
    public int calc() {
        int a = 100;
        int b = 200;
        int c = 300;
        return (a+b) * c;
    }

    public static void main(String[] args) {
        Calculation calculation = new Calculation();
        calculation.calc();
    }
}
/*
*  public int calc();
    descriptor: ()I
    flags: ACC_PUBLIC
    Code:
      stack=2, locals=4, args_size=1
         0: bipush        100
         2: istore_1
         3: sipush        200
         6: istore_2
         7: sipush        300
        10: istore_3
        11: iload_1
        12: iload_2
        13: iadd
        14: iload_3
        15: imul
        16: ireturn
      LineNumberTable:
        line 10: 0
        line 11: 3
        line 12: 7
        line 13: 11
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0      17     0  this   Lcom/cn/allen/jvm/memoryPark01/Calculation;
            3      14     1     a   I
            7      10     2     b   I
           11       6     3     c   I
* */
