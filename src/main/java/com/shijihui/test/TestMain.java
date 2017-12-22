package com.shijihui.test;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by jiangzhiyong on 16/12/15.
 */
public class TestMain {

    public static void main(String[] args) {
        Thread threada = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("a run ...");
                for ( int i = 0; i < 1000; i++) {
                    System.out.println("i = " + i);
                    if ( i == 600) {
                        LockSupport.park();
                    }
                }
                System.out.println("a over ...");
            }
        });
        System.out.println("start...");
        threada.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LockSupport.unpark(threada);
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end...");
    }
}
