package com.jordan.older;

import java.util.HashSet;
import java.util.Set;

public class QuickFind {

    static int[] unions;

    QuickFind(int i) {
        unions = new int[i];
        for(int j = 0; j < i; j++){
            unions[j] = j;
        }
    }

    static void union(int p, int q) { // add connection between p and q
        int pid = unions[p];
        int qid = unions[q];
        for (int i = 0; i < unions.length; i++)
            if (unions[i] == pid) unions[i] = qid;
        System.out.println(p + " and " + q + " are now connected with value " + qid);
    }

    static boolean connected(int p, int q) { // are p and q in the same component?
        boolean areConnected = unions[p] == unions[q];
        System.out.println("Are " + q + " and " + p + " connected? " + areConnected);
        return areConnected;
    }

    static int find(int p) { // component identifier for p (0 to N – 1)
        int pId = unions[p];
        System.out.println("Id for " + p + " is " + pId);
        return pId;
    }

    static int count() { // number of components
        Set<Integer> nums = new HashSet<>();
        for(int i = 0; i < unions.length; i++){
            nums.add(unions[i]);
        }
        System.out.println("Number of components is " + nums.size());
        return nums.size();
    }

    static void printArray(){
        for(int i = 0; i < unions.length; i++){
            System.out.print("index " + i + ": " + unions[i]);
            if(i < unions.length - 1){
                System.out.print(",");
            }
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        QuickFind eag = new QuickFind(10);
        eag.printArray();
        eag.count();
        eag.connected(0, 1);
        eag.union(1, 4);
        eag.union(3, 7);
        eag.union(2, 9);
        eag.union(4, 8);
        eag.union(8, 2);
        eag.count();
        eag.connected(1, 9);
        eag.printArray();
    }
}
