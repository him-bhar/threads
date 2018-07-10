package com.himanshu.brainteasers;

import java.util.Scanner;
import java.util.Stack;

public class VerifyBSTPreOrderTraversal {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int numberOfQueries = scanner.nextInt();
    scanner.nextLine();
    for (int i=0;i<numberOfQueries;i++) {
      int numberOfNodes = scanner.nextInt();
      scanner.nextLine();
      String nodes = scanner.nextLine();

      if (verifyBST(nodes, numberOfNodes)) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
    }
  }

  private static boolean verifyBST(String nodes, int numberOfNodes) {
    String[] nodesArr = nodes.split(" ");
    int[] nodesInt = new int[nodesArr.length];
    for (int i = 0;i<nodesArr.length;i++) {
      nodesInt[i] = Integer.parseInt(nodesArr[i]);
    }
    return verifyBST(nodesInt, numberOfNodes);
  }

  private static boolean verifyBST(int []nodes, int numberOfNodes) {
    Stack<Integer> s = new Stack<>();
    int root = Integer.MIN_VALUE;

    for (int i = 0; i < numberOfNodes; i++) {
      if (nodes[i] < root) {
        return false;
      }

      while (!s.empty() && s.peek() < nodes[i]) {
        root = s.peek();
        s.pop();
      }

      s.push(nodes[i]);
    }
    return true;
  }
}
