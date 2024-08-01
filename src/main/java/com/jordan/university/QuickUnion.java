package com.jordan.university;

public class QuickUnion {

    static int[] unions;

    QuickUnion(int i) {
        unions = new int[i];
        for(int j = 0; j < i; j++){
            unions[j] = j;
        }
    }

    static void union(int p, int q) { // add connection between p and q //6, 5 or 6 under 5
        int pHead = findHead(p);
        int qHead = findHead(q);
        if (pHead == qHead) return;
//        if (sz[i] < sz[j]) { id[i] = j; sz[j] += sz[i]; }
//        else { id[j] = i; sz[i] += sz[j]; }
        unions[pHead] = qHead;
        System.out.println(p + " and " + q + " are now connected on " + p);
    }

    static boolean connected(int p, int q) { // are p and q in the same component?
        boolean areConnected = findHead(p) == findHead(q);
        System.out.println("Are " + q + " and " + p + " connected? " + areConnected);
        return areConnected;
    }

    static int find(int p) { // component identifier for p (0 to N – 1)
        int pId = unions[p];
        System.out.println("Id for " + p + " is " + pId);
        return pId;
    }

    static int findHead(int p){
        while(unions[p] != p){
            p = unions[p];
            unions[p] = unions[unions[p]];
        }
        return p;
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
        QuickUnion eag = new QuickUnion(10);
        eag.printArray();
        eag.connected(0, 1);
        eag.union(1, 4);
        eag.union(3, 7);
        eag.union(2, 9);
        eag.union(4, 8);
        eag.union(8, 2);
        eag.connected(1, 9);
        eag.printArray();
    }
}
