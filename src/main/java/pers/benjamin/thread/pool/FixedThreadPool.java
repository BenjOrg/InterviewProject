package pers.benjamin.thread.pool;

import java.util.concurrent.*;

import pers.benjamin.thread.SimpleTask;
import pers.benjamin.thread.factory.CustomThreadFactoryBuilder;

/**
 * FixedThreadPool被称为可重用固定线程数的线程池
 */
public class FixedThreadPool {

    /**
     * FixedThreadPool使用无界队列 LinkedBlockingQueue（队列的容量为Intger.MAX_VALUE）作为线程池的工作队列会对线程池带来如下影响：
     *
     * <ul>
     * <li>1 如果当前运行的线程数小于corePoolSize，则创建新的线程来执行任务；
     * <li>2 当前运行的线程数等于corePoolSize后，将任务加入LinkedBlockingQueue；
     * <li>3 线程执行完1中的任务后，会在循环中反复从LinkedBlockingQueue中获取任务来执行；
     * </ul>
     *
     * <ul>
     * <li>1 当线程池中的线程数达到corePoolSize后，新任务将在无界队列中等待，因此线程池中的线程数不会超过corePoolSize；
     * <li>2 由于1，使用无界队列时maximumPoolSize将是一个无效参数；
     * <li>3 由于1和2，使用无界队列时keepAliveTime将是一个无效参数；
     * <li>4 运行中的FixedThreadPool（未执行shutdown()或shutdownNow()方法）不会拒绝任务
     * </ul>
     */
    public static void main(String[] args) {
        ThreadFactory threadFactory = new CustomThreadFactoryBuilder().setNamePrefix("DemoPool-Thread").setDaemon(false)
                        .setPriority(Thread.MAX_PRIORITY).build();
        ExecutorService executorService = Executors.newFixedThreadPool(2, threadFactory);

        SimpleTask simpleTask = new SimpleTask("task1", 1);
        SimpleTask simpleTask2 = new SimpleTask("task2", 1);
        SimpleTask simpleTask3 = new SimpleTask("task3", 1);

        executorService.execute(simpleTask);
        executorService.execute(simpleTask2);
        executorService.execute(simpleTask3);
    }
}
