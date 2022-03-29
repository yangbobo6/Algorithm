package com.yangbo.lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: yangbo
 * @Date: 2022-03-28-21:06
 * @Description:
 */
public class LockTest {
    //悲观锁的调用
    public synchronized void testMethod(){

    }

    //乐观锁的调用
    private AtomicInteger atomicInteger = new AtomicInteger(1);
    public void increase(){
        atomicInteger.incrementAndGet();
        System.out.println(atomicInteger);
    }

    public static void main(String[] args) {
        LockTest lockTest = new LockTest();
        lockTest.increase();
    }
}
