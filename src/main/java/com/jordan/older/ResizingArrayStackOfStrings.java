package com.jordan.older;


//Time complexity: N at worst, 1 most of the time
//Space complexity: N
public class ResizingArrayStackOfStrings {

    String[] strings;
    int counter = 0;

    public ResizingArrayStackOfStrings(){
        strings = new String[1];
    }

    public boolean isEmpty(){
        return counter == 0;
    }

    public void push(String s){
        if( counter == strings.length) resize(2 * strings.length);
        strings[counter++] = s;
    }

    public void resize(int capacity){
        String[] copy = new String[capacity];
        for(int i = 0; i < strings.length; i++)
            copy[i] = strings[i];
        strings = copy;
    }

    public String pop(){
        String item = strings[--counter];
        strings[counter] = null; // to avoid loitering, set entry to null to allow pointer to be garbage collected
        if(counter > 0 && counter  == strings.length / 4) resize(strings.length / 2);
        /*
        reduce array size by half whenever the array is a quarter full. We choose a quarter because of "thrashing".
        Assume we pushed and popped when the array was half full, the resizing operations would get very expensive.
         */
        return item;
    }
}
