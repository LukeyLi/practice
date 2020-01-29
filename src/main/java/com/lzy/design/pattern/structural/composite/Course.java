package com.lzy.design.pattern.structural.composite;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-29 15:43
 **/
public class Course extends CatalogComponent{
    private String name;
    private double price;

    public Course(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public void print() {
        System.out.println("Course Name:"+name+" Price:"+price);
    }
}
