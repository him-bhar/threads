package com.himanshu.algorithms.leetcode;

public class ListNode {
  int val;
  ListNode next;

  public ListNode() {
  }

  public ListNode(int val) {
    this.val = val;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  public void print() {
    System.out.print(this.val);
    System.out.print("->");
    ListNode curr = this.next;
    while (curr != null) {
      System.out.print(curr.val);
      System.out.print("->");
      curr = curr.next;
    }
    System.out.print("NULL");
  }
}
