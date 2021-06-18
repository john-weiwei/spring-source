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
 * -XX:MaxTenuringThreshold=15  设置晋升老年代的年龄阀值
 * -XX:+UseSerialGC
 * -XX:+PrintTenuringDistribution   打印老年代的分配
 */
public class TestTenuringThreshold {
    private static int _1M = 1024 * 1024;
    public static void main(String[] args) {
        test();
    }

    //长期存活对象进入老年代
    public static void test() {
        byte[] all1,all2,all3;
        all1 = new byte[_1M / 4];
        //什么时候进入老年代，取决于 -XX:MaxTenuringThreshold 参数值
        all2 = new byte[_1M / 4];
        all2 = new byte[4 * _1M];
        all3 = new byte[4 * _1M];
        all3 = null;
        all3 = new byte[4 * _1M];
    }

    //动态对象年龄判定
    public static void test2() {
        byte[] all1,all2,all3,all4;
        all1 = new byte[_1M / 4];
        //all1 + all2大于Survivor空间的一半
        all2 = new byte[_1M / 4];
        all3 = new byte[4 * _1M];
        all4 = new byte[4 * _1M];
        all4 = null;
        all4 = new byte[4 * _1M];
    }
    /**
     * [GC (Allocation Failure) [DefNew
     * Desired survivor size 524288 bytes, new threshold 1 (max 15)
     * - age   1:     922248 bytes,     922248 total
     * : 7144K->900K(9216K), 0.0041328 secs] 7144K->4996K(19456K), 0.0041583 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
     * [GC (Allocation Failure) [DefNew
     * Desired survivor size 524288 bytes, new threshold 15 (max 15)
     * - age   1:       1688 bytes,       1688 total
     * : 5078K->1K(9216K), 0.0011717 secs] 9174K->4898K(19456K), 0.0011888 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
     * Heap
     *  def new generation   total 9216K, used 4235K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
     *   eden space 8192K,  51% used [0x00000007bec00000, 0x00000007bf022780, 0x00000007bf400000)
     *   from space 1024K,   0% used [0x00000007bf400000, 0x00000007bf400698, 0x00000007bf500000)
     *   to   space 1024K,   0% used [0x00000007bf500000, 0x00000007bf500000, 0x00000007bf600000)
     *  tenured generation   total 10240K, used 4896K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
     *    the space 10240K,  47% used [0x00000007bf600000, 0x00000007bfac8258, 0x00000007bfac8400, 0x00000007c0000000)
     *  Metaspace       used 3110K, capacity 4496K, committed 4864K, reserved 1056768K
     *   class space    used 341K, capacity 388K, committed 512K, reserved 1048576K
     */

}
