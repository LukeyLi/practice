package com.lzy.design.lock.spinlock.queueSpinlock;

import com.lzy.design.lock.spinlock.Lock;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @description:
 * MCS Spinlock 是一种基于链表的可扩展、高性能、公平的自旋锁，申请线程只在本地变量上自旋，
 * 直接前驱负责通知其结束自旋，从而极大地减少了不必要的处理器缓存同步的次数，降低了总线和内存的开销。
 * @author: lzy
 * @create: 2020-02-15 22:09
 **/
public class MCSLock implements Lock {
    public static class MCSNode {
        volatile MCSNode next;
        volatile boolean isLocked = true;
    }

    private static final ThreadLocal<MCSNode> NODE = new ThreadLocal<>();

    //队列
    @SuppressWarnings("unused")
    private volatile MCSNode queue;

    private static final AtomicReferenceFieldUpdater<MCSLock,MCSNode>UPDATE =
            AtomicReferenceFieldUpdater.newUpdater(MCSLock.class,MCSNode.class,"queue");

    @Override
    public void lock() {
        //创建节点并保存到ThreadLocal中
        MCSNode currentNode = new MCSNode();
        NODE.set(currentNode);
        //将queue设置为当前节点，并且返回之前的节点
        MCSNode preNode = UPDATE.getAndSet(this, currentNode);
        if (preNode != null) {
            // 如果之前节点不为null，表示锁已经被其他线程持有
            preNode.next = currentNode;
            // 循环判断，直到当前节点的锁标志位为false
            while (currentNode.isLocked) {
            }
        }
    }

    @Override
    public void unlock() {
        MCSNode currentNode = NODE.get();
        // next为null表示没有正在等待获取锁的线程
        if (currentNode.next == null) {
            // 更新状态并设置queue为null
            if (UPDATE.compareAndSet(this, currentNode, null)) {
                // 如果成功了，表示queue==currentNode,即当前节点后面没有节点了
                return;
            }else {
                // 如果不成功，表示queue!=currentNode,即当前节点后面多了一个节点，表示有线程在等待
                // 如果当前节点的后续节点为null，则需要等待其不为null（参考加锁方法）
                while (currentNode.next == null) {
                }
            }
        }else {
            // 如果不为null，表示有线程在等待获取锁，此时将等待线程对应的节点锁状态更新为false，同时将当前线程的后继节点设为null
            currentNode.next.isLocked = false;
            currentNode.next = null;
        }
    }
}
