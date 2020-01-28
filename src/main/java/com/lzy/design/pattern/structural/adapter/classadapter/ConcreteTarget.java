package com.lzy.design.pattern.structural.adapter.classadapter;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-28 22:31
 **/
public class ConcreteTarget implements Target {
    @Override
    public void request() {
        System.out.println("concreteTarget目标方法");
    }
}
