package com.jordan.university;

public class LinkedListsQueueOfStrings {

    Node first = null;
    Node last = null;

    private class Node{
        String value;
        Node next;
    }

    public String dequeue() {
            Node oldFirst = first;
            first = first.next;
            if(isEmpty()) last = null;
            return oldFirst.value;
    }

    public void enqueue(String val){
        Node newLast = last;
        last = new Node();
        last.value = val;
        last.next = null;
        if(isEmpty())
            first = last;
        else
            newLast.next = last;
    }

    public String peek() {
        if(!isEmpty()) {
            StdOut.println(first.value);
            return first.value;
        } else {
            StdOut.println("Queue is empty");
            return "";
        }
    }

    public boolean isEmpty(){;
        return first == null;
    }

    public static void main(String[] args) {
        LinkedListsQueueOfStrings ll = new LinkedListsQueueOfStrings();
        ll.isEmpty();
        ll.enqueue("Help");
        ll.peek();
        ll.enqueue("me");
        ll.peek();
        ll.dequeue();
        ll.peek();
        ll.dequeue();
    }
}
