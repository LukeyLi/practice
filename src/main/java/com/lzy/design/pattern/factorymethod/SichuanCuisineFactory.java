package com.lzy.design.pattern.factorymethod;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-26 23:45
 **/
public class SichuanCuisineFactory extends CuisineFactory {
    @Override
    public Cuisine getCuisine() {
        return new SichuanCuisine();
    }
}
