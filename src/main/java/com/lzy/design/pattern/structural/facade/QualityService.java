package com.lzy.design.pattern.structural.facade;

/**
 * @description:积分子系统
 * @author: lzy
 * @create: 2020-01-28 20:11
 **/
public class QualityService {
    public boolean isAvailable(PointGift pointGift) {
        System.out.println("检验" + pointGift.getName() + "积分资格通过，库存通过");
        return true;
    }
}
