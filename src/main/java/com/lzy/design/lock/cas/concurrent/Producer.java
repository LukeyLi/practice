package com.lzy.design.lock.cas.concurrent;

/**
 * @description:
 * @author: lzy
 * @create: 2020-02-11 23:37
 **/
public class Producer extends Thread {

    Counter counter;

    public Producer(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run(){
        for (int i = 0; i < Test.LOOP; i++) {
            counter.add();
        }
    }
}
