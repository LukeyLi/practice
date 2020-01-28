package com.lzy.design.pattern.structural.facade;

/**
 * @description: 支付子系统
 * @author: lzy
 * @create: 2020-01-28 20:08
 **/
public class PointPaymentService {
    public boolean pay(PointGift pointGift) {
        //扣减积分
        System.out.println("支付" + pointGift.getName() + "积分成功");
        return true;
    }
}
