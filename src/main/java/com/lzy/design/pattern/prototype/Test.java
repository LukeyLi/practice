package com.lzy.design.pattern.prototype;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-28 11:10
 **/
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Mail mail = new Mail();
        mail.setContent("初始化模板");
        System.out.println("初始化mail:"+mail);
        // 需要 new 很多实例对象，并且想将原始邮件模板进行保存
        for (int i = 0; i < 10; i++) {
            Mail mailTemp = (Mail) mail.clone();
            mail.setName("姓名" + i);
            mail.setEmailAddress("姓名" + i + "@163.com");
            mail.setContent("恭喜你，中奖了");
            MailUtil.sendMail(mailTemp);
            System.out.println("克隆的mailTemp:" + mailTemp);
        }
        MailUtil.saveOriginMailRecord(mail);
    }
}
