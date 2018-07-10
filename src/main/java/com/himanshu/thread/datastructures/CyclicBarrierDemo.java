package com.himanshu.thread.datastructures;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CyclicBarrierDemo {
  private static Logger logger = LoggerFactory.getLogger(CountDownLatchDemo.class);
  private static CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> logger.info("Barrier completed!"));

  public static Supplier<Runnable> runnableSupplier() {
    return () -> createBarrierDemoRunnable(RandomStringUtils.randomAlphanumeric(6));
  }

  public static Runnable createBarrierDemoRunnable(String input) {
    return () -> {
      try {
        Thread.sleep(3000l);
        cyclicBarrier.await();
        logger.info(input);
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (BrokenBarrierException e) {
        e.printStackTrace();
      }
    };
  }

  public static void main(String[] args) {
    List<Runnable> runnables = Stream.generate(runnableSupplier()).limit(9).collect(Collectors.toList());
    ExecutorService executorService = Executors.newFixedThreadPool(4);
    runnables.stream().map(executorService::submit).forEach(f -> logger.info(f.toString()));
    executorService.shutdown();
  }

}
