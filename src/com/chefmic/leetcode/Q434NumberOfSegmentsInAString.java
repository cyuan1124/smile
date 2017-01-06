package com.chefmic.leetcode;

/**
 * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
 * <p>
 * Please note that the string does not contain any non-printable characters.
 * <p>
 * Example:
 * <p>
 * Input: "Hello, my name is John"
 * Output: 5
 */
public class Q434NumberOfSegmentsInAString {

    public static void main(String... args) {
        System.out.println("   abcd   edf   ".trim());
    }

    public static int numberOfSegmentsInAString(String string) {
        return string.trim().split("[^\\p{Alnum}]+").length;
    }


}
