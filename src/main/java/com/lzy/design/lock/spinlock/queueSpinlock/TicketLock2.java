package com.lzy.design.lock.spinlock.queueSpinlock;

import com.lzy.design.lock.spinlock.Lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @author: lzy
 * @create: 2020-02-15 17:48
 **/
public class TicketLock2 implements Lock {
    // 服务号
    private AtomicInteger serviceNum = new AtomicInteger();
    // 排队号
    private AtomicInteger ticketNum = new AtomicInteger();

    private ThreadLocal<Integer> ticketLocal = new ThreadLocal<>();

    //获取锁。如果成功，返回当前线程的排队号
    @Override
    public void lock() {
        // 首先原子性地获得一个排队号
        int myTicketNum = ticketNum.getAndIncrement();
        ticketLocal.set(myTicketNum);
        System.out.println("线程" + Thread.currentThread().getName() + "加入排队,排队号:" + myTicketNum + "距离就餐号码：" + serviceNum.get());
        while (myTicketNum != serviceNum.get()) {
            System.out.println("线程" + Thread.currentThread().getName() + "在排队，号码为：" + myTicketNum + "等待号码：" + serviceNum.get());
        }
    }
    //释放锁,传入当前
    @Override
    public void unlock() {
        // 只有当前线程拥有者才能释放锁
        Integer currentTicket  = ticketLocal.get();
        serviceNum.compareAndSet(currentTicket, currentTicket + 1);
        System.out.println("线程" + Thread.currentThread().getName() + "已消费完,下个就餐号码：" + serviceNum.get());
    }
}
