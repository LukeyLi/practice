package com.lzy.design.lock.spinlock.simplelock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * 缺点：获得自己的号码后，可以对号码进行更改，锁不能及时释放
 * @author: lzy
 * @create: 2020-02-15 17:27
 **/
public class TicketLock {
    //队列票据(当前排队号码)
    private AtomicInteger queueNum = new AtomicInteger();
    //出队票据(当前需等待号码)
    private AtomicInteger dueueNum = new AtomicInteger();

    //获取锁。如果成功，返回当前线程的排队号
    public int lock() {
        int currentTicketNum = dueueNum.incrementAndGet();
        System.out.println("线程" + Thread.currentThread().getName() + ",当前排队号:" + currentTicketNum + "距离就餐号码：" + dueueNum);
        while (currentTicketNum != queueNum.get()) {
        }
        return currentTicketNum;
    }
    //释放锁,传入当前
    public void unlock(int ticketNum) {
        queueNum.compareAndSet(ticketNum, ticketNum + 1);
    }
}
