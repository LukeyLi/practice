package com.lzy.design.pattern.behavioral.strategy;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-28 19:51
 **/
public class ManJianPromotionStrategy implements PromotionStrategy{
    @Override
    public void doPromotion() {
        System.out.println("满减促销,满200-20元");
    }
}
