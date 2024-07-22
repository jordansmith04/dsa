package com.jordan.older;

import java.util.Arrays;

public class SelectionSort {

    /**
     *
     * Time complexity: n^2 / 2
     * Space complexity: n
     *
     * Idea with Selection sort:
     *
     *Loop from start to end, selecting index of lowest item. Swap i and item.
     *
     */

    public static Comparable[] sort(Comparable[] arr){
        for(int i = 0; i < arr.length; i++){
            int lowIndex = i;
            for(int j = i + 1; j < arr.length; j++)
                if(less(arr[j], arr[lowIndex])) {
                    lowIndex = j;
                }
            swap(arr, i, lowIndex);

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
