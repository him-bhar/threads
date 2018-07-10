package com.himanshu.brainteasers;

public class SuffixCalculator {
  static int[] stringSimilarity(String[] inputs) {
    int[] result = new int[inputs.length];
    for (int i=0;i<inputs.length;i++) {
      result[i] = stringSimilarity(inputs[i]);
    }
    return result;
  }

  static int stringSimilarity(String s) {
    int total = 0;
    for (int i=0;i<s.length();i++) {
      String subString = s.substring(i);
      int count = 0;
      for (int j=0;j<subString.length();j++) {
        if (subString.charAt(j) == s.charAt(j)) {
          count++;
        } else {
          break;
        }
      }
      total += count;
    }
    return total;
  }

  public static void main(String[] args) {
    int[] result = stringSimilarity(new String [] {"ababaa", "aa"});
    for (int i=0;i<result.length;i++) {
      System.out.println(result[i]);
    }
  }
}
