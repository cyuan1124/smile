package com.chefmic.linkedin.newQuestion;

//Given an input string, reverse the string word by word.
//
//For example,
//Given s = " the sky is blue ",
//return " blue is sky the ". 

//
//What constitutes a word?
//A sequence of non-space characters constitutes a word.

//Could the input string contain leading or trailing spaces?
//Yes. However, your reversed string should not contain leading or trailing spaces.

//How about multiple spaces between two words?
//Reduce them to a single space in the reversed string.

public class ReverseWordsinaString {

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String[] array = s.split(" +");
        StringBuilder sb = new StringBuilder();
        for (int i = array.length - 1; i >= 0; i--) {
            sb.append(array[i]).append(" ");
        }
        return sb.length() == 0 ? "" : sb.toString().trim();
    }
}