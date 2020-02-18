package com.lzy.design.lock.spinlock.queueSpinlock;

import com.lzy.design.lock.spinlock.Lock;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @description:
 * CLH 是一种基于链表的可扩展，高性能，公平的自旋锁，申请线程只能在本地变量上自旋，
 * 它会不断轮询前驱的状态，如果发现前驱释放了锁就结束自旋。
 * 步骤
 * 1.创建一个CLHNode,将其中的locked设置为true表示需要获取锁
 * 2.线程对tail域调用getAndSet方法，使自己成为队列的尾部，同时获取一个指向其前趋结点的引用myPred
 * 3.该线程就在前趋结点的locked字段上旋转，直到前趋结点释放锁
 * 4.当一个线程需要释放锁时，将当前结点的locked域设置为false，同时回收前趋结点
 * @author: lzy
 * @create: 2020-02-15 20:37
 **/
public class CLHLock implements Lock {
    public static class CLHNode{
        private volatile boolean isLocked = true;
    }
    //尾部节点
    private volatile CLHNode tail;

    private static final ThreadLocal<CLHNode> LOCAL = new ThreadLocal<>();

    private static final AtomicReferenceFieldUpdater<CLHLock,CLHNode> UPDATER =
            AtomicReferenceFieldUpdater.newUpdater(CLHLock.class,CLHNode.class,"tail");

    @Override
    public void lock(){
        CLHNode node = new CLHNode();
        LOCAL.set(node);
        // 将新建的节点设置为尾部节点，并返回旧的节点（原子操作），这里旧的节点实际上就是当前节点的前驱节点
        CLHNode preNode = UPDATER.getAndSet(this, node);
        if(preNode != null) {
            System.out.println("线程" + Thread.currentThread().getName() + "现在有位置吗?" + preNode.isLocked + "，我需要吃饭吗:" + tail.isLocked );
            // 前驱节点不为null表示当锁被其他线程占用，通过不断轮询判断前驱节点的锁标志位等待前驱节点释放锁
            while (preNode.isLocked) {
                System.out.println("线程" + Thread.currentThread().getName() + "还在排队" );
            }
            System.out.println("线程" +  Thread.currentThread().getName() + "不需要排队了" );
            preNode = null;
            LOCAL.set(node);
        } else {
            System.out.println("线程" +  Thread.currentThread().getName() + "前面没人，我可以直接吃饭" );
        }
        // 如果不存在前驱节点，表示该锁没有被其他线程占用，则当前线程获得锁
    }

    @Override
    public void unlock() {
        // 获取当前线程对应的节点
        CLHNode node = LOCAL.get();
        System.out.println("线程" + Thread.currentThread().getName() + "用完餐了，我需要更改自己的锁：" + node.isLocked);
        // 如果tail节点等于node，则将tail节点更新为null，同时将node的lock状态职位false，表示当前线程释放了锁
        if (!UPDATER.compareAndSet(this, node, null)) {
            System.out.println("线程" + Thread.currentThread().getName() + "开始叫下一位" + tail.isLocked);
            node.isLocked = false;
        }
        System.out.println("线程" + Thread.currentThread().getName() + "说了一句，我要删除自己的信息了");
        node = null;
    }
}
