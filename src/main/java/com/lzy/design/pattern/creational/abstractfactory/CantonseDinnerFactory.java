package com.lzy.design.pattern.creational.abstractfactory;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-27 13:41
 **/
public class CantonseDinnerFactory implements DinnerFactory {
    @Override
    public Cuisine getCuisine() {
        return new CantoneseCuisine();
    }
    @Override
    public Soup getSoup() {
        return new SichuanSoup();
    }
}
