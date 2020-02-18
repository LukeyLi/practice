package com.lzy.design.lock.spinlock.queueSpinlock;


import com.lzy.design.lock.spinlock.Counter;
import com.lzy.design.lock.spinlock.Lock;
import com.lzy.design.lock.spinlock.Producer;

/**
 * @description:
 * @author: lzy
 * @create: 2020-02-15 00:01
 **/
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Lock lock = new MCSLock();
       for(int i = 0; i < 8; i++) {
           Producer producer = new Producer(lock, counter);
           producer.start();
       }
        //System.out.println("线程" + Thread.currentThread().getName() + ",count值：" + counter.getCount());

    }

}
