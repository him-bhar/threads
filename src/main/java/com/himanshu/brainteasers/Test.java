package com.himanshu.brainteasers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Test {
  public static void main(String[] args) {
    String s1 = "Hello";
    String s2 = "Hello";
    System.out.println(s1 == s2);
    String s3 = new String("Hello");
    System.out.println(s1 == s3);
    System.out.println(s1 == s3.intern());
  }
}
