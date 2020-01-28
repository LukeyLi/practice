package com.lzy.design.pattern.creational.factorymethod;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-26 23:46
 **/
public class CantoneseCuisineFactory extends CuisineFactory {
    @Override
    public Cuisine getCuisine() {
        return new CantoneseCuisine();
    }
}
