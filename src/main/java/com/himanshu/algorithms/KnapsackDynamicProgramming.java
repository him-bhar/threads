package com.himanshu.algorithms;

/**
 * https://www.interviewbit.com/blog/0-1-knapsack-problem/
 * https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
 * <p>
 * In this approach we’ll define 2 dimensional DP of index for items defined on rows whereas weights from 1 to W on columns and for every weight we can compute the answer for placing items till nth item.
 * <p>
 * Similar to the recursive approach we can define two cases that is,
 * <p>
 * Use this item or
 * Ignore it.
 * Thus for every, Dp[i][j] we can calculate values for these two cases and store out the maximum of those two ,
 * <p>
 * Therefore we can get our answer for {i,j} as ,
 * <p>
 * DP[i][j] = max(v[i] + DP[i-1][j-w[i]],DP[i-1][j])
 */
public class KnapsackDynamicProgramming {
  private static int knapSack(int knapsackWt, int wt[], int val[], int n) {
    int DP[][] = new int[n+1][knapsackWt+1];
    //when total knapsackWt is 0, no elements can fit in.
    for (int i = 0; i < n + 1; i++) {
      DP[i][0] = 0;
    }
    //If there are no elements nothing can be occupied, so no vals again
    for (int j = 0; j < knapsackWt + 1; j++) {
      DP[0][j] = 0;
    }

    //Now for each element we need to check with or without element which gives max val.
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < knapsackWt + 1; j++) {
        if (j >= wt[i-1]) { //Current weight is greater than, weight of element at pos i, then only it can fit and we check with or without
          int withElement = val[i-1] + DP[i-1][j-wt[i-1]];
          int withoutElement = DP[i-1][j];
          DP[i][j] = Math.max(withElement, withoutElement);
        } else { //Current element cannot fit, so no change
          DP[i][j] = DP[i-1][j];
        }
      }
    }
    return DP[n][knapsackWt];
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
