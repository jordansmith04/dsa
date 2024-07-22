package com.jordan.udemy.arrays;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    /*
    Prompt:
        Given an array of integers, return
        the indices of the two numbers that add
        up to a given target.

    Steps
    Step 1: Verify the constraints
        Ask interviewer questions to understand constraints
        Example:
            - Can any of the integers be negative?
            - Are there duplicate numbers in the array?
            - Will there always be a solution available? Often No!
            - What do we return if there's no solution?
            - Can there be multiple pairs that add up to the target?

     Step 2: Write out some test cases
        Test case 1: [ 1, 3, 7, 9, 2], target: 11, expect: [3,4]
        2: [], target: 4, expect: null
        3: [ 1, 3, 7, 9, 2], target: 25, expect: null
        4: [3], target: 3, expect: null
        5: [1, 6], target: 7, expect: [0, 1]

    Step 3: Figure out a solution without code
        All possible combinations? Two pointer technique!
        Example: [ 1, 3, 7, 9, 2], target: 10
        P1 + P2 = 10

    Step 4: Write out our solution in code
     */

    public static int[] findTwoSum(int[] numsArray, int target) {
        for(int i = 0; i < numsArray.length; i++) {
            for(int j = i + 1; j < numsArray.length; j++){
                if(numsArray[i] + numsArray[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /*
    Step 5: Double check for errors
        - No spelling mistakes
        - No open for loops
        - etc

    Step 6: Test our code with our test cases
        public static int[] findTwoSum(int[] numsArray, int target) {  new int[]{1, 3, 9, 7, 2}, 5
        for(int i = 0; i < numsArray.length; i++) { i = 1, 3
            for(int j = i + 1; j < numsArray.length; j++){ i = 3, 4, 5, 2
                if(numsArray[i] + numsArray[j] == target){ // 3 + 2 = 5
                    return new int[]{i, j}; //2, 3
                }
            }
        }
        return null;
    }

    Step 7: Analyze space and time complexity
        In this case:
            Space: O(1)
            Time: O(N^2)

    Step 8: Optimize your solution
        Maybe use more space to reduce time complexity?
        Can we simply the for loops or combine them?

        Use HashMap lookup because time is O(1)
        How do we simply?

        Lets look at our code:
        The first for loop is just used to calculate: target - P1
        The second for loop compares if nums[p2] = target - P1

        Using the hashmap:
        For {1, 3, 9, 7, 2}, target = 5,
        1. we store 5 - 1 = 4 in the hashmap with value: 0 (index),
        2. move p1, check if 4 exists in the map, if not store 5 - 3 = 2 is in the map.
        3. repeat until get have a match.
        4. Return matching key value

     */

    public static int[] twoSumOptimized(int[] nums, int target){
        HashMap<Integer, Integer> lookUpTable = new HashMap<>();
        for(int p = 0; p < nums.length; p++){
            if(lookUpTable.containsKey(nums[p])){
                return new int[]{lookUpTable.get(nums[p]), p};
            } else {
                lookUpTable.put(target - nums[p], p);
            }
        }
        return null;
    }

    /*
     Step 9: Run through your test cases in optimized code

     Step 10: Analyze space and time complexity
        In optimized case, we traded space for time:
            Space: O(N)
            Time: O(N)
     */

    public static void main(String[] args){
//        Arrays.stream(findTwoSum(new int[]{1, 3, 9, 7, 2}, 5)).forEach(i -> System.out.println(i));
        Arrays.stream(twoSumOptimized(new int[]{1, 3, 9, 7, 2}, 5)).forEach(i -> System.out.println(i));
    }

}
