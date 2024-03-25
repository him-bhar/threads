package com.himanshu.algorithms.leetcode;

/**
 * Find subarray with given sum
 * Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
 * Output: Sum found between indexes 2 and 4
 * Sum of elements between indices 2 and 4 is 20 + 3 + 10 = 33
 *
 * Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
 * Output: Sum found between indexes 1 and 4
 * Sum of elements between indices 1 and 4 is 4 + 0 + 0 + 3 = 7
 *
 * Input: arr[] = {1, 4}, sum = 0
 * Output: No subarray found
 * There is no subarray with 0 sum
 *
 *
 */
public class FindSubarrayWithGivenSum {

  public static void main(String[] args) {
    int arr[] = {1, 4, 0, 0, 3, 10, 5};
    int sum = 7;

    findSubarray(arr, sum);
  }

  private static void findSubarray(int[] arr, int sum) {
    int start = 0;
    int end =0;

    int subarraySum = 0;

    for (int i=0;i<arr.length;i++) {
      subarraySum += arr[i];
      end=i;
      if (subarraySum > sum) { //Subarray sum crossed threshold, removed index from start and move subarray forward
        subarraySum -=arr[start];
        start++;
      }
      if (subarraySum == sum) {
        System.out.println("Found subarray starting from start= "+ start+" end= "+end);
        return;
      }
    }
  }

}
