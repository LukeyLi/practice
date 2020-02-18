package com.lzy.design.lock.spinlock.simplelock;

import com.lzy.design.lock.spinlock.Counter;

/**
 * @description:
 * @author: lzy
 * @create: 2020-02-15 23:14
 **/
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter(100);
        TicketLock lock = new TicketLock();
        for(int i = 0; i < 10; i++) {
            Consumer consumer = new Consumer(lock, counter);
            consumer.start();
        }
        System.out.println("线程" + Thread.currentThread().getName() + ",count值：" + counter.getCount());

    }
}
