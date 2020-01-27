package com.lzy.design.pattern.singleton;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-27 22:12
 **/
public class ThreadLocalInstance {
    private static final  ThreadLocal<ThreadLocalInstance> threadLocalInstance
            = new ThreadLocal<ThreadLocalInstance>(){
        @Override
        protected ThreadLocalInstance initialValue() {
            return new ThreadLocalInstance();
        }
    };

    private ThreadLocalInstance() {
    }

    public static ThreadLocalInstance getInstance(){
        return threadLocalInstance.get();
    }
}
