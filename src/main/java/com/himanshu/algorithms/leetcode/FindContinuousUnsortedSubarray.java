package com.himanshu.algorithms.leetcode;

/**
 * Find the Minimum length Unsorted Subarray, sorting which makes the complete array sorted
 *
 * Solution:
 * 1) Find the candidate unsorted subarray
 * a) Scan from left to right and find the first element which is greater than the next element. Let s be the index of such an element. In the above example 1, s is 3 (index of 30).
 * b) Scan from right to left and find the first element (first in right to left order) which is smaller than the next element (next in right to left order). Let e be the index of such an element. In the above example 1, e is 7 (index of 31).
 * 2) Check whether sorting the candidate unsorted subarray makes the complete array sorted or not. If not, then include more elements in the subarray.
 * a) Find the minimum and maximum values in arr[s..e]. Let minimum and maximum values be min and max. min and max for [30, 25, 40, 32, 31] are 25 and 40 respectively.
 * b) Find the first element (if there is any) in arr[0..s-1] which is greater than min, change s to index of this element. There is no such element in above example 1.
 * c) Find the last element (if there is any) in arr[e+1..n-1] which is smaller than max, change e to index of this element. In the above example 1, e is changed to 8 (index of 35)
 * 3) Print s and e.
 */
public class FindContinuousUnsortedSubarray {
  public static void main(String[] args) {
    int[] arr = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};

    int start = 0;

    for (int i=0;i<arr.length-1;i++) {
      if (arr[i] > arr[i+1]) {  //Forward loop, if current element is greater than it's next
        start = i;
        break;
      }
    }
    int end = 0;
    for (int i=arr.length-1;i>=1;i--) {
      if (arr[i] < arr[i-1]) { //Backward loop, if current element is less than it's previous
        end = i;
        break;
      }
    }
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    for (int i=start;i<=end;i++) {
      if(arr[i] < min) {
        min = arr[i];
      }
      if (arr[i] > max) {
        max = arr[i];
      }
    }

    //Find the first element (if there is any) in arr[0..s-1] which is greater than min, change s to index of this element.
    for (int i=0;i<start;i++) {
      if (arr[i] > min) {
        start = i;
        break;
      }
    }

    //Find the last element (if there is any) in arr[e+1..n-1] which is smaller than max, change e to index of this element.
    for (int i=end+1;i<arr.length;i++) {
      if (arr[i] < max) {
        end = i;
        break;
      }
    }

    System.out.println("start = "+start);
    System.out.println("end = "+end);
  }
}
