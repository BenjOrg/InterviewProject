package pers.benjamin.thread.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import pers.benjamin.thread.SimpleTask;
import pers.benjamin.thread.factory.CustomThreadFactoryBuilder;

/**
 * ScheduledThreadPoolExecutor主要用来在给定的延迟后运行任务，或者定期执行任务
 */
public class ScheduleThreadPool {

    /**
     * <ul>
     * <li>线程1从DelayQueue中获取已到期的ScheduledFutureTask（DelayQueue.take()）。到期任务是指ScheduledFutureTask的time大于等于当前系统的时间；
     * <li>线程1执行这个ScheduledFutureTask；
     * <li>线程1修改ScheduledFutureTask的time变量为下次将要被执行的时间；
     * <li>线程1把这个修改time之后的ScheduledFutureTask放回DelayQueue中（DelayQueue.add())。
     * </ul>
     */
    public static void main(String[] args) {
        ThreadFactory threadFactory = new CustomThreadFactoryBuilder().setNamePrefix("DemoPool-Thread").setDaemon(false)
                        .setPriority(Thread.MAX_PRIORITY).build();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2, threadFactory);

        SimpleTask simpleTask = new SimpleTask("task1", 1);
        SimpleTask simpleTask2 = new SimpleTask("task2", 1);
        SimpleTask simpleTask3 = new SimpleTask("task3", 1);

        scheduledExecutorService.schedule(simpleTask, 1, TimeUnit.SECONDS);
        scheduledExecutorService.schedule(simpleTask2, 1, TimeUnit.SECONDS);
        scheduledExecutorService.schedule(simpleTask3, 1, TimeUnit.SECONDS);
    }
}
