package pers.benjamin.thread.pool;

import pers.benjamin.thread.CalculateResult;
import pers.benjamin.thread.CalculateTask;
import pers.benjamin.thread.factory.CustomThreadFactoryBuilder;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

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
//        ExecutorService executorService = Executors.newFixedThreadPool(2, threadFactory);
        ExecutorService executorService =
                new ThreadPoolExecutor(2, 4,
                        10L, TimeUnit.SECONDS,
                        new LinkedBlockingQueue<Runnable>(),
                        threadFactory);

//        SimpleTask simpleTask = new SimpleTask("task1", 1);
//        SimpleTask simpleTask2 = new SimpleTask("task2", 1);
//        SimpleTask simpleTask3 = new SimpleTask("task3", 1);
//
//        executorService.execute(simpleTask);
//        executorService.execute(simpleTask2);
//        executorService.execute(simpleTask3);

        List<CalculateTask> calculateTasks = new ArrayList<>();

        long ra = 0;
        long rb = 0;
        long rc = 0;
        long rd = 0;

        for (int i = 0; i < 2; i++) {
            List<CalculateResult> listA = constructArray("IdA");
            List<CalculateResult> listB = constructArray("IdB");
            List<CalculateResult> listC = constructArray("IdC");
            List<CalculateResult> listD = constructArray("IdD");

            long a = listA.stream().mapToLong(CalculateResult::getValue).sum();
            long b = listB.stream().mapToLong(CalculateResult::getValue).sum();
            long c = listC.stream().mapToLong(CalculateResult::getValue).sum();
            long d = listD.stream().mapToLong(CalculateResult::getValue).sum();

            ra += a;
            rb += b;
            rc += c;
            rd += d;

            System.out.println("idA:" + Arrays.toString(listA.stream().map(CalculateResult::getValue).toArray()) + " sum:" + a);
            System.out.println("idB:" + Arrays.toString(listB.stream().map(CalculateResult::getValue).toArray()) + " sum:" + b);
            System.out.println("idC:" + Arrays.toString(listC.stream().map(CalculateResult::getValue).toArray()) + " sum:" + c);
            System.out.println("idD:" + Arrays.toString(listD.stream().map(CalculateResult::getValue).toArray()) + " sum:" + d);

            CalculateTask taskA = new CalculateTask("IdA", listA, true);
            CalculateTask taskB = new CalculateTask("IdB", listB, false);
            CalculateTask taskC = new CalculateTask("IdC", listC, false);
            CalculateTask taskD = new CalculateTask("IdD", listD, true);
            calculateTasks.add(taskA);
            calculateTasks.add(taskB);
            calculateTasks.add(taskC);
            calculateTasks.add(taskD);

        }

        System.out.println(ra);
        System.out.println(rb);
        System.out.println(rc);
        System.out.println(rd);

        System.out.println("---------------------------------------------------");

        for (CalculateTask task : calculateTasks) {
            executorService.execute(task);
        }
    }

    private static List<CalculateResult> constructArray(String name) {
        List<CalculateResult> calculateResultList = new ArrayList<>(50);
        CalculateResult result;
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            result = new CalculateResult();
            result.setName(name);
            result.setValue((long) random.nextInt());
            calculateResultList.add(result);
        }

        return calculateResultList;
    }
}
