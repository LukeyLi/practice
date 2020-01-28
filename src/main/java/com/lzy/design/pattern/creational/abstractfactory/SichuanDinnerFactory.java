package com.lzy.design.pattern.creational.abstractfactory;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-27 13:36
 **/
public class SichuanDinnerFactory implements DinnerFactory {
    @Override
    public Cuisine getCuisine() {
        return new SichuanCuisine();
    }

    @Override
    public Soup getSoup() {
        return new SichuanSoup();
    }
}
