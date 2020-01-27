package com.lzy.design.pattern.abstractfactory;


/**
 * @description:
 * @author: lzy
 * @create: 2020-01-26 17:52
 **/
public class Test {
    public static void main(String[] args) {
        DinnerFactory dinnerFactory = new SichuanDinnerFactory();
        Cuisine sichuanCuisine = dinnerFactory.getCuisine();
        Soup sichuanSoup = dinnerFactory.getSoup();
        sichuanCuisine.cookie();
        sichuanSoup.cookie();
    }
}
