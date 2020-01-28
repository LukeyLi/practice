package com.lzy.design.pattern.structural.proxy.staticproxy;

import com.lzy.design.pattern.structural.proxy.Order;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-28 23:46
 **/
public class Test {
    public static void main(String[] args) {
        Order order = new Order();
        order.setUserId(2);

        OrderServiceStaticProxy orderServiceStaticProxy = new OrderServiceStaticProxy();
        orderServiceStaticProxy.saveOrder(order);
    }
}
