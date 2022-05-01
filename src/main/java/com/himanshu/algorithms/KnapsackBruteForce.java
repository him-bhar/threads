package com.himanshu.algorithms;

/**
 * https://www.interviewbit.com/blog/0-1-knapsack-problem/
 * https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
 * <p>
 * Method 1: Recursion by Brute-Force algorithm OR Exhaustive Search.
 * Approach: A simple solution is to consider all subsets of items and calculate the total weight and value of all subsets. Consider the only subsets whose total weight is smaller than W. From all such subsets, pick the maximum value subset.
 * Optimal Sub-structure: To consider all subsets of items, there can be two cases for every item.
 * <p>
 * Case 1: The item is included in the optimal subset.
 * Case 2: The item is not included in the optimal set.
 * Therefore, the maximum value that can be obtained from ‘n’ items is the max of the following two values.
 * <p>
 * 1. Maximum value obtained by n-1 items and W weight (excluding nth item).
 * 2. Value of nth item plus maximum value obtained by n-1 items and W minus the weight of the nth item (including nth item).
 * If the weight of ‘nth’ item is greater than ‘W’, then the nth item cannot be included and Case 1 is the only possibility.
 */
public class KnapsackBruteForce {
  private static int knapSack(int knapsackWt, int wt[], int val[], int n) {
    if (n == 0 || knapsackWt == 0) {
      return 0;
    }
    if (wt[n - 1] <= knapsackWt) {  //There is capacity in knapsack to accomodate element[n]
      return Math.max(
            val[n - 1] + knapSack(knapsackWt - wt[n - 1], wt, val, n - 1), //With element included, so effective knapsack weight reduces
            knapSack(knapsackWt, wt, val, n - 1) //Without the element
      );
    } else { //Weight of element is greater than knapsack to cannot be included.
      return knapSack(knapsackWt, wt, val, n - 1);
    }
  }

  // Driver code
  public static void main(String args[]) {
    int val[] = new int[]{60, 100, 120};
    int wt[] = new int[]{10, 20, 30};
    int W = 50;
    int n = val.length;
    System.out.println(knapSack(W, wt, val, n));
  }
}
