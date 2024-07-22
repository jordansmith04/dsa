package com.jordan.udemy.strings;

import java.util.Arrays;

public class TypedOutStrings {

    /*
     Prompt:
        Subset of array questions

        Give two strings S and T, return if they equal when both are typed out.
        Any '#' that appears in the string counts as backspace.

     Questions:
        - What happens when two hashes appear beside each other?
            Answer: delete two values before the first #.
        - What happens to # when there is no char to remove?
            Answer: deletes nothing
        - Are two empty strings are equal to each other?
            Answer: yes
        - Does case sensitivity matter?
            Answer: YES!

        - Will there be spaces?
            Answer: no
        - Is it possible we have empty strings?
            Answer: yes
        - Do we return false if one string in empty?
            Answer: yes

       Test cases:
            1. S: "", T: "", true
            2. S: "ab#z", T: "az#z", true
            3. S: "atr#", T: "art#", false
            4. S: "#rbg###", S: "p#l#e#WD##", true
            5. S: "Rf#fD", T: "rF#fd", false
     */

    public static boolean typedOutStrings(String S, String T) {
        return parseString(S).equals(parseString(T));
    }

    public static String parseString(String S){
        char[] s_chars = new char[S.length()];
        int counter = 0;
        for(int s = 0; s < S.length(); s++){
            if(S.charAt(s) != '#'){
                s_chars[counter] = S.charAt(s);
            } else if (counter != 0){
                counter -= 1;
                s_chars[counter] = ' ';
            }
        }
        return String.valueOf(s_chars);
    }




    public static void main(String[] args){
        System.out.println(typedOutStrings("#rbg###", "p#l#e#WD##"));
        System.out.println(typedOutStrings("", ""));
        System.out.println(typedOutStrings("Rf#fD", "rF#fd"));


    }
}
