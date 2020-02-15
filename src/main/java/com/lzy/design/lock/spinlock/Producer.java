package com.lzy.design.lock.spinlock;



/**
 * @description:
 * @author: lzy
 * @create: 2020-02-15 16:08
 **/
public class Producer extends Thread {

    private Lock lock;
    Counter counter;

    public Producer(Lock lock, Counter counter){
        this.lock = lock;
        this.counter = counter;
    }

    @Override
    public void run(){
        this.lock.lock();
        System.out.println("线程" + Thread.currentThread().getName() + "开始做事,count值：" + counter.getCount());
        counter.add();
        System.out.println(counter);
        this.lock.unlock();

    }


}
