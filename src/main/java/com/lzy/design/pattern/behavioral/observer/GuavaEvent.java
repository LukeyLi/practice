package com.lzy.design.pattern.behavioral.observer;

import com.google.common.eventbus.Subscribe;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-29 20:37
 **/
public class GuavaEvent {
    @Subscribe
    public void subscribe(String str){
        System.out.println("执行subscribe方法，传入的参数是：" + str);
    }
}
