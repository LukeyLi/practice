package com.lzy.design.pattern.structural.facade;

/**
 * @description: 物流子系统
 * @author: lzy
 * @create: 2020-01-28 20:12
 **/
public class ShippingService {
    public String shipGift(PointGift pointGift) {
        //物流系统的对接逻辑
        System.out.println(pointGift.getName() + "进入物流系统");
        String shippingOrderNo = "666";
        return shippingOrderNo;
    }
}
