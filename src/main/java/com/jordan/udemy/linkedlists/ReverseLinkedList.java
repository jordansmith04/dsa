package com.jordan.udemy.linkedlists;

import java.util.HashSet;

public class ReverseLinkedList {
    static class ListNode {
        int value;
        ListNode next;
    }

    /*
        Prompt:
            Given a linked list, return it in reverse

        Questions:
            Are cycles (circularly linked) possible? Yes
            How do you want us to handle an empty linked list? return null

        Testcases:
            1. [1, 2, 3, 4, 5], expect: [5, 4, 3, 2, 1]
            2. [1, 2, 3, 4, 5, 3],  3, 5, 4, 3, 2, 1
            3 [], null
            4. [1, 2, 3, 6], [3, 2, 1]


     */

    public static ListNode reverseLinkedListBrute(ListNode head){
        HashSet<ListNode> visitedNodes = new HashSet<>();
        ListNode temp = head;
        while(temp.next != null && visitedNodes.add(temp)){
            head = temp.next;
            head.next = temp.next.next;
            temp = temp.next;

        }

        return head;
    }

    public static void printLinkedList(ListNode head){
        while(head.next != null){
            System.out.println(head.value);
            head = head.next;
        }
    }

    public static void main(String[] args){
        ListNode head = new ListNode();
        ListNode next1 = new ListNode();
        ListNode next2 = new ListNode();
        ListNode next3 = new ListNode();
        ListNode next4 = new ListNode();
        ListNode next5 = new ListNode();
        head.next = next1;
        next1.next = next2;
        next2.next = next3;
        next3.next = next4;
        next4.next = next5;
        head.value = 0;
        next1.value = 1;
        next2.value = 2;
        next3.value = 3;
        next4.value = 4;
        next5.value = 5;
        printLinkedList(reverseLinkedListBrute(head));
    }

}
