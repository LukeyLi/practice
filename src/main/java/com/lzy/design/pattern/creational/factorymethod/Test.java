package com.lzy.design.pattern.creational.factorymethod;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-26 17:52
 **/
public class Test {
    public static void main(String[] args) {
        // 父类的声明指向子类的应用,根据需要创建对应菜系的工厂类即可
        CuisineFactory cantoneseCuisineFactory = new CantoneseCuisineFactory();
        CuisineFactory sichuanCuisineFactory = new SichuanCuisineFactory();
        Cuisine sichuanCuisine = sichuanCuisineFactory.getCuisine();
        sichuanCuisine.cookie();
    }
}
