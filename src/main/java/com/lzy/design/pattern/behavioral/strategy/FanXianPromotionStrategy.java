package com.lzy.design.pattern.behavioral.strategy;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-28 19:50
 **/
public class FanXianPromotionStrategy implements PromotionStrategy{
    @Override
    public void doPromotion() {
        System.out.println("返现促销,返回的金额存放到慕课网用户的余额中");
    }
}
