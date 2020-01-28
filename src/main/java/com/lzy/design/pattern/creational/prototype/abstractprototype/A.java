package com.lzy.design.pattern.creational.prototype.abstractprototype;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-28 11:48
 **/
public abstract class A implements Cloneable {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
