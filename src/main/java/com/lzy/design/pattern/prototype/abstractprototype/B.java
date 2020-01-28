package com.lzy.design.pattern.prototype.abstractprototype;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-28 11:48
 **/
public class B extends A {
    public static void main(String[] args) throws CloneNotSupportedException {
        B b = new B();
        b.clone();
    }
}
