package com.itheima;

import org.junit.jupiter.api.Test;

/**
 * @author Shujie Liu
 * @project big-event
 * @date 2025/10/30
 */
public class ThreadLocalTest {

    @Test
    public void testThreadLocalSetAndGet() {
        // 提供一个ThreadLocal对象
        ThreadLocal<String> tl = new ThreadLocal<>();

        // 开启两个线程
        new Thread(() -> {
            tl.set("箫炎");
            System.out.println(Thread.currentThread().getName() + "线程：" + tl.get());
            System.out.println(Thread.currentThread().getName() + "线程：" + tl.get());
            System.out.println(Thread.currentThread().getName() + "线程：" + tl.get());
        }, "蓝色").start();

        new Thread(() -> {
            tl.set("药尘");
            System.out.println(Thread.currentThread().getName() + "线程：" + tl.get());
            System.out.println(Thread.currentThread().getName() + "线程：" + tl.get());
            System.out.println(Thread.currentThread().getName() + "线程：" + tl.get());
        }, "绿色").start();
    }

}