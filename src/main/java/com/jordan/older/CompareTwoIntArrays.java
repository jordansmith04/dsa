package com.jordan.older;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompareTwoIntArrays {


    /**
     * Compare two int arrays. Return a List<List<Integer>> containing only the unique values.
     */
    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<Integer> nums3 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        List<Integer> nums4 = Arrays.stream(nums2).boxed().collect(Collectors.toList());
        for(int i : nums1){
            if(nums4.contains(i)) {
                nums3.remove(nums3.indexOf(i));
                nums4.remove(nums4.indexOf(i));
            }
        }
        List<List<Integer>> returnList = new ArrayList(){{
            add(nums3.stream().distinct().collect(Collectors.toList()));
            add(nums4.stream().distinct().collect(Collectors.toList()));
        }};
        return returnList;
    }

    @Test
    public void checkDifference(){
        int[] nums1 = {1, 2, 2, 4};
        int[] nums2 = {3 , 4, 6, 6};
        List<Integer> nums3 = new ArrayList<Integer>(Arrays.asList(1, 2)){};
        List<Integer> nums4 = new ArrayList<Integer>(Arrays.asList(3, 6)){};
        List<List<Integer>> expected = new ArrayList<List<Integer>>(){{
            add(nums3);
            add(nums4);
        }};
        assertEquals(expected, findDifference(nums1, nums2));
    }
}
