package com.himanshu.brainteasers;

import java.util.Arrays;
import java.util.OptionalInt;

public class FindIntegerInArray {

  static String findNumber(int[] arr, int k) {
    OptionalInt result = Arrays.stream(arr).filter(item -> k == item).findFirst();
    return result.isPresent() ? "YES": "NO";
  }

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
    int k = 0;
    System.out.println(findNumber(arr, k));
  }
}
