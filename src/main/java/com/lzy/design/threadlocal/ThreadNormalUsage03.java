package com.lzy.design.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:
 * @author: lzy
 * @create: 2020-02-21 23:25
 **/
public class ThreadNormalUsage03 {
    public static ExecutorService threadPool = Executors.newFixedThreadPool(10);
    //只创建一次 SimpleDateFormat 对象，避免不必要的资源消耗
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            int num = i;
            //提交任务
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    String date = new ThreadNormalUsage03().date(num);
                    System.out.println(date);
                }
            });
        }
        threadPool.shutdown();
    }

    public String date(int seconds) {
        //参数的单位是毫秒，从1970.1.1 00:00:00 GMT 开始计时
        Date date = new Date(1000 * seconds);
        return dateFormat.format(date);
    }
}
