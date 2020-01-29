package com.lzy.design.pattern.structural.bridge;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-29 16:48
 **/
public class DepositAccount  implements Account {

    @Override
    public Account openAccount() {
        System.out.println("打开定期账号");
        return new DepositAccount();
    }

    @Override
    public void showAccountType() {
        System.out.println("这是一个定期账号");
    }
}
