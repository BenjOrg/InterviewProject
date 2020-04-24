package pers.benjamin.thread.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import pers.benjamin.thread.SimpleTask;
import pers.benjamin.thread.factory.CustomThreadFactoryBuilder;

/**
 * 适用于需要单个后台线程执行周期任务，同时保证顺序地执行各个任务的应用场景
 */
public class SingleThreadScheduledExecutor {

    public static void main(String[] args) {
        ThreadFactory threadFactory = new CustomThreadFactoryBuilder().setNamePrefix("DemoPool-Thread").setDaemon(false)
                        .setPriority(Thread.MAX_PRIORITY).build();
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor(threadFactory);

        SimpleTask simpleTask = new SimpleTask("task1", 1);
        SimpleTask simpleTask2 = new SimpleTask("task2", 1);
        SimpleTask simpleTask3 = new SimpleTask("task3", 1);

        scheduledExecutorService.schedule(simpleTask, 1, TimeUnit.SECONDS);
        scheduledExecutorService.schedule(simpleTask2, 1, TimeUnit.SECONDS);
        scheduledExecutorService.schedule(simpleTask3, 1, TimeUnit.SECONDS);
    }
}
