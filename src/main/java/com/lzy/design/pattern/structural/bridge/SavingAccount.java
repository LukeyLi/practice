package com.lzy.design.pattern.structural.bridge;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-29 16:48
 **/
public class SavingAccount implements Account {
    @Override
    public Account openAccount() {
        System.out.println("打开活期账号");
        //...
        return new SavingAccount();
    }

    @Override
    public void showAccountType() {
        System.out.println("这是一个活期账号");
    }

}
