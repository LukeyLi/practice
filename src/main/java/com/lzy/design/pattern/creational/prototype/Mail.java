package com.lzy.design.pattern.creational.prototype;

import lombok.Data;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-28 11:10
 **/
@Data
public class Mail implements Cloneable {
    private String name;
    private String emailAddress;
    private String content;

    public Mail(){
        System.out.println("Mail Class Contructor");
    }

    @Override
    public String toString() {
        return "Mail{" +
                "name='" + name + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", content='" + content + '\'' +
                '}' + super.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        System.out.println("clone mail object");
        return super.clone();
    }
}
