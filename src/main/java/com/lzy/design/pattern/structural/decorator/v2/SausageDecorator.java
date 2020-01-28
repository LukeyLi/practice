package com.lzy.design.pattern.structural.decorator.v2;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-28 21:28
 **/
public class SausageDecorator extends AbstractDecorator {
    public SausageDecorator(ABattercake aBattercake) {
        super(aBattercake);
    }

    @Override
    protected void doSomething() {
    }

    @Override
    protected String getDesc() {
        return super.getDesc()+" 加一根香肠";
    }

    @Override
    protected int cost() {
        return super.cost()+2;
    }
}
