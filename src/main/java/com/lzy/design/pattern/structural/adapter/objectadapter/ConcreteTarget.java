package com.lzy.design.pattern.structural.adapter.objectadapter;

/**
 * @description:目标实现类
 * @author: lzy
 * @create: 2020-01-28 22:06
 **/
public class ConcreteTarget implements Target{
    @Override
    public void request() {
        System.out.println("concreteTarget目标方法");
    }
}
