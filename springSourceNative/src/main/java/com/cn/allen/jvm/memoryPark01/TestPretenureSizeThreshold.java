package com.cn.allen.jvm.memoryPark01;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/6/18
 * @Description:
 * -Xms20m
 * -Xmx20m
 * -Xmn10m
 * -XX:+PrintGCDetails
 * -XX:SurvivorRatio=8
 * -XX:PretenureSizeThreshold=3145728   超过3MB的对象直接进入老年代
 * -XX:+UseSerialGC 使用Serial收集器
 */
public class TestPretenureSizeThreshold {
    private static int _1M = 1024 * 1024;
    public static void main(String[] args) {
        testPretenureSizeThreshold();
    }
    //大对象直接进入老年代
    public static void testPretenureSizeThreshold() {
        byte[] all1;
        all1 = new byte[4 * _1M];
    }
    /**
     * Serial收集器
     * Heap
     *  def new generation   total 9216K, used 2692K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
     *   eden space 8192K,  32% used [0x00000007bec00000, 0x00000007beea1190, 0x00000007bf400000)
     *   from space 1024K,   0% used [0x00000007bf400000, 0x00000007bf400000, 0x00000007bf500000)
     *   to   space 1024K,   0% used [0x00000007bf500000, 0x00000007bf500000, 0x00000007bf600000)
     *  tenured generation   total 10240K, used 4096K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000) //老年代
     *    the space 10240K,  40% used [0x00000007bf600000, 0x00000007bfa00010, 0x00000007bfa00200, 0x00000007c0000000)
     *  Metaspace       used 3087K, capacity 4496K, committed 4864K, reserved 1056768K
     *   class space    used 340K, capacity 388K, committed 512K, reserved 1048576K
     *
     *   日志解读：all1需要分配4M空间，大于-XX:PretenureSizeThreshol参数设置的值，直接进入老年代
     *   -XX:PretenureSizeThreshol  此参数只对Serial和ParNew两款收集器有效
     */
}
