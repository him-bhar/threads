package com.himanshu.algorithms.leetcode;

public class StringPermutations {

  private static void permuteRecursive(String s, int left, int right) {
    if (left == right) {
      System.out.println(s);
    } else {
      for (int i=left;i<=right;i++) {
        s = swap(s, left, i);
        permuteRecursive(s, left+1, right);
        s = swap(s, left, i);
      }
    }
  }

  private static String swap(String str, int pos1, int pos2) {
    char[] arr = str.toCharArray();
    char temp = arr[pos1];
    arr[pos1] = arr[pos2];
    arr[pos2] = temp;
    return new String(arr);
  }

  private static void permuteOther(String str, String answer) {
    if (str.length() == 0) {
      System.out.println(answer);
      return;
    }
    for (int i=0;i<str.length();i++) {
      char ch = str.charAt(i);
      String leftPart = str.substring(0, i);
      String rightPart = str.substring(i+1);
      permuteOther(leftPart+rightPart, answer+ch);
    }
  }

  public static void main(String[] args) {
    String input = "ABCD";
    permuteRecursive(input, 0, input.length()-1);
    System.out.println("=========");
    permuteOther(input, "");
  }
}
