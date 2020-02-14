package com.lzy.design.lock.cas;

/**
 * @description:
 * @author: lzy
 * @create: 2020-02-14 22:42
 **/
public class AtomicProducer extends Thread {
    private AtomicCounter atomicCounter;

    public AtomicProducer(AtomicCounter atomicCounter){
        this.atomicCounter = atomicCounter;
    }

    @Override
    public void run() {
        for(int j = 0; j < AtomicTest.LOOP; j++) {
            System.out.println("producer : " + atomicCounter.getInteger());
            atomicCounter.increment();
        }
    }
}
