package com.lzy.design.lock.spinlock.simplelock;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @description:
 * 无法保证多线程竞争的公平性
 * 当多个线程想要获取锁时，谁最先将available设为false谁就能最先获得锁，这可能会造成某些线程一直都未获取到锁造成线程饥饿。
 * @author: lzy
 * @create: 2020-02-14 23:48
 **/
public class SpinLock {
    private AtomicBoolean available = new AtomicBoolean(false);
    public void lock() {
        // 循环检测尝试获取锁
        while (!tryLock()) {
            System.out.println("线程" + Thread.currentThread().getName() + "再次尝试获取锁");
        }
        System.out.println("线程" + Thread.currentThread().getName() + "获取到锁");
    }

    public boolean tryLock(){
        // 尝试获取锁，成功返回true，失败返回false
        return available.compareAndSet(false,true);
    }

    public void unlock() {
        System.out.println("线程" + Thread.currentThread().getName() + "解锁");
        if (!available.compareAndSet(true, false)) {
            throw new RuntimeException("释放锁失败");
        }
    }
}
