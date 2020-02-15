package com.lzy.design.lock.spinlock;

/**
 * @description:
 * @author: lzy
 * @create: 2020-02-15 22:35
 **/
public interface Lock {
    void lock();
    void unlock();
}
