package com.lzy.design.pattern.structural.bridge;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-29 16:47
 **/
public abstract class Bank {
    protected Account account;
    public Bank(Account account){
        this.account = account;
    }
    abstract Account openAccount();
}
