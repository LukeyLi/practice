package com.lzy.design.pattern.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-28 18:51
 **/
public class CourseAggregateImpl implements CourseAggregate {

    private List courseList;

    public CourseAggregateImpl() {
        this.courseList = new ArrayList();
    }

    @Override
    public void addCourse(Course course) {
        courseList.add(course);
    }

    @Override
    public void removeCourse(Course course) {
        courseList.remove(course);
    }

    @Override
    public CourseIterator getCourseIterator() {
        return new CourseIteratorImpl(courseList);
    }
}
