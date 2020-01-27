package com.lzy.design.pattern.simplefactory;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-26 17:52
 **/
public class Test {

    //v3使用反射机制优化过的工厂类
    public static void main(String[] args) {
        CuisineFactory cuisineFactory = new CuisineFactory();
        Cuisine cuisine = cuisineFactory.getCuisine(SichuanCuisine.class);
        if (cuisine == null){
            return;
        }
        cuisine.cookie();
    }

    // V1 不使用工厂类方法创建实例
//    public static void main(String[] args) {
//            Cuisine cuisine = new SichuanCuisine();
//            cuisine.cookie();
//    }
    // V2 使用工厂类创建实例
//    public static void main(String[] args) {
//        DinnerFactory cuisineFactory = new DinnerFactory();
//        Cuisine cuisine = cuisineFactory.getCuisine("Sichuan");
//        if (cuisine == null) {
//            return;
//        }
//        cuisine.cookie();
//    }
}
