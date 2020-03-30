package pers.benjamin.thread.reject.policy;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import pers.benjamin.thread.SimpleTask;

/**
 * 任务呗拒绝添加时，会抛弃任务队列中最旧的任务也就是最先加入队列的，再把这个新任务添加进去
 */
public class DiscardOldestPolicyMain {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2, 0, TimeUnit.MICROSECONDS,
                        new LinkedBlockingDeque<Runnable>(2), new ThreadPoolExecutor.DiscardOldestPolicy());

        for (int i = 0; i < 10; ++i) {
            SimpleTask simpleTask = new SimpleTask("task" + i, 1);
            executor.execute(simpleTask);
        }
    }
}
