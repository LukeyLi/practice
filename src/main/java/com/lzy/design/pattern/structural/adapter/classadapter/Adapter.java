package com.lzy.design.pattern.structural.adapter.classadapter;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-28 22:31
 **/
public class Adapter extends Adaptee implements Target {
    @Override
    public void request() {
        //...
        super.adapteeRequest();
        //...
    }
}
