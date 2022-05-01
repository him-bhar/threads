package com.himanshu.algorithms;

/**
 * https://www.tutorialcup.com/interview/graph/max-area-of-island.htm
 * Algorithm for Max Area of Island
 * Traverse the 2D grid a perform DFS traversal from each of the cells containing 1.
 * Mark the current cell as visited by changing cell value to 0.
 * The area of the island starting from the current cell is 1.
 * Recursively visit all the neighbors (up-right-down-left) of current cells that contain 1, mark these neighbors as visited, and also increase the area by 1 for every valid neighbor (cells with value 1) visited(by changing cell value to 0).
 * After traversal is complete return the area obtained.
 * Perform steps 2,3,4 and 5 for each of the cells (of the matrix) containing 1 and return a maximum of all the area values obtained.
 */
public class LargestIslandProblem {

  private static int largestIsland(int[][] arr) {
    int maxArea =0;
    for(int r=0;r<arr.length;r++) {
      for(int c=0;c<arr[0].length;c++) {
        if (arr[r][c] == 1) {
          maxArea = Math.max(maxArea, dfs(arr, r, c));
        }
      }
    }
    return maxArea;
  }

  private static int dfs(int[][] arr, int row, int col) {
    int m = arr.length;
    int n = arr[0].length;
    int directions[][] = {
          {-1, 0}, //Up
          {0, 1},  //Right
          {0, -1}, //Left
          {1, 0}   //Down

    };
    int area = 1;
    arr[row][col]=0;
    for (int i=0;i<directions.length;i++) {
      int r = row+directions[i][0];
      int c = col+directions[i][1];
      if (r>=0 && r<m && c>=0 && c<n && arr[r][c]==1) {
        area+=dfs(arr, r, c);
      }
    }
    return area;
  }

  public static void main(String[] args) {
    int grid[][] = {
          {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
          {0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0},
          {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
          {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
    };

    System.out.print("Area of largest island = " + largestIsland(grid));
  }

}
