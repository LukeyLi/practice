package com.lzy.design.pattern.structural.adapter;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-28 22:45
 **/
public class XiaomiAdaptor implements DC5 {
    private AC220 ac220 = new AC220();

    @Override
    public int outputDC5V() {
        int adapterInput = ac220.outputAC220V();
        // 变压器，交流变直流
        int adapterOutput = adapterInput/44;
        System.out.println("使用小米充电器输入 AC:"  + adapterInput +  "V 输出 DC：" + adapterOutput + "V");
        return adapterOutput;
    }
}
