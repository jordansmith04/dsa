package com.jordan.udemy.arrays;

public class WaterContainer {

    /*
    Prompt:
        You are given an array of positive integers where each integer
        represents the height of a vertical line on a chart. Find two lines which together
        with the x-axis forms a container that would hold the greatest amount of water.
        Return the area of the water it would hold.

     Questions:
        - Are we defining greatest amount of water as the area of the water between the lines?
            Answer: yes
        - Is there only one correct solution?
            Answer: yes
        - What do we return if the array contains no lines or only one line?
            Answer: zero
        - What do we do if two adjacent lines are the same height?
            Answer: use furthest line
        - Does the thickness of the lines affect area?
            Answer: no, they take up no space
        - Does a higher line inside our container affect our area?
            Answer: no

      Test cases:
        1. [], expect: null
        2. [1], expect: null
        3. [1, 3, 7, 4, 9], expect: 14
        4. [1, 1], expect: 1
        5. [1, 1, 1, 1, 1], expect: 1

      Brute force solution:
         Calculate the area for all possible combinations, take highest
     */

    public static int findArea(int[] nums){
        int largest_area = 0;
        for(int p1 = 0; p1 < nums.length; p1++){
            for(int p2 = p1 + 1; p2 < nums.length; p2++){
                int area = Math.min(nums[p1], nums[p2]) * (p2 - p1);
                if(area > largest_area) {
                    largest_area = area;
                }
            }
        }
        return largest_area;
    }

    /*
        Analyze:
            Time: O(n^2)
            Space: O(1)

        Two pointers from ends inward



     */

    public static int findMaxAreaOptimized(int[] nums){
        int p1 = 0;
        int p2 = nums.length - 1;
        int max_area = 0;
        while(p1 < p2){
            int current_area = Math.min(nums[p1], nums[p2]) * (p2 - p1);
            max_area = Math.max(current_area, max_area);
            if(nums[p2] <= nums[p1]){
                p2--;
            } else {
                p1++;
            }
        }
        return max_area;
    }



    public static void main(String[] args){
//        System.out.println(findArea(new int[]{1, 3, 7, 4, 9}));
//        System.out.println(findArea(new int[]{}));
//        System.out.println(findArea(new int[]{1}));
//        System.out.println(findArea(new int[]{1, 1}));
//        System.out.println(findArea(new int[]{1, 1, 1, 1, 1}));

        System.out.println(findMaxAreaOptimized(new int[]{7, 3, 1, 4, 9})); //28
        System.out.println(findMaxAreaOptimized(new int[]{}));
        System.out.println(findMaxAreaOptimized(new int[]{1}));
        System.out.println(findMaxAreaOptimized(new int[]{1, 1}));
        System.out.println(findMaxAreaOptimized(new int[]{1, 1, 1, 1, 1}));
    }
}
