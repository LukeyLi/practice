package com.lzy.design.pattern.structural.adapter.classadapter;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-28 22:34
 **/
public class Test {
    public static void main(String[] args) {
       // Target target = new ConcreteTarget();
        //target.request();

        Target adapterTarget = new Adapter();
        adapterTarget.request();
    }
}
