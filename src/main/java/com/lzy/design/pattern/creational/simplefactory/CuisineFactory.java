package com.lzy.design.pattern.creational.simplefactory;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-26 20:10
 **/
public class CuisineFactory {
    //v2 通过反射优化工厂创建对应实例
    public Cuisine getCuisine(Class c) {
        Cuisine cuisine = null;
        try {
            cuisine = (Cuisine) Class.forName(c.getName()).newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return cuisine;
    }

    //v1 根据传入的类型创建具体的实例
//    public Cuisine getCuisine(String type) {
//        if ("Sichuan".equalsIgnoreCase(type)) {
//            return new SichuanCuisine();
//        } else if ("Cantonese".equalsIgnoreCase(type)) {
//            return new CantoneseCuisine();
//        }
//        return null;
//    }
}
