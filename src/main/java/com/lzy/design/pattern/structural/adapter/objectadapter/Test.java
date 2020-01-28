package com.lzy.design.pattern.structural.adapter.objectadapter;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-28 22:07
 **/
public class Test {
    public static void main(String[] args) {
        Target target = new ConcreteTarget();
        target.request();

        Target adapterTarget = new Adapter();
        adapterTarget.request();
    }
}
