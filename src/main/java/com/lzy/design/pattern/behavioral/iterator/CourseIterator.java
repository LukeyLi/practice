package com.lzy.design.pattern.behavioral.iterator;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-28 18:52
 **/
public interface CourseIterator {
    Course nextCourse();
    boolean isLastCourse();
}
