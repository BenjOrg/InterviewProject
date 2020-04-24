package pers.benjamin.thread.reject.policy;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import pers.benjamin.thread.SimpleTask;

/**
 * CallerRunsPolicy在任务被拒绝添加后，会调用当前线程池的所在的线程去执行被拒绝的任务
 */
public class CallerRunsPolicyMain {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2, 0, TimeUnit.MICROSECONDS,
                        new LinkedBlockingDeque<Runnable>(2), new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 10; ++i) {
            SimpleTask simpleTask = new SimpleTask("task" + i, 1);
            executor.execute(simpleTask);
        }
    }
}
