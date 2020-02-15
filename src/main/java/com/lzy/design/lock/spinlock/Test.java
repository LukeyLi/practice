package com.lzy.design.lock.spinlock;


/**
 * @description:
 * @author: lzy
 * @create: 2020-02-15 00:01
 **/
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        SpinLock spinLock = new SpinLock();
       for(int i = 0; i < 2; i++) {
           Producer producer = new Producer(spinLock, counter);
           producer.start();
       }
        System.out.println("线程" + Thread.currentThread().getName() + ",count值：" + counter.getCount());

    }
}
