package com.lzy.design.pattern.behavioral.strategy;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-28 19:51
 **/
public class LiJianPromotionStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("立减促销,课程的价格直接减去配置的价格");
    }
}
