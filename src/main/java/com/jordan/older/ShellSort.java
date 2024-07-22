package com.jordan.older;

import java.util.Arrays;

public class ShellSort {

    /**
     *
     * Time complexity: O(n^(3/2))
     * Space complexity: n
     *
     * Idea with Selection sort:
     *
     *Loop from start to end, selecting index of lowest item. Swap i and item.
     *
     */

    public static Comparable[] sort(Comparable[] arr){

        int h = 1;
        while( h < arr.length / 3) h = 3*h + 1;  // increment h by 3x + 1 until h > arr.length / 3

        while(h > 0) {
            for(int i = h; i < arr.length; i++){    // count up from h to arr
                int j = i;
                while(j >= h){ //j = 4 //j = 5
                    if(less(arr[j], arr[j-h])) // less(arr[4], arr[4-4])  //less(5, 5-4)
                        swap(arr, j, j - h); //swap(4, 0) //swap(5, 1)
                    j -= h; //break because while( j >= 4 ...) , j = 0
                }
            }

            h /= 3;
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
