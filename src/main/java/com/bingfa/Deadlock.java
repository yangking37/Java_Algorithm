package com.bingfa;


import java.util.concurrent.ThreadPoolExecutor;

import static java.lang.Thread.sleep;
public class Deadlock {

    public static void main(String[] args) {
//        Object A = new Object();
//        Object B = new Object();
//        Thread t1 = new Thread(() -> {
//            synchronized (A) {
//                System.out.println("lock A");
//                try {
//                    sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                synchronized (B) {
//                    System.out.println("lock B");
//                    System.out.println("操作...");
//                }
//            }
//        }, "t1");
//
//        Thread t2 = new Thread(() -> {
//            synchronized (B) {
//                System.out.println("lock B");
//                try {
//                    sleep(500);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                synchronized (A) {
//                    System.out.println("lock A");
//                    System.out.println("操作...");
//                }
//            }
//        }, "t2");
//        t1.start();
//        t2.start();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 60, null, null);
        
    }
}