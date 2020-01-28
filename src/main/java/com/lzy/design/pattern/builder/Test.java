package com.lzy.design.pattern.builder;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-28 17:42
 **/
public class Test {
    public static void main(String[] args) {
        CourseBuilder courseBuilder = new CourseActualBuilder();
        Teacher teacher = new Teacher();
        teacher.setCourseBuilder(courseBuilder);
        Course course = teacher.makeCourse("设计模式", "PPT",
                "视频", "手记", "问答");
        System.out.println(course);
    }
}
