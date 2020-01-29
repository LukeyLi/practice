package com.lzy.design.pattern.structural.flyweight;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-29 11:59
 **/
public class Manager implements Employee{
    private String title = "部门经理";
    private String department;
    private String reportContent;

    public Manager(String department) {
        this.department = department;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    @Override
    public void report() {
        System.out.println(reportContent);
    }
}
