package com.jordan.older;

import java.util.Arrays;

public class Shuffling {

    /**
     * Linear time shuffling
     *
     * Left to right, pick a random value from "seen" cards on left of index and swap.
     *
     */

    public static Comparable[] shuffle(Comparable[] arr){
        for(int i = 0; i < arr.length; i++){
            int randomIndex = (int) (Math.random() * i);
            System.out.println(randomIndex);
            swap(arr, randomIndex, i);
        }
        return arr;
    }

    public static Comparable[] swap(Comparable[] arr, int i, int j){
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }

    public static void main(String[] args){
        Integer[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Arrays.stream(Shuffling.shuffle(ints)).forEach(i -> System.out.print(i + ", "));
    }
}
