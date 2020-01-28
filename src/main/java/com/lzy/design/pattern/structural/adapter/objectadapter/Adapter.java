package com.lzy.design.pattern.structural.adapter.objectadapter;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-28 22:05
 **/
public class Adapter implements Target{
    private Adaptee adaptee = new Adaptee();
    @Override
    public void request() {
        //...
        adaptee.adapteeRequest();
        //...
    }
}
