package com.lzy.design.pattern.structural.facade;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-28 20:26
 **/
public class Test {
    public static void main(String[] args) {
        PointGift pointGift = new PointGift("iphone");
        GiftExchangeService giftExchangeService = new GiftExchangeService();
        giftExchangeService.giftExchange(pointGift);
    }
}
