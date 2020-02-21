package com.lzy.design.lock.spinlock.fairLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: lzy
 * @create: 2020-02-19 22:26
 **/
public class FairLock {
    private ReentrantLock lock = new ReentrantLock(true);
    public void fairLock(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "正在持有锁");
        } finally {
            System.out.println(Thread.currentThread().getName()  + "释放了锁");
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        FairLock fairLock = new FairLock();
        Runnable runnable = ()-> {
            System.out.println(Thread.currentThread().getName() + "启动");
            fairLock.fairLock();
        };
        Thread[] thread = new Thread[10];
        for(int i = 0; i < 10; i++) {
            thread[i] = new Thread(runnable);
        }
        for(int i = 0;i < 10;i++){
            thread[i].start();
        }
    }
}
