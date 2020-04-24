package pers.benjamin.thread.reject.policy;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import pers.benjamin.thread.SimpleTask;

/**
 * 被线程池拒绝的任务直接抛弃，不会抛异常也不会执行
 */
public class DiscardPolicyMain {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2, 0, TimeUnit.MICROSECONDS,
                        new LinkedBlockingDeque<Runnable>(2), new ThreadPoolExecutor.DiscardPolicy());

        for (int i = 0; i < 10; ++i) {
            SimpleTask simpleTask = new SimpleTask("task" + i, 1);
            executor.execute(simpleTask);
        }
    }
}
