package 交替打印;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class 线程交替打印 {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Semaphore A = new Semaphore(1);
        Semaphore B = new Semaphore(0);
        Semaphore C = new Semaphore(0);

        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    A.acquire();
                    System.out.println("AAAAAA");
                    B.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();

        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    B.acquire();
                    System.out.println("BBBBBB");
                    C.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B").start();
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    C.acquire();
                    System.out.println("CCCCCC");
                    A.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "C").start();
    }
}