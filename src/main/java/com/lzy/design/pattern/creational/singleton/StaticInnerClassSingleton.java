package com.lzy.design.pattern.creational.singleton;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-27 16:35
 **/
public class StaticInnerClassSingleton {
    private StaticInnerClassSingleton() {
        // 在单例类的私有化构造方法中添加防放射破坏代码,如果是通过反射调用就抛出运行时异常
        if (InnerClass.staticInnerClassSingleton != null) {
            throw new RuntimeException("单例构造器禁止反射调用");
        }
    }
    // 静态内部类的静态初始化锁，哪个线程拿到哪个线程就去初始化它
    private static class InnerClass {
        private static StaticInnerClassSingleton staticInnerClassSingleton = new StaticInnerClassSingleton();
    }

    private static StaticInnerClassSingleton getInstance(){
        return InnerClass.staticInnerClassSingleton;
    }
}
