package com.lzy.design.pattern.creational.singleton;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-27 17:49
 **/
public enum EnumInstance {
    INSTANCE;
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumInstance getInstance() {
        return INSTANCE;
    }
}
