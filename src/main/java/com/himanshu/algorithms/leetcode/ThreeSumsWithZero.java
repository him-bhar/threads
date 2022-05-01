package com.himanshu.algorithms.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Example 2:
 * <p>
 * Input: nums = []
 * Output: []
 * Example 3:
 * <p>
 * Input: nums = [0]
 * Output: []
 */
public class ThreeSumsWithZero {

  private static boolean binarySearch(int l, int r, int[] nums, int x) {
    while (l <= r) {
      int mid = (l + r) / 2;
      if (nums[mid] == x) return true;
      else if (nums[mid] > x) r = mid - 1;
      else l = mid + 1;
    }
    return false;
  }

  public static List<List<Integer>> threeSum(int[] nums) {
    Set<List<Integer>> result = new HashSet<>();
    if (nums.length < 3) {
      return new ArrayList<>(); //Input is not sufficient, break
    }
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        /*for (int k=j+1;k<nums.length;k++) {
          if (nums[i] + nums[j] + nums[k] == 0) {
            List<Integer> combination = new ArrayList<>();
            combination.add(nums[i]);
            combination.add(nums[j]);
            combination.add(nums[k]);
            *//*if (!result.contains(combination.stream().sorted().collect(Collectors.toList()))) {
              result.add(combination.stream().sorted().collect(Collectors.toList()));
            }*//*
            result.add(combination.stream().sorted().collect(Collectors.toList()));
          }
        }*/
        if (binarySearch(j + 1, nums.length - 1, nums, -(nums[i] + nums[j]))) {
          List<Integer> combination = new ArrayList<>();
          combination.add(nums[i]);
          combination.add(nums[j]);
          combination.add(-(nums[i] + nums[j]));
          result.add(combination.stream().sorted().collect(Collectors.toList()));
        }
        while (j + 1 < nums.length && nums[j] == nums[j + 1]) j++; //Repetitive iteration avoided
      }
      while (i + 1 < nums.length && nums[i] == nums[i + 1]) i++; //Repetitive iteration avoided
    }
    return result.stream().collect(Collectors.toList());
  }

  public static void main(String[] args) {
    int[] nums = {-1, 0, 1, 2, -1, -4};
    System.out.println(threeSum(nums));
  }
}
