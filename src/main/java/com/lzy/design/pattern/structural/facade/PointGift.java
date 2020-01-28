package com.lzy.design.pattern.structural.facade;

/**
 * @description: 积分礼物
 **/
public class PointGift {
    private String name;

    public PointGift(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
