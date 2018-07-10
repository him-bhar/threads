package com.himanshu.thread.datastructures;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountDownLatchDemo {
  private static Logger logger = LoggerFactory.getLogger(CountDownLatchDemo.class);
  private static CountDownLatch countDownLatch = new CountDownLatch(3);



  public static Supplier<Runnable> runnableSupplier() {
    return () -> createLatchDemoRunnable(RandomStringUtils.randomAlphanumeric(6));
  }

  public static Runnable createLatchDemoRunnable(String input) {
    return () -> {
      try {
        Thread.sleep(3000l);
        logger.info(input);
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        countDownLatch.countDown();
      }

    };
  }

  private static AtomicInteger threadCounter = new AtomicInteger(0);

  public static void main(String[] args) throws InterruptedException {
    ExecutorService executorService = Executors.newFixedThreadPool(2, (r) -> new Thread(r, "Latch-Demo-"+threadCounter.incrementAndGet()));
    Thread notifier = new Thread(() -> {
      try {
        Thread.sleep(20000l);
        synchronized (CountDownLatchDemo.class) {
          CountDownLatchDemo.class.notify();
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });
    notifier.start();

    Runtime.getRuntime().addShutdownHook(new Thread(() -> logger.info("Blah dee blah! Bbye")));
    /**
     * Business login here
     */
    List<Runnable> runnables = Stream.generate(runnableSupplier()).limit(3).collect(Collectors.toList());
    runnables.stream().map(executorService::submit).forEach(future -> logger.info(future.toString()));
    countDownLatch.await(4, TimeUnit.SECONDS);
    executorService.shutdownNow();
    /**
     * Ends here
     */

    /*synchronized (CountDownLatchDemo.class) {
      CountDownLatchDemo.class.wait();
    }*/
  }
}
