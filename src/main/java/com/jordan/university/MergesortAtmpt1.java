package com.jordan.university;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MergesortAtmpt1 {

    /**
     * Mergesort
     *
     * Take two halves of the array, each sorted, and combine them into a single array
     *
     */

    public static Comparable[] merge(Comparable[] a){
        Comparable[] aux = new Comparable[a.length];
        int low = 0;
        int mid = (a.length - 1) / 2;
        int hi = a.length;
        assertTrue(isSorted(a, low, mid),"Array from low to mid was not sorted");
        assertTrue(isSorted(a, mid + 1, hi), "Array from mid to high was not sorted");

        for(int k = low; k < hi; k++)
            aux[k] = a[k];

        int i = low, j = mid + 1;
        for(int k = low; k < hi; k++){
            if(i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
            System.out.println("added " + a[k].toString());
        }

        assertTrue(isSorted(a, low, hi), "Final array was not sorted");
        return a;
    }

    public static boolean less(Comparable i, Comparable j){
        return i.compareTo(j) < 0;
    }

    public static boolean isSorted(Comparable[] a, int low, int hi){
        for(int i = low; i < hi - 1; i ++){
            if(a[i].compareTo(a[i + 1]) > 0) return false;
        }
        return true;
    }

    public static void main(String[] args){
        Integer[] ints = {1, 2, 6, 7, 9, 3, 4, 5, 8, 10,};
        Arrays.stream(merge(ints)).forEach(i -> System.out.print(i + ", "));
    }
}
