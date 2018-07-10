package com.himanshu.brainteasers;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SuperStack {
  static void superStack(String[] operations) {
    List<Integer> stack = new ArrayList<>();
    for (String operation : operations) {
      if (operation.contains("push")) {
        String[] ops = operation.split(" ");
        stack.add(Integer.parseInt(ops[1]));
      } else if(operation.contains("pop")) {
        stack.remove(stack.size()-1);
      } else if (operation.contains("inc")) {
        String[] ops = operation.split(" ");
        int noOfElements = Integer.parseInt(ops[1]);
        int valueToAdd = Integer.parseInt(ops[2]);
        for (int i=0;i<noOfElements;i++) {
          stack.set(i, stack.get(i)+valueToAdd);
        }
      }
      System.out.println(stack.size() > 0 ? stack.get(stack.size()-1) : "EMPTY");
    }

  }

  public static void main(String[] args) {
    String[] ops = new String [] {
            "push 15",
            "pop",
            "push -51",
            "pop",
            "push 41",
            "pop",
            "push -76",
            "push 51",
            "push -10",
            "inc 1 -49"
    };
    superStack(ops);
  }



}
