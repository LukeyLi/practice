package com.lzy.design.lock.spinlock.simplelock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * 缺点：获得自己的号码后，可以对号码进行更改，锁不能及时释放
 * @author: lzy
 * @create: 2020-02-15 17:27
 **/
public class TicketLock {
    // 服务号
    private AtomicInteger serviceNum = new AtomicInteger();
    // 排队号
    private AtomicInteger ticketNum = new AtomicInteger();

    //获取锁。如果成功，返回当前线程的排队号
    public int lock() {
        // 首先原子性地获得一个排队号
        int myTicketNum = ticketNum.getAndIncrement();
        System.out.println("线程" + Thread.currentThread().getName() + "加入排队,排队号:" + myTicketNum + "距离就餐号码：" + serviceNum.get());
        while (myTicketNum != serviceNum.get()) {
            System.out.println("线程" + Thread.currentThread().getName() + "在排队，号码为：" + myTicketNum + "等待号码：" + serviceNum.get());
        }
        return myTicketNum;
    }
    //释放锁,传入当前
    public void unlock(int myTicket) {
        // 只有当前线程拥有者才能释放锁
        serviceNum.compareAndSet(myTicket, myTicket + 1);
        System.out.println("线程" + Thread.currentThread().getName() + "已消费完,下个就餐号码：" + serviceNum.get());
    }
}
