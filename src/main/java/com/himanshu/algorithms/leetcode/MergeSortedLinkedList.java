package com.himanshu.algorithms.leetcode;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * <p>
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Return the head of the merged linked list.
 */
public class MergeSortedLinkedList {


  public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode head = null;


    if (list1 == null) {
      return list2;
    } else if (list2 == null) {
      return list1;
    }

    if (list1.val <= list2.val) {
      head = list1;
      list1 = list1.next;
    } else {
      head = list2;
      list2 = list2.next;
    }
    ListNode tail = head;

    while(list1 != null && list2 != null) {
      ListNode temp = null;
      if (list1.val <= list2.val) {
        temp = list1;
        list1 = list1.next;
      } else {
        temp = list2;
        list2 = list2.next;
      }
      tail.next = temp;
      tail = temp;
    }
    if (list1 != null) {
      tail.next = list1;
    }
    if (list2 != null) {
      tail.next = list2;
    }
    return head;
  }

  public static ListNode mergeTwoListsRecursive(ListNode list1, ListNode list2) {
    if (list1 == null) {
      return list2;
    } else if (list2 == null) {
      return list1;
    }

    if (list1.val < list2.val) {
      list1.next = mergeTwoListsRecursive(list1.next, list2);
      return list1;
    } else {
      list2.next = mergeTwoListsRecursive(list1, list2.next);
      return list2;
    }
  }

  public static void main(String[] args) {
    ListNode node1 = new ListNode(50);
    ListNode node2 = new ListNode(30, node1);
    ListNode node3 = new ListNode(10, node2);

    ListNode node4 = new ListNode(60);
    ListNode node5 = new ListNode(40, node4);
    ListNode node6 = new ListNode(20, node5);

    //mergeTwoLists(node6, node3).print();
    System.out.println();
    mergeTwoListsRecursive(node6, node3).print();
  }


}
