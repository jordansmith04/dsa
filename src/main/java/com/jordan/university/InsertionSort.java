package com.jordan.university;

import java.util.Arrays;

public class InsertionSort {

    /**
     * Time complexity on average: n^2 / 4
     * Time complexity at worst (Array is backwards): n^2 / 2
     * Space complexity: n
     *
     * Idea with insertion sort is:
     *
     * We have two counters, i and j, which are equal when we start each index. We assume everything to left of i is sorted and everything to the right isn't.
     * If the item to the left of i is smaller, swap j and it, decrementing j until the item is in its place.
     * Then increment i, set j = i, continue to the end.
     */

    public static Comparable[] sort(Comparable[] arr){
        for(int i = 0; i < arr.length; i++){
            int j = i, k = i;
            while(k >= 0){
                if(less(arr[j], arr[k--]))
                    swap(arr, j, k);
                else break;
            }
        }
        return arr;
    }

    public static boolean less(Comparable i, Comparable j){
        return i.compareTo(j) < 0 ? true : false;
    }

    public static Comparable[] swap(Comparable[] arr, int index1, int index2){
        Comparable temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
        return arr;
    }

    public static void main(String[] args){
        Integer[] ints = {99, 1, 18, 76, 45, 88, 12};
        Arrays.stream(SelectionSort.sort(ints)).forEach(i -> System.out.print(i + ", "));
    }


}
