package com.himanshu.brainteasers;

public class MaximumArrayDifference {
  /*static int maxDiff(int a[]) {
    int maxDifference = a[1] - a[0];
    int minElement = a[0];
    for (int i = 1; i < a.length; i++) {
      if (a[i] - minElement > maxDifference) {
        maxDifference = a[i] - minElement;
      }
      if (a[i] < minElement) {
        minElement = a[i];
      }
    }
    return maxDifference;
  }*/

  /*int maxDiff(int a[]) {
    int maxDiff = a[1] - a[0];
    for (int i = 0; i < a.length; i++) {
      for (int j = i + 1; j < a.length; j++) {
        if (a[j] - a[i] > maxDiff)
          maxDiff = a[j] - a[i];
      }
    }
    return maxDiff;
  }*/

  int maxDiff(int a[]) {
    int diff[] = new int[a.length - 1];
    for (int i = 0; i < a.length - 1; i++) {
      diff[i] = a[i + 1] - a[i];
    }
    int maxDiff = diff[0];
    for (int i = 1; i < a.length - 1; i++) {
      if (diff[i - 1] > 0) {
        diff[i] += diff[i - 1];
      }
      if (maxDiff < diff[i]) {
        maxDiff = diff[i];
      }
    }
    return maxDiff;
  }

  /* Driver program to test above functions */
  public static void main(String[] args)
  {
    MaximumArrayDifference maxdif = new MaximumArrayDifference();
    int arr[] = {1, 2, 90, 10, 110};
    int size = arr.length;
    System.out.println("MaximumDifference is " +  maxdif.maxDiff(arr));
  }
}
