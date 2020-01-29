package com.lzy.design.pattern.behavioral.observer;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-29 20:23
 **/
public class Test {
    public static void main(String[] args) {
        Course course = new Course("这是个数学课");
        Teacher teacher1 = new Teacher("Li");
        Teacher teacher2 = new Teacher("Lin");
        course.addObserver(teacher1);
        course.addObserver(teacher2);
        //业务逻辑代码
        Question question = new Question();
        question.setUserName("LaoWang");
        question.setQuestionContent("证明1 = 0.9循环");
        course.produceQuestion(course,question);
    }
}
