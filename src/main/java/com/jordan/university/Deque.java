package com.jordan.university;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    Item[] items;
    private int first = 1;
    private int last = 2;

    // construct an empty deque
    public Deque(){
        items = (Item[]) new Object[4];
    }

    // is the deque empty?
    public boolean isEmpty(){
        return items[first] == null;
    }

    // return the number of items on the deque
    public int size(){
        return last - first;
    }

    // add the item to the front
    public void addFirst(Item item){
        if(item == null){
            throw new IllegalArgumentException();
        }
        if(first == 0) resize();
        if(items[first] == null) items[first] = item;
        else items[--first] = item;
    }

    // add the item to the back
    public void addLast(Item item){
        if(item == null){
            throw new IllegalArgumentException();
        }
        if(last == items.length - 1) resize();
        if(items[last] == null) items[last] = item;
        else items[++last] = item;
    }

    // remove and return the item from the front
    public Item removeFirst(){
        if(first == last || first < 0){
            throw new NoSuchElementException();
        }

        return items[first++];
    }

    // remove and return the item from the back
    public Item removeLast(){
        if(first == last){
            throw new NoSuchElementException();
        }
        return items[last--];
    }

    class ItemIterator<Item> implements Iterator<Item> {

        @Override
        public boolean hasNext() {
            return first < last;
        }

        @Override
        public Item next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            return (Item) items[first++];
        }
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator(){
       return new ItemIterator<>();
    }

    public void resize(){
        Item[] newArr = (Item[]) new Object[items.length * 2];
        int startingIndexNew = ((items.length * 2) - (last - first)) / 2;
        first = startingIndexNew;
        for(Item i : items){
            newArr[startingIndexNew++] = i;
        }
        last = startingIndexNew;
        items = newArr;
    }

    // unit testing (required)
    public static void main(String[] args){
        Deque<String> deque = new Deque<>();
        deque.addFirst("Hello");
        deque.addLast("Baby");
        StdOut.println(deque.size());
        deque.addFirst("Hey");
        deque.addFirst("Woah");
        StdOut.println(deque.size());
        Iterator<String> it = deque.iterator();
        while(it.hasNext()){
            StdOut.println(it.next());
        }

//        StdOut.println(deque.removeFirst());
//        StdOut.println(deque.removeFirst());
//        StdOut.println(deque.removeFirst());
//        StdOut.println(deque.removeFirst());

    }

}