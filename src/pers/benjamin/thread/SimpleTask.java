package pers.benjamin.thread;

import java.util.concurrent.TimeUnit;

public class SimpleTask implements Runnable {

    private String name;
    private long time;
    private int count;

    public SimpleTask(String name, long time) {
        super();
        this.name = name;
        this.time = time;
        this.count = 0;
    }

    @Override
    public void run() {
        while (count < 5) {
            try {
                System.out.println(Thread.currentThread() + " - " + name + " - running "
                                + Thread.currentThread().getPriority());
                TimeUnit.SECONDS.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                count++;
            }
        }
    }
}
