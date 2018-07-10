package com.himanshu.brainteasers;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CustomArrayBlockingQueue<T> {
  private final int size;
  private Object[] arr;
  private Lock lock = new ReentrantLock();
  private Condition notEmpty = lock.newCondition();
  private Condition notFull = lock.newCondition();
  private int index = 0;

  public CustomArrayBlockingQueue(int size) {
    this.size = size;
    this.arr = new Object[size];
  }

  public void add(T t) {
    try {
      lock.lockInterruptibly();
      while(arr.length == size) {
        //Array is full, need to wait
        notFull.await();
      }
      arr[index++] = t;
      notEmpty.signalAll();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }

  public void remove() {
    try {
      lock.lockInterruptibly();
      while(arr.length == 0) {
        //Array is empty, need to wait
        notEmpty.await();
      }
      arr[index--] = null;
      notFull.signalAll();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }
}
