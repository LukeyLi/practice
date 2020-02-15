package com.lzy.design.lock.spinlock.queueSpinlock;

import com.lzy.design.lock.spinlock.Lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @author: lzy
 * @create: 2020-02-15 17:48
 **/
public class TicketLock2 implements Lock {
    //队列票据（当前排队号码）
    private AtomicInteger queueNum = new AtomicInteger();

    //出队票据（当前需等待号码）
    private AtomicInteger dueueNum = new AtomicInteger();

    private ThreadLocal<Integer> ticketLocal = new ThreadLocal<>();

    @Override
    public void lock() {
        int currentTicketNum = dueueNum.incrementAndGet();
        System.out.println("线程" + Thread.currentThread().getName() + "取票：" + currentTicketNum + "出队号:" + queueNum.get());
        //获取锁的时候，将当前线程的排队号保存起来
        ticketLocal.set(currentTicketNum);
        while(currentTicketNum != ticketLocal.get()) {
            System.out.println("线程" + Thread.currentThread().getName() + "再次尝试获取锁");
        }
        System.out.println("线程" + Thread.currentThread().getName() + "获取到锁");
    }

    //释放锁：从排队缓冲池中取
    @Override
    public void unlock(){
        Integer currentTicket = ticketLocal.get();
        System.out.println("线程" + Thread.currentThread().getName() + "解锁" + currentTicket);
        queueNum.compareAndSet(currentTicket, currentTicket + 1);
    }
}
