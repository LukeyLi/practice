package com.lzy.design.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description: 1000个线程打印日期，用线程池来执行
 * @author: lzy
 * @create: 2020-02-21 23:17
 **/
public class ThreadNormalUsage02 {
    private static ExecutorService threadPool = Executors.newFixedThreadPool(1000);

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            int num = i;
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    String date = new ThreadNormalUsage02().date(num);
                    System.out.println(date);
                }
            });
        }
    }

    public String date(int seconds) {

        //参数的单位是毫秒，从1970.1.1 00:00:00 GMT 开始计时
        Date date = new Date(1000 * seconds);
        //多次创建，不必要的资源消耗
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.format(date);
    }

}
