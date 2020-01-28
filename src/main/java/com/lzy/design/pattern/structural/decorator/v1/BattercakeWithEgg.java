package com.lzy.design.pattern.structural.decorator.v1;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-28 21:20
 **/
public class BattercakeWithEgg extends Battercake {
    @Override
    public String getDesc() {
        return super.getDesc()+" 加一个鸡蛋";
    }

    @Override
    public int cost() {
        return super.cost()+1;
    }
}
