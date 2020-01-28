package com.lzy.design.pattern.structural.decorator.v1;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-28 21:21
 **/
public class BattercakeWithEggSausage extends BattercakeWithEgg {
    @Override
    public String getDesc() {
        return super.getDesc()+ " 加一根香肠";
    }

    @Override
    public int cost() {
        return super.cost()+2;
    }
}
