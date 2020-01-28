package com.lzy.design.pattern.creational.singleton;

import java.io.Serializable;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-27 17:36
 **/
public class HungrySingleton implements Serializable, Cloneable {
    private final static HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton(){
        if (hungrySingleton != null) {
            throw new RuntimeException("单例构造器禁止反射调用");
        }
    }

    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
        // 解决办法，1. 不实现 Cloneable 接口，2. 实现 Cloneable 接口，重写 clone 方法，调用 单例类的 getInstance 方法
        //return getInstance();
    }

    // 该方法并非被重写的方法
    private Object readResolve(){
        return hungrySingleton;
    }
}
