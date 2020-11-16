package pers.benjamin.thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchMain {

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);

        Thread t1 = createThread(latch);
        Thread t2 = createThread(latch);

        t1.start();
        t2.start();

        try {
            System.out.println("等待2个子线程执行完毕...");
            latch.await();
            System.out.println("2个子线程已经执行完毕");
            System.out.println("继续执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static Thread createThread(CountDownLatch latch) {
        return new Thread(() -> {
            try {
                System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                Thread.sleep(3000);
                System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
