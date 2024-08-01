package com.jordan.university;

public class BasicSorting {
    public static Comparable[] sort(Comparable[] arr){
        for(int i = 1; i < arr.length; i++){
            if(less(arr[i], arr[i-1]))
                arr = swap(arr, i, i - 1);
        }
        return arr;
    }

    public static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) == -1 ? true : false;
    }

    public static Comparable[] swap(Comparable[] arr, int index1, int index2){
        Comparable temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
        return arr;
    }
}
