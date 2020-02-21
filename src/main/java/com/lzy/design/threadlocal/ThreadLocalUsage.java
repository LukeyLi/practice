package com.lzy.design.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:  利用 ThreadLocal 给每个线程分配自己的 dateFormat 对象
 * 不但保证了线程安全，还高效的利用了内存
 * @author: lzy
 * @create: 2020-02-21 23:30
 **/
public class ThreadLocalUsage {

    public static ExecutorService threadPool = Executors.newFixedThreadPool(10);

    public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = new
            ThreadLocal<SimpleDateFormat>(){
                //创建一份 SimpleDateFormat 对象
                @Override
                protected SimpleDateFormat initialValue() {
                    return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                }
            };

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            int num = i;
            //提交任务
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    String date = new ThreadLocalUsage().date(num);
                    System.out.println(date);
                }
            });
        }
        threadPool.shutdown();
    }

    public String date(int seconds){
        Date date = new Date(1000 * seconds);
        SimpleDateFormat dateFormat = dateFormatThreadLocal.get();
        return dateFormat.format(date);
    }
}
