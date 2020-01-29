package com.lzy.design.pattern.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-29 11:59
 **/
public class EmployeeFactory {
    private static final Map<String, Employee> EMPLOYEE_MAP = new HashMap<>();

    public static Employee getManager(String department) {
        Manager manager = (Manager) EMPLOYEE_MAP.get(department);
        if (manager == null) {
            manager = new Manager(department);
            System.out.println("创建部门经理:" + department);
            String reportContent = department + "部门汇报:此次报告的主要内容是....";
            manager.setReportContent(reportContent);
            System.out.println("创建报告:" + reportContent);
            EMPLOYEE_MAP.put(department, manager);
        }
        return manager;
    }
}
