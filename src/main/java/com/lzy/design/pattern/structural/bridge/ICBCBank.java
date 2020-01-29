package com.lzy.design.pattern.structural.bridge;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-29 16:48
 **/
public class ICBCBank extends Bank {

    public ICBCBank(Account account) {
        super(account);
    }

    @Override
    Account openAccount() {
        System.out.println("打开中国工商银行账号");
        account.openAccount();
        return account;
    }
}
