package com.lzy.design.pattern.structural.adapter;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-28 22:45
 **/
public class AC220 {
    public int outputAC220V(){
        int output = 220;
        System.out.println("输出交流电：" + output + " V");
        return output;
    }
}
