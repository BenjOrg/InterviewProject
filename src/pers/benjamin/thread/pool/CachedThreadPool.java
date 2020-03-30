package pers.benjamin.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import pers.benjamin.thread.SimpleTask;
import pers.benjamin.thread.factory.CustomThreadFactoryBuilder;

/**
 * CachedThreadPool是一个会根据需要创建新线程的线程池
 */
public class CachedThreadPool {
    /**
     * <ul>
     * <li>1-首先执行SynchronousQueue.offer。如果当前maximumPool中有闲线程正在执行SynchronousQueue.poll(keepAliveTime,TimeUnit.NANOSECONDS)，那么主线程执行offer操作与空闲线程执行的poll操作配对成功，主线程把任务交给空闲线程执行，execute()方法执行完成，否则执行下面的步骤2；
     * <li>2-当初始maximumPool为空，或者maximumPool中没有空闲线程时，将没有线程执行SynchronousQueue.poll(keepAliveTime,TimeUnit.NANOSECONDS)。这种情况下，步骤1将失败，此时CachedThreadPool会创建新线程执行任务，execute方法执行完成；
     * </ul>
     */
    public static void main(String[] args) {
        ThreadFactory threadFactory = new CustomThreadFactoryBuilder().setNamePrefix("DemoPool-Thread").setDaemon(false)
                        .setPriority(Thread.MAX_PRIORITY).build();
        ExecutorService executorService = Executors.newCachedThreadPool(threadFactory);

        SimpleTask simpleTask = new SimpleTask("task1", 1);
        SimpleTask simpleTask2 = new SimpleTask("task2", 1);
        SimpleTask simpleTask3 = new SimpleTask("task3", 1);

        executorService.execute(simpleTask);
        executorService.execute(simpleTask2);
        executorService.execute(simpleTask3);
    }
}
