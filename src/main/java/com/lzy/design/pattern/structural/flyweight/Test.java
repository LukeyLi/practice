package com.lzy.design.pattern.structural.flyweight;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-29 11:59
 **/
public class Test {
    private static final String departments[] = {"RD", "QA", "PM", "BD"};

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            String department = departments[(int)(Math.random() * departments.length)];
            Manager manager = (Manager) EmployeeFactory.getManager(department);
            manager.report();
        }
    }
}
