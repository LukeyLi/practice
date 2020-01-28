package com.lzy.design.pattern.creational.abstractfactory;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-26 20:10
 **/
public interface DinnerFactory {
    Cuisine getCuisine();
    Soup getSoup();
}
