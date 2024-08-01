package com.jordan.university;

import java.util.Arrays;

import static com.jordan.university.MergesortAtmpt1.less;

public class MergeSort {

    static Comparable[] aux;

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
        for(int k = lo; k < hi; k++)
            aux[k] = a[k];

        int i = lo, j = mid + 1;
        for(int k = lo; k < hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid, hi);
        merge(a, aux, lo, mid, hi);
    }

    private static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    public static void main(String[] args){
        Comparable[] a = {15, 3, 7, 21, 1, -5, 108};
        sort(a);
        Arrays.stream(a).forEach(i -> System.out.println(i + " "));
    }
}
