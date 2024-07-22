package com.jordan.older;

public class Percolation {

    // creates n-by-n grid, with all sites initially blocked
    int[][] grid;
    int total_sites;
    int siteCount;
    int row_length;
    public Percolation(int n) {
        row_length = (int) Math.sqrt(n);
        grid = new int[row_length][row_length];
        siteCount = 0;
        total_sites = n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = 0;
            }
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if(grid[row][col] != 1){
            grid[row][col] = 1;
            siteCount += 1;
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col){
        if(grid[row][col] != 1) return false;
        return true;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        return false;
    }

    // returns the number of open sites
    public int numberOfOpenSites(){
        return total_sites - siteCount;
    }

    // does the system percolate?
    public boolean percolates() {
        return false;
    }

    // test client (optional)
    public static void main(String[] args){

    }
}