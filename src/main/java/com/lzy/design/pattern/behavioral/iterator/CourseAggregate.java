package com.lzy.design.pattern.behavioral.iterator;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-28 18:51
 **/
public interface CourseAggregate {

    void addCourse(Course course);
    void removeCourse(Course course);

    CourseIterator getCourseIterator();
}
