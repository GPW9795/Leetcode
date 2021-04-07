package 交替打印;

import java.util.concurrent.Semaphore;

/**
 * https://leetcode-cn.com/problems/print-in-order/
 */
public class _1114_按序打印_Y {
    private volatile int num = 1;

    public _1114_按序打印_Y() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        num++;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (num != 2) {
        }
        printSecond.run();
        num++;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (num != 3) {
        }
        printThird.run();
        num = 1;
    }
}

class other {
    private Semaphore first = new Semaphore(1);
    private Semaphore second = new Semaphore(0);
    private Semaphore third = new Semaphore(0);

    public other() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        first.acquire();
        printFirst.run();
        second.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        second.acquire();
        printSecond.run();
        third.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        third.acquire();
        printThird.run();
        first.release();
    }
}