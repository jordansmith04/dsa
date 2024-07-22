package com.jordan.udemy.arrays;

public class TrappingRainwater {

    /*
    Prompt:
        Given an array of integers representing an
        elevation map where the width of each bar is 1,
        return how much rainwater can be trapped.

    Questions:
     - are all the lines conjoined meaning there is no space between them?
        Answer: yes
     - Can we use the walls of the container to calculate?
        Answer: no
     - Total water being trapped or area of most water being trapped?
        Answer: total
     - What do we return if the area is zero?
        Anser: zero
     - Will there be negative integers?
        Answer: no

     Test cases:
        1. [0, 1, 0, 2, 1, 0, 3, 1, 0, 1, 2], expect: 8
        2. [0, 1], expect: 0
        3. [3], expect: 0
        4. [3, 4, 3], expect: 0
        5. [], expect: 0

      Brute force solution
            index through array
            for each index, the current amount of water on that spot =
                minimum of the max value to the left and the max value to the right - current height

           currentWater = min(maxL, maxR) - current
           Do this for each index


     */

    public static int findTrappedWaterBruteForce(int[] heights){
        int total = 0;
        for(int index = 0; index < heights.length; index++){
            int maxL = 0;
            int maxR = 0;
            int current = heights[index];
            for(int left = index - 1; left >= 0; left--){
                maxL = Math.max(heights[left], maxL);
            }
            for(int right = index + 1; right < heights.length; right++){
                maxR = Math.max(heights[right], maxR);
            }
            int water = Math.min(maxL, maxR) - current;
            if(water > 0){
                total += water;
            }
        }
        return total;
    }

    /*
        Analyze runtime:
            Space: O(1)
            time: O(N^2)

        Can we trade space to reduce time?


        Using two pointer method:
        currentWater = min(
     */


    /**
     * Run time:
     * @param nums
     * @return
     */
    public static int trappedWaterOptimized(int[] nums){
        int max_left = 0;
        int max_right = 0;
        int p1 = 0;
        int p2 = nums.length - 1;
        int total = 0;
        while(p1 < p2){
            max_left = Math.max(nums[p1], max_left);
            max_right = Math.max(nums[p2], max_right);
            if(nums[p1] < max_left && nums[p1] < max_right){
                total += Math.min(max_left, max_right) - nums[p1];
                p1++;
            } else if (nums[p2] < max_left && nums[p2] < max_right){
                total += Math.min(max_left, max_right) - nums[p2];
                p2--;
            } else if(nums[p1] <= nums[p2]){
                p1++;
            } else {
                p2--;
            }
        }
        return total;
    }

    /*
        Analyze runtime:


     */


    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 2, 1, 0, 3, 1, 0, 1, 2};
        int[] nums2 = new int[]{0, 1};
        int[] nums3 = new int[]{3, 4, 3};
        System.out.println(findTrappedWaterBruteForce(nums));
        System.out.println(trappedWaterOptimized(nums));
        System.out.println(trappedWaterOptimized(nums2));
        System.out.println(trappedWaterOptimized(nums3));

    }
}
