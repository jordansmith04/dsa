package com.jordan.older;

public class FixedCapacityArrayStackOfStrings {

    /*
    Major problems with implementation include:

     1. making array size be passed in at instantiation.
     2. No null checks
     3. No checks for decrementing past zero or incrementing past array length

     */

    String[] strings;
    int counter = 0;

    public FixedCapacityArrayStackOfStrings(int n){
        strings = new String[n];
    }

    public boolean isEmpty(){
        return counter == 0;
    }

    public void push(String s){
        strings[counter++] = s;
    }

    public String pop(){
        String item = strings[--counter];
        strings[counter] = null; // to avoid loitering, set entry to null to allow pointer to be garbage collected
        return item;
    }
}
