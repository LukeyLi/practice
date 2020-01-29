package com.lzy.design.pattern.behavioral.strategy;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-28 19:52
 **/
public class PromotionActivity {
    private PromotionStrategy promotionStrategy;

    public PromotionActivity(PromotionStrategy promotionStrategy) {
        this.promotionStrategy = promotionStrategy;
    }

    public void executePromotionStrategy(){
        promotionStrategy.doPromotion();
    }

}
