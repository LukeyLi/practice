package com.lzy.design.pattern.structural.adapter;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-28 22:48
 **/
public class Test {
    public static void main(String[] args) {
        DC5 dc5 = new XiaomiAdaptor();
        dc5.outputDC5V();
    }
}
