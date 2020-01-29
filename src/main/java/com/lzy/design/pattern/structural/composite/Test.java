package com.lzy.design.pattern.structural.composite;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-29 15:49
 **/
public class Test {
    public static void main(String[] args) {

        CatalogComponent javaCourseCatalog = new CourseCatalog("Java课程目录", 2);
        CatalogComponent designPattern = new Course("Java设计模式",50);
        CatalogComponent javaBasic = new Course("java基础",11);
        CatalogComponent dataStruct = new Course("java数据结构",11);

        javaCourseCatalog.add(javaBasic);
        javaCourseCatalog.add(dataStruct);
        javaCourseCatalog.add(designPattern);

        CatalogComponent mainCourseCatalog = new CourseCatalog("Java课程主目录",1);
        CatalogComponent linuxCourse = new Course("Linux课程",11);
        CatalogComponent windowsCourse = new Course("Windows课程",11);
        mainCourseCatalog.add(linuxCourse);
        mainCourseCatalog.add(windowsCourse);
        mainCourseCatalog.add(javaCourseCatalog);
        mainCourseCatalog.print();
    }
}
