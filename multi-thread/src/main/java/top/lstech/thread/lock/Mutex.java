package top.lstech.thread.lock;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;


/**
 * 独占锁，同一时刻，只有一个线程获取到锁，其他的线程只能处于同步队列中等待；
 */
public class Mutex implements Lock {

    // 自定义同步器
    private static class Sync extends AbstractQueuedSynchronizer {
        // 是否处于占用状态
        protected boolean isHeldExclusiverly() {
            return getState() == 1;
        }

        // 状态为0， 获取锁
        @Override
        public boolean tryAcquire(int acquires) {
            if (compareAndSetState(0, 1)) {
                return true;
            }
            return false;
        }

        // 释放锁， 讲状态设置为0
        @SneakyThrows
        @Override
        protected boolean tryRelease(int release) {
            if (getState() == 0) {
                throw new IllegalAccessException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        // 返回一个Condition 每个Condition都包含一个condition 队列
        Condition newCondition() {
            return new ConditionObject();
        }
    }


    private final Sync sync = new Sync();

    @Override
    public void lock() {
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {

    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
