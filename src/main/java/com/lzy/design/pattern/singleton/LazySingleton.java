package com.lzy.design.pattern.singleton;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-27 14:53
 **/
public class LazySingleton {
    // 声明该类变量，但是不创建，等到真正使用的时候调用 getInstance 方法创建
    private static LazySingleton lazySingleton = null;
    // 构造函数私有化，避免外部调用
    private LazySingleton() {
    }

    //v2 加上 synchronized 关键字，使该方法变为同步方法，
    public synchronized static LazySingleton getInstance() {
        if (lazySingleton == null) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
    //与上面的方法效果一样。
//    public static LazySingleton getInstance(){
//        synchronized(LazySingleton.class){
//            if (lazySingleton == null) {
//                lazySingleton = new LazySingleton();
//            }
//        }
//        return lazySingleton;
//    }
}
