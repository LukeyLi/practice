package com.lzy.design.pattern.singleton;

import java.lang.reflect.Method;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-27 19:17
 **/
public class Test {
    //序列化
//    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        HungrySingleton instance = HungrySingleton.getInstance();
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton_file"));
//        oos.writeObject(instance);
//
//        File file = new File("singleton_file");
//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
//        HungrySingleton newInstance = (HungrySingleton) ois.readObject();
//        System.out.println(instance);
//        System.out.println(newInstance);
//        System.out.println(instance == newInstance);
//    }
    /**
     * 反射攻击解决方案及原理
     * 破坏原理：通过反射暴力访问
     * 解决原理：在单例类的私有化构造方法中添加防放射破坏代码,如果是通过反射调用就抛出运行时异常
     */
//    public static void main(String[] args) throws Exception {
//        Class objectClass = HungrySingleton.class;
//        Constructor constructor = objectClass.getDeclaredConstructor();
//        HungrySingleton instance = HungrySingleton.getInstance();
//        constructor.setAccessible(true);
//        HungrySingleton object = (HungrySingleton) constructor.newInstance();
//        System.out.println(instance);
//        System.out.println(object);
//        System.out.println(instance == object);
//    }

    //克隆
    public static void main(String[] args) throws  Exception {
        HungrySingleton hungrySingleton = HungrySingleton.getInstance();

        Method method = hungrySingleton.getClass().getDeclaredMethod("clone");
        method.setAccessible(true);
        HungrySingleton cloneHungrySingleton = (HungrySingleton) method.invoke(hungrySingleton);
        System.out.println(hungrySingleton);
        System.out.println(cloneHungrySingleton);
        System.out.println(hungrySingleton == cloneHungrySingleton);
    }
}
