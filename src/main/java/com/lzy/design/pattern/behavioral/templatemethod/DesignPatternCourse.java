package com.lzy.design.pattern.behavioral.templatemethod;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-28 18:23
 **/
public class DesignPatternCourse extends ACourse {
    @Override
    void packageCourse() {
        System.out.println("提供课程Java源代码");
    }

    @Override
    protected boolean needWriteArticle() {
        return true;
    }

}
