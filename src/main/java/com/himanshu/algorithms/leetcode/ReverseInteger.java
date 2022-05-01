package com.himanshu.algorithms.leetcode;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0.
 *
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 *
 *
 *
 * Example 1:
 *
 * Input: x = 123
 * Output: 321
 * Example 2:
 *
 * Input: x = -123
 * Output: -321
 * Example 3:
 *
 * Input: x = 120
 * Output: 21
 */
public class ReverseInteger {
  public static int reverse(int x) {
    if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) {
      return 0;
    }
    long rev =0;
    while(x != 0) {
      rev *= 10;
      rev += x%10;
      x = x/10;
    }
    if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
      return 0;
    }
    return new Long(rev).intValue();
  }

  public static void main(String[] args) {
    System.out.println(reverse(1534236469));
    System.out.println(Integer.MAX_VALUE);
  }
}
