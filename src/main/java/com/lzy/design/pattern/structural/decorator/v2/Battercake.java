package com.lzy.design.pattern.structural.decorator.v2;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-28 21:28
 **/
public class Battercake extends ABattercake {
    @Override
    protected String getDesc() {
        return "煎饼";
    }

    @Override
    protected int cost() {
        return 20;
    }
}
