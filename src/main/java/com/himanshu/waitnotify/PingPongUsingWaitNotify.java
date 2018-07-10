package com.himanshu.waitnotify;

public class PingPongUsingWaitNotify {
  private static Object obj = new Object();
  private static volatile String currentState = "pong";

  public static void main(String[] args) {
    new Thread(new Ping()).start();
    new Thread(new Pong()).start();
  }

  private static class Ping implements Runnable {
    @Override
    public void run() {
      while (true) {
        synchronized (obj) {
          if (currentState.equals("pong")) {
            currentState = "ping";
            System.out.println(currentState);
            obj.notify();
          }
          try {
            obj.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }
  }

  private static class Pong implements Runnable {
    @Override
    public void run() {
      while (true) {
        synchronized (obj) {
          if (currentState.equals("ping")) {
            currentState = "pong";
            System.out.println(currentState);
            obj.notify();
          }
          try {
            obj.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }
  }
}
