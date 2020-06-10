package top.lstech.thread.concurrent;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class MultThread {
    public static void main(String[] args) {
        // 线程管理器
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

        // 获取线程 和 线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println(threadInfo.getThreadId() + "  " + threadInfo.getThreadName());
        }
    }
}
