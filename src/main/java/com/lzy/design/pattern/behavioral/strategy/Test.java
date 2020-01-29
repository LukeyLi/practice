package com.lzy.design.pattern.behavioral.strategy;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-28 19:52
 **/
public class Test {
    public static void main(String[] args) {
        PromotionActivity promotionActivity618 = new PromotionActivity(new LiJianPromotionStrategy());
        PromotionActivity promotionActivity1111 = new PromotionActivity(new FanXianPromotionStrategy());

        promotionActivity618.executePromotionStrategy();
        promotionActivity1111.executePromotionStrategy();
    }
}
