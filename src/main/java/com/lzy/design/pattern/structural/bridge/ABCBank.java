package com.lzy.design.pattern.structural.bridge;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-29 16:47
 **/
public class ABCBank extends Bank {
    public ABCBank(Account account) {
        super(account);
    }

    @Override
    Account openAccount() {
        System.out.println("打开中国农业银行账号");
        account.openAccount();
        return account;
    }
}
