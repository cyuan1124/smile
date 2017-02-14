package com.chefmic.leetcode.medium;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by cyuan on 2/12/17.
 */
public class Q388LongestAbsoluteFilePath {

    public static void main(String[] args) {
        String url = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        System.out.println(lengthLongestPath(url));
        System.out.println(lengthLongestPath("A"));
    }

    public static int lengthLongestPath(String input) {
        Stack<Integer> length = new Stack<>();
        String[] paths = input.split("\n");
        int maxLength = 0;
        int curLength = 0;
        for (String path : paths) {
            int level = path.lastIndexOf("\t") + 1;
            int pathLength = path.length() - level + (path.contains(".") ? 0 : 1);
            if (level != length.size()) {
                while (level < length.size()) {
                    curLength -= length.pop();
                }
            }
            curLength += pathLength;
            length.push(pathLength);
            if (path.contains("."))
                maxLength = Math.max(maxLength, curLength);
        }
        return maxLength;
    }

}
