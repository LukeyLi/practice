package com.lzy.design.pattern.creational.builder.v2;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-28 19:28
 **/
public class Test {

    public static void main(String[] args) {
        Course course = new Course.CourseBuilder().builderCourseName("设计模式").buildCoursePPT("PPT").buildCourseVideo("视频").build();
        System.out.println(course);
    }
}
