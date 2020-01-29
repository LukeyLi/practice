package com.lzy.design.pattern.behavioral.observer;

import com.google.common.eventbus.EventBus;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-29 20:38
 **/
public class GuavaEventTest {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        GuavaEvent guavaEvent = new GuavaEvent();
        eventBus.register(guavaEvent);
        eventBus.post("post的内容");
    }
}
