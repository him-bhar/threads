package com.himanshu.waitnotify;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PingPongUsingCondition {
  private static Lock lock = new ReentrantLock();
  private static Condition lockCondition = lock.newCondition();
  private static volatile String currentState = "pong";

  public static void main(String[] args) {
    new Thread(new Ping()).start();
    new Thread(new Pong()).start();
  }

  private static class Ping implements Runnable {
    @Override
    public void run() {
      while (true) {
        try {
          lock.lockInterruptibly();
          if (currentState.equals("pong")) {
            currentState = "ping";
            System.out.println(currentState);
            lockCondition.signal();
          }
          lockCondition.await();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  private static class Pong implements Runnable {
    @Override
    public void run() {
      while (true) {
        try {
          lock.lockInterruptibly();
          if (currentState.equals("ping")) {
            currentState = "pong";
            System.out.println(currentState);
            lockCondition.signal();
          }
          lockCondition.await();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
