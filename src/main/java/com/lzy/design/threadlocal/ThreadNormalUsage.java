package com.lzy.design.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description: 两个线程打印日期
 * @author: lzy
 * @create: 2020-02-21 23:01
 **/
public class ThreadNormalUsage {
    public String date(int seconds) {
        Date date = new Date(1000 * seconds);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.format(date);
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String date = new ThreadNormalUsage().date(1);
                System.out.println(date);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                String date = new ThreadNormalUsage().date(86400);
                System.out.println(date);
            }
        }).start();
    }
}
