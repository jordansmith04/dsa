package com.jordan.udemy.strings;

public class Palindromes {

    /*
        Prompt:
            Given a string, determine if it is a palindrome, consider only alphanumeric characters and ignore case sensitivity

        Questions:
            - Do spaces count? No
            - How do we handle a single letter? return true

         Test cases:
         1. "", false
         2. "a", true
         3. "amanaplanacanalpanama", true
         4. "falala", false
         5. "A man, a plan, a canal: Panama", true
         6. "8558", true
     */

    public static boolean isPalindromeFromOutside(String s){
        s = filterChars(s);
        if(s.length() <= 1) return true;
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeFromInside(String s){
        s = filterChars(s);
        if(s.length() <= 1) return true;
        int left = s.length() / 2;
        int right = s.length() / 2;
        if(s.length() % 2 == 0){
            left = (s.length() - 1) / 2;
            right = (s.length() + 1) / 2;
        }
        while(left >= 0 && right <= s.length() - 1){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left--;
            right++;
        }
        return true;
    }


   public static String filterChars(String s){
        StringBuilder sb = new StringBuilder();
        for(char c : s.toLowerCase().toCharArray()) {
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                sb.append(c);
            }
        }
        return sb.toString();
    }


    /*
        Prompt 2:
            Given a string, determine if it is almost a palindrome. A string is almost a palindrome if it becomes
            a palindrome by removing 1 letter. Consider only alphanumeric characters and ignore case sensitivity.

        Questions:
            What if it is already a palindrome, meaning no chars need removed? return false
            What if there is only one letter? return true

         Test cases:
         1. "", true
         2. "a", true
         3. "amanaplanabcanalpanama", true
         4. "falala", true
         5. "A man, a plan,8 a canal: Panama", true
         6. "8558", false
     */

    public static boolean almostAPalindrome(String s){
        s = filterChars(s);
        if(s.length() <= 1) return true;
        int left = 0;
        int right = s.length() -1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)) {
                return validSubPalindrome(s, left, right - 1) || validSubPalindrome(s, left + 1, right);
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean validSubPalindrome(String s, int left, int right){
        if(s.length() <= 1) return true;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /*
        Complexity:
            Time: O(N)
            Space: O(1)
     */

    public static void main(String[] args){
        System.out.println(isPalindromeFromOutside("A man, a plan, a canal: Panama"));
        System.out.println(isPalindromeFromOutside("8558"));

        System.out.println(isPalindromeFromInside("A man, a plan, a canal: Panama"));
        System.out.println(isPalindromeFromInside("8558"));

        System.out.println(almostAPalindrome("A man, a plan, acanal: Panama"));
        System.out.println(almostAPalindrome("8b558r"));
        System.out.println(almostAPalindrome("eedede"));
    }


}
