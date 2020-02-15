package com.lzy.design.lock.spinlock;

/**
 * @description:
 * @author: lzy
 * @create: 2020-02-11 23:31
 **/

public class Counter {
    int count = 0;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void add(){
        count += 1;
    }

    public void dec(){
        count -= 1;
    }
}

