package com.lzy.design.pattern.structural.facade;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-28 20:07
 **/
public class GiftExchangeService {
    private QualityService qualityService = new QualityService();
    private PointPaymentService pointPaymentService = new PointPaymentService();
    private ShippingService shippingService = new ShippingService();

    public void giftExchange(PointGift pointGift) {
        // 如果资格校验通过
        if (qualityService.isAvailable(pointGift)) {
            // 如果支付积分成功
            if (pointPaymentService.pay(pointGift)){
                String shippingOrderNo = shippingService.shipGift(pointGift);
                System.out.println("物流系统下单成功, 订单号是：" + shippingOrderNo);
            }
        }
    }
}
