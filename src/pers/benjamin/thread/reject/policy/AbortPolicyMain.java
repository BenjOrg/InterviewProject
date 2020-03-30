package pers.benjamin.thread.reject.policy;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import pers.benjamin.thread.SimpleTask;

/**
 * 默认，直接抛出异常
 */
public class AbortPolicyMain {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2, 0, TimeUnit.MICROSECONDS,
                        new LinkedBlockingDeque<Runnable>(2), new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 5; ++i) {
            SimpleTask simpleTask = new SimpleTask("task" + i, 1);
            executor.execute(simpleTask);
        }
    }
}
