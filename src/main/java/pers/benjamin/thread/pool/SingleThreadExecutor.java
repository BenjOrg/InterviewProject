package pers.benjamin.thread.pool;

import java.util.concurrent.*;

import pers.benjamin.thread.SimpleTask;
import pers.benjamin.thread.factory.CustomThreadFactoryBuilder;

/**
 * SingleThreadExecutor是使用单个worker线程的Executor
 */
public class SingleThreadExecutor {

    public static void main(String[] args) {
        ThreadFactory threadFactory = new CustomThreadFactoryBuilder().setNamePrefix("DemoPool-Thread").setDaemon(false)
                        .setPriority(Thread.MAX_PRIORITY).build();
        ExecutorService executorService = Executors.newSingleThreadExecutor(threadFactory);

        SimpleTask simpleTask = new SimpleTask("task1", 1);
        SimpleTask simpleTask2 = new SimpleTask("task2", 1);

        executorService.execute(simpleTask);
        executorService.execute(simpleTask2);
    }
}
