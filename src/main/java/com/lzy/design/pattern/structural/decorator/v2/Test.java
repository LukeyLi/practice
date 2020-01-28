package com.lzy.design.pattern.structural.decorator.v2;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-28 21:28
 **/
public class Test {
    public static void main(String[] args) {
        ABattercake aBattercake = new Battercake() ;
        aBattercake = new EggDecorator(aBattercake);
        aBattercake = new EggDecorator(aBattercake);
        aBattercake = new SausageDecorator(aBattercake);

        System.out.println(aBattercake.getDesc()+" 销售价格:"+aBattercake.cost());
    }
}
