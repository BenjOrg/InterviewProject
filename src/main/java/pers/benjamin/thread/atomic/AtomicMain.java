package pers.benjamin.thread.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicMain {

    public static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        LocalThread localThread = new LocalThread(2, 5);
        LocalThread localThread2 = new LocalThread(1, 10);
        localThread.start();
        localThread2.start();
    }

    static class LocalThread extends Thread {

        private int offset;
        private int time;

        public LocalThread(int offset, int time) {
            this.offset = offset;
            this.time = time;
        }

        @Override
        public void run() {
            while (true) {
                System.out.println(Thread.currentThread() + " -before " + atomicInteger.get());
                atomicInteger.getAndAdd(this.offset);
                System.out.println(Thread.currentThread() + " -after " + atomicInteger.get());
                try {
                    TimeUnit.SECONDS.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
