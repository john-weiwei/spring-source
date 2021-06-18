package com.cn.allen.jvm.memoryPark01;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/6/18
 * @Description:
 * VM 参数设置
 * -Xms20m  堆空间初始值
 * -Xmx20m  堆空间最大值
 * -Xmn10m  新生代的空间
 * -XX:+PrintGCDetails  打印内存回收日志，并在进程退出时输出当前内存分配情况
 * -XX:SurvivorRatio=8 Eden区和Survivor区的比例是8:1
 */
public class TestAllocation {
    private static int _1M = 1024 * 1024;
    public static void main(String[] args) {
        byte[] all1,all2,all3,all4;
        all1 = new byte[2 * _1M];
        all2 = new byte[2 * _1M];
        all3 = new byte[2 * _1M];
        all4 = new byte[4 * _1M];
    }
}
/**
 * [GC (Allocation Failure) [PSYoungGen: 6623K->816K(9216K)] 6623K->4920K(19456K), 0.0034462 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
 * Heap
 *  PSYoungGen      total 9216K, used 7282K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)    //新生代总空间,Eden区+1个Survivor区=9M
 *   eden space 8192K, 78% used [0x00000007bf600000,0x00000007bfc507f8,0x00000007bfe00000)  //Eden区8M
 *   from space 1024K, 79% used [0x00000007bfe00000,0x00000007bfecc010,0x00000007bff00000)  //Survivor（from）区1M
 *   to   space 1024K, 0% used [0x00000007bff00000,0x00000007bff00000,0x00000007c0000000)   //Survivor（to）区1M
 *  ParOldGen       total 10240K, used 4104K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)   //老年代总空间10M，使用了4M
 *   object space 10240K, 40% used [0x00000007bec00000,0x00000007bf002020,0x00000007bf600000)
 *  Metaspace       used 3087K, capacity 4496K, committed 4864K, reserved 1056768K
 *   class space    used 340K, capacity 388K, committed 512K, reserved 1048576K
 *
 *   日志解读：程序分批到all4语句时，会触发一次MinorGC，这次GC的结果是新生代由6623k变成了816k，而总内存占用量则没有减少多少（all1,all2,all3都是存活的），
 *   因此在给all4分配内存时，Eden区已经被占用了6M，因此发生了MinorGC（要回收掉2个对象的内存），GC期间无法将4M的对象放入Survivor区，只好通过分配空间担保
 *   机制提前转入到老年代中。
 */
