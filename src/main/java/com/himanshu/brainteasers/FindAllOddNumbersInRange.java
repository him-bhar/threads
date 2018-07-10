package com.himanshu.brainteasers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindAllOddNumbersInRange {
  static int[] oddNumbers(int l, int r) {
    List<Integer> resultList = IntStream.rangeClosed(l, r).boxed().filter(item -> item%2 != 0).collect(Collectors.toList());
    int arr[] = new int[resultList.size()];
    for (int i=0;i<resultList.size();i++) {
      arr[i] = resultList.get(i);
    }
    return arr;
  }

  public static void main(String[] args) {
    int[] result = oddNumbers(1, 9);
    for (int i=0;i<result.length;i++) {
      System.out.println(result[i]);
    }

  }
}
