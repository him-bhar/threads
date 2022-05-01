package com.himanshu.algorithms.leetcode;

public class MergeKSortedLinkedList {

  public static ListNode sort2Nodes(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }

    if (l1.val < l2.val) {
      l1.next = sort2Nodes(l1.next, l2);
      return l1;
    } else {
      l2.next = sort2Nodes(l1, l2.next);
      return l2;
    }
  }

  public static ListNode sortKNodeLists(ListNode[] arr, int k) {
    for(int i=0;i<k-1;i++) {
      arr[i+1] = sort2Nodes(arr[i], arr[i+1]); //Returned list stored in next counter, so updated result is always picked in next iteration
    }
    return arr[k-1];
  }


  public static void main(String[] args) {
    ListNode node1 = new ListNode(50);
    ListNode node2 = new ListNode(30, node1);
    ListNode node3 = new ListNode(10, node2);

    ListNode node4 = new ListNode(60);
    ListNode node5 = new ListNode(40, node4);
    ListNode node6 = new ListNode(20, node5);

    ListNode node7 = new ListNode(35);
    ListNode node8 = new ListNode(25, node7);
    ListNode node9 = new ListNode(15, node8);

    ListNode node10 = new ListNode(75);
    ListNode node11 = new ListNode(22, node10);
    ListNode node12 = new ListNode(5, node11);

    //mergeTwoLists(node6, node3).print();
    System.out.println();

    ListNode[] arr = new ListNode[4];
    arr[0] = node3;
    arr[1] = node6;
    arr[2] = node9;
    arr[3] = node12;

    sortKNodeLists(arr, arr.length).print();
  }

}
