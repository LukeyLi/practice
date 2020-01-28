package com.lzy.design.pattern.prototype;

import java.text.MessageFormat;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-28 11:10
 **/
public class MailUtil {
    public static void sendMail(Mail mail) {
        String outputContent = "向{0}同学,发送邮件地址：{1}, 邮件内容：{2}发送邮件成功";
        System.out.println(MessageFormat.format(outputContent, mail.getName(), mail.getEmailAddress(), mail.getContent()));
    }

    public static void saveOriginMailRecord(Mail mail) {
        System.out.println("存储 originMail记录, originMail:" + mail.getContent());
    }
}
