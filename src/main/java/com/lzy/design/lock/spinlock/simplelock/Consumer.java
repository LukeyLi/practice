package com.lzy.design.lock.spinlock.simplelock;

import com.lzy.design.lock.spinlock.Counter;

/**
 * @description:
 * @author: lzy
 * @create: 2020-02-15 23:15
 **/
public class Consumer extends Thread {
    private TicketLock ticketLock;
    Counter counter;

    public Consumer(TicketLock ticketLock, Counter counter){
        this.ticketLock = ticketLock;
        this.counter = counter;
    }

    @Override
    public void run(){
        int num = this.ticketLock.lock();
        System.out.println("线程" + Thread.currentThread().getName() + "开始吃饭,count值：" + counter.getCount());
        counter.dec();
        this.ticketLock.unlock(num);

    }
}
