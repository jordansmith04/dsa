package com.jordan.udemy.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LongestSubstring_SlidingWindow {

    /*
        Prompt:
            Given a string, find the length of the longest substring without repeating characters.


        Questions:
            - Is the substring contiguous?
                Answer: yes, a substring and not a subsequence.
            - Does case sensitivity matter?
                Answer: no, assume all chars are lower case.

         Test cases:
            1. "abccabb", 3
            2. "cccccc", 1
            3. "", 0
            4. "abcbda", 4
     */

    //Brute force solution
    /*
        Logic:
            Start with longest possible string (s.length), check if repeating inside
            reduce longest string by 1, check all possibilities
            return first matching
     */
    public static int maxSubstring(String s) {
        for(int length = s.length(); length >= 0; length--) {
           for(int index = 0; index + length <= s.length(); index++){
                if (!doesSubstringRepeat(s.substring(index, index + length))) {
                    return length;
                }
            }
        }
        return 0;
    }

    public static boolean doesSubstringRepeat(String s){
        HashSet<Character> checked = new HashSet<>();
        for(char c: s.toCharArray()){
            if(!checked.add(c)){
                return false;
            }
        }
        return true;
    }

    public static int maxSubstringBrute2(String s){ //abcbda
        if(s.length() <= 1) return s.length();
        int longest = 0;
        for(int p1 = 0; p1 < s.length(); p1++){
            HashSet<Character> chars = new HashSet<>();
            chars.add(s.charAt(p1));
            for(int p2 = p1 + 1; p2 < s.length(); p2++){
                if(!chars.add(s.charAt(p2))){
                    longest = Math.max(longest, p2 - p1);
                    break;
                } else if (p2 == s.length() - 1){
                    longest = Math.max(longest, (p2 - p1) + 1);
                    break;
                }
            }
        }
        return longest;
    }

    /*
        Brute2
        Space complexity: O(N)
        Time: O(N^2)
     */


    //My solution
    public static int slidingWindowOptimized(String s){ //abcbda //aba
        if(s.length() <= 1) return s.length();
        int max = 1;
        int p1 = 0;
        int p2 = 0;
        HashMap<Character, Integer> seen = new HashMap<>();
        while(p2 < s.length()){
            Character p2_char = s.charAt(p2);
           if(!seen.containsKey(p2_char)){
               seen.put(p2_char, p2);
               max = Math.max(p2 - p1 + 1, max);
               p2++;
           } else {
               p1 = seen.get(p2_char) + 1;
               p2 = p1;
               seen.clear();
           }
       }
        return max;
    }

    //Udemy's
    /*
        Synopsis:
            Right pointer runs through entire array, we move left to recently seen character + 1 every time we repeat.
            max is set on every iteration.
     */
    public static int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) return s.length();
        int max = 0;
        int left = 0;
        HashMap<Character, Integer> seen = new HashMap<>();
        for(int right = 0; right < s.length(); right++){
            char current = s.charAt(right);
            int prevSeenChar = seen.getOrDefault(current, 0);
            if(prevSeenChar >= left){
                left = prevSeenChar + 1;
            }
            seen.put(current, right);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }



    public static void main(String[] args){
//        System.out.println(maxSubstring("abccabb"));
//        System.out.println(maxSubstring("abcbda"));

//        System.out.println(maxSubstringBrute2("abccabb"));
//        System.out.println(maxSubstringBrute2("abcbda"));

        System.out.println(slidingWindowOptimized("abccabb"));
        System.out.println(slidingWindowOptimized("abcbda"));
    }
}
