package com.lzy.design.lock.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @author: lzy
 * @create: 2020-02-14 22:42
 **/
public class AtomicCounter {
    private AtomicInteger integer = new AtomicInteger();

    public AtomicInteger getInteger() {
        return integer;
    }

    public void setInteger(AtomicInteger integer) {
        this.integer = integer;
    }

    public void increment(){
        integer.incrementAndGet();
    }

    public void decrement(){
        integer.decrementAndGet();
    }

}
