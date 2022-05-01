package com.himanshu.algorithms.leetcode;

public class ReverseLinkedList {

  private static ListNode reverse(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while(curr != null) {
      ListNode next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }

  public static void main(String[] args) {
    ListNode node1 = new ListNode(10);
    ListNode node2 = new ListNode(20, node1);
    ListNode node3 = new ListNode(30, node2);
    ListNode node4 = new ListNode(40, node3);
    node4.print();
    System.out.println();
    reverse(node4).print();
  }

}
