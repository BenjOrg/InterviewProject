package pers.benjamin.thread;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author Benjamin
 * @date 2020/4/27 22:50
 * @module
 * @purpose
 */
public class CalculateTask implements Runnable {

    private static ThreadLocal<CalculateResult> threadLocal = new ThreadLocal<>() {
        @Override
        protected CalculateResult initialValue() {
            return super.initialValue();
        }
    };

    private List<CalculateResult> localResult;

    private String name;

    private boolean flag;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        CalculateResult result = threadLocal.get();

        if (flag) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long value = this.localResult.stream().mapToLong(CalculateResult::getValue).sum();

        CalculateResult curResult = new CalculateResult();
        curResult.setName(this.name);
        if (null == result) {
            curResult.setValue(value);
            threadLocal.set(curResult);
        } else {
            if (this.name.equals(result.getName())) {
                curResult.setValue(result.getValue() + value);
                threadLocal.set(curResult);
            } else {
                System.err.println(Thread.currentThread().getName() + "  " + result.getName() + " not equal " + this.name);
            }
        }

        System.out.println(curResult.getName() + " " + curResult.getValue());
//        threadLocal.remove();
    }

    public CalculateTask(String name, List<CalculateResult> paramList, boolean flag) {
        this.flag = flag;
        this.name = name;
        this.localResult = paramList;
    }
}
